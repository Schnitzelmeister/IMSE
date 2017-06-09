package imse.SS2017.team1.searchengine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.jpa.JpaEntityManager;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import imse.SS2017.team1.controller.CategoryController;
import imse.SS2017.team1.model.Category;

public class SearchEngineMongoDB implements SearchEngine {
	public final static int SORT_BY_PRICE_ASC = 0;
	public final static int SORT_BY_PRICE_DESC = 1;
	public final static int SORT_BY_NAME = 2;
	
	private final static int pageSize = 10;

	private static Map<Integer, String> categories = null;
	
	public static void Initialize() {
		categories = new TreeMap<Integer, String>();
		CategoryController cc = new CategoryController();
		for (Category c : cc.getAllCategories() ) {
			categories.put(c.getCategoryId(), c.getCategoryName());
		}
	}

	/*
	@Override
	public String getCategoryNameById(int id){
		return categories.get(id);
	}
	
	@Override
	public Map<Integer, String> getCategories() {
		return categories;
	}*/


	@Override
	public FoundResult getResults(String searchText, int categoryId, int sortMode) throws IllegalArgumentException {
		return getResults(searchText, categoryId, sortMode, 0);
	}
	
	@Override
	public FoundResult getResults(String searchText, int categoryId, int sortMode, int pageNumber) throws IllegalArgumentException {
		searchText = searchText.replaceAll("'", "''");
		
		if (categories == null)
			Initialize();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Online_Shopping_System");
		EntityManager em = emf.createEntityManager();
		
		
		try {
			// To connect to mongodb server
			MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			// Get DB
			DB db = mongoClient.getDB( "online_shop" );
			// Get Collection			
			DBCollection coll = db.getCollection("PRODUCT");
			
			//Aggregate Params
			List<DBObject> params = new ArrayList<DBObject>();
			if (searchText != null && searchText.length() != 0)
				params.add(new BasicDBObject("$match", new BasicDBObject("PRODUCTNAME", java.util.regex.Pattern.compile(searchText))));
			//params.add(new BasicDBObject("$project",  new BasicDBObject("_id", 1).append("CATEGORIES__id", 1) ));
			params.add(new BasicDBObject("$lookup",  new BasicDBObject("from", "CATEGORY").append("localField", "CATEGORIES__id").append("foreignField", "_id").append("as", "CATEGORIES") ));
			params.add(new BasicDBObject("$unwind", "$CATEGORIES"));
			params.add(new BasicDBObject("$group",  new BasicDBObject("_id", "$CATEGORIES.CATEGORYID").append("count", new BasicDBObject("$sum", 1) ) ));
			
			//stats results
			AggregationOutput output = coll.aggregate(params);
			Map<Integer, Integer> foundCategoriesStat = new TreeMap<Integer, Integer>();
			
			//System.out.println("====================================================");
		    for (DBObject dbObject : output.results())
		    {
		        //System.out.println(dbObject);
		        //System.out.println(dbObject.get("_id"));
		        //System.out.println(dbObject.get("count"));
				foundCategoriesStat.put((int)dbObject.get("_id"), (int)dbObject.get("count"));
		    }
			//System.out.println("====================================================");
		    
		    output = null;
		    
		    
		    params.clear();
		    //Aggregate Params
		    if (searchText != null && searchText.length() != 0)
				params.add(new BasicDBObject("$match", new BasicDBObject("PRODUCTNAME", java.util.regex.Pattern.compile(searchText))));
			params.add(new BasicDBObject("$lookup",  new BasicDBObject("from", "CATEGORY").append("localField", "CATEGORIES__id").append("foreignField", "_id").append("as", "CATEGORIES") ));

			if (categoryId == 0) {
				params.add(new BasicDBObject("$project",  new BasicDBObject("_id", 0).append("PRODUCTID", 1).append("PRODUCTNAME", 1).append("PRICE", 1).append("DESCRIPTION", 1).append("QUANTITY", 1).append("CATEGORIES", "$CATEGORIES.CATEGORYID").append("IMAGES", "$IMAGES.IMAGE") ));
			}
			else {
				params.add(new BasicDBObject("$project",  new BasicDBObject("_id", 0).append("PRODUCTID", 1).append("PRODUCTNAME", 1).append("PRICE", 1).append("DESCRIPTION", 1).append("QUANTITY", 1).append("CATEGORIES", "$CATEGORIES.CATEGORYID").append("IMAGES", "$IMAGES.IMAGE").append("isCat", 
						new BasicDBObject("$setIsSubset", 
								Arrays.<Object> asList(
						                Arrays.<Object> asList(categoryId), "$CATEGORIES.CATEGORYID")
								) ) ));
				params.add(new BasicDBObject("$match", new BasicDBObject("isCat", true)));
			}

			if (pageNumber != 0)
				params.add(new BasicDBObject("$skip", (pageNumber * pageSize) ));

			params.add(new BasicDBObject("$limit", pageSize));
			switch (sortMode) {
				case SORT_BY_PRICE_DESC: params.add(new BasicDBObject("$sort", new BasicDBObject("PRICE", -1))); break;
				case SORT_BY_PRICE_ASC: params.add(new BasicDBObject("$sort", new BasicDBObject("PRICE", 1))); break;
				case SORT_BY_NAME: params.add(new BasicDBObject("$sort", new BasicDBObject("PRODUCTNAME", 1))); break;
				default: throw new IllegalArgumentException("Sort Mode not implemented");
			}
			
			//results
			output = coll.aggregate(params);
			List<FoundProduct> foundProducts = new ArrayList<FoundProduct>();
			
			System.out.println("====================================================");
		    for (DBObject dbObject : output.results())
		    {
		    	System.out.println(dbObject);
		    	
				@SuppressWarnings("unchecked")
				List<DBObject> docCats = (List<DBObject>) dbObject.get("CATEGORIES");
				StringBuilder cats = new StringBuilder();
				for (int i=0; i < docCats.size(); ++i) {
					cats.append(docCats.get(i));
					cats.append(",");
				}
				if (cats.length() > 0)
					cats.setLength(cats.length() - 1);
//				System.out.println("cats="+cats.toString());
				
				
				@SuppressWarnings("unchecked")
				List<DBObject> docPics = (List<DBObject>) dbObject.get("IMAGES");
				String[] pics = new String[docPics.size()];
				System.out.println("docPics.size()=" +docPics.size());
				for (int i=0; i < docPics.size(); ++i) {
					pics[i] = String.valueOf( docPics.get(i) );
				}
				
				System.out.println("ready");
				
				foundProducts.add(new FoundProduct( (int)dbObject.get("PRODUCTID"), (String)dbObject.get("PRODUCTNAME"), 
						(double)dbObject.get("PRICE"), (String)dbObject.get("DESCRIPTION"), (int)dbObject.get("QUANTITY"), 
						cats.toString(), pics) );
		    }
		    System.out.println("====================================================");
			
			mongoClient.close();

			return new FoundResult(categories, foundProducts, foundCategoriesStat, searchText, categoryId, sortMode, pageNumber, pageSize);
		}
		catch(Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		return null;
	}
	
	/*
	public static void GenerateXML(String xmlPath) throws IllegalArgumentException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Online_Shopping_System");
		EntityManager em = emf.createEntityManager();
		
		//categories.xml
		String sql = "SELECT cat.categoryId, cat.categoryName FROM imse.category cat;";
		Query qstat = em.createNativeQuery(sql);
		List<Object[]> dataRaws = qstat.getResultList();
		
		try {
		    PrintWriter writer = new PrintWriter(xmlPath + "categories.xml", "UTF-8");
		    writer.println("<categories>");
			for (Object[] data : dataRaws)
			    writer.println("<category id=\"" + (int)data[0] + "\" name=\"" + (String)data[1] + "\" />");
			writer.println("</categories>");
		    writer.close();
		} catch (IOException e) {
			throw new IllegalArgumentException("IOException error: " + e.getMessage());
		}

	}*/
}

