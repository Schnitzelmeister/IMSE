package imse.SS2017.team1.searchengine;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.jpa.JpaEntityManager;

import imse.SS2017.team1.controller.CategoryController;
import imse.SS2017.team1.model.Category;


public class SearchEngineRDBMS implements SearchEngine {
	public final static int SORT_BY_PRICE_DESC = 0;
	public final static int SORT_BY_PRICE_ASC = 1;
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
		
		String sql = "SELECT prod2cat.categoryId, COUNT(prod.productId) "
				+ "FROM imse.product prod "
				+ "INNER JOIN imse.ProductBelongsCategory prod2cat "
				+ "	on prod2cat.productId = prod.productId "+ ((categoryId == 0) ?  ("") : ("and prod2cat.categoryId=" + categoryId + " "))
				+ ((searchText == null || searchText.length() == 0) ? ("") : ("WHERE prod.productName LIKE '%" + searchText +"%' "))
				+ "GROUP BY prod2cat.categoryId;";
		
		Query qstat = em.createNativeQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> dataRaws = qstat.getResultList();
		Map<Integer, Integer> foundCategoriesStat = new TreeMap<Integer, Integer>();

		
		for (Object[] data : dataRaws) {
			foundCategoriesStat.put((int)data[0], java.lang.Math.toIntExact((long)data[1]));
		}
		
		org.eclipse.persistence.sessions.Session session = ((JpaEntityManager)em.getDelegate()).getActiveSession();
		session.executeNonSelectingSQL("SET group_concat_max_len = 1000000;");
		
		sql = "SELECT prod.productId, prod.productName, prod.price, prod.description, prod.quantity, prod.cats, "
				//+ "GROUP_CONCAT(CONCAT('\"',REPLACE(img.image,'\"','\"\"'),'\"') SEPARATOR ' ') imgs "
				+ "GROUP_CONCAT(img.image SEPARATOR '\"') imgs "
				+ "FROM (SELECT prod.productId, prod.productName, prod.price, prod.description, prod.quantity, "
				+ "GROUP_CONCAT(prod2cat.categoryId SEPARATOR ',') cats "
				+ "FROM imse.product prod "
				+ "INNER JOIN imse.ProductBelongsCategory prod2cat "
				+ "	on prod2cat.productId = prod.productId "
				+ ((categoryId == 0) ?  ("") : ("INNER JOIN imse.ProductBelongsCategory p2c "
						+ "	on p2c.productId = prod.productId and p2c.categoryId=" + categoryId + " "))
				+ ((searchText == null || searchText.length() == 0) ? ("") : ("WHERE prod.productName LIKE '%" + searchText +"%' "))
				+ "GROUP BY prod.productId ";
		
		switch (sortMode) {
			case SORT_BY_PRICE_DESC: sql = sql + "ORDER BY prod.price DESC "; break;
			case SORT_BY_PRICE_ASC: sql = sql + "ORDER BY prod.price ASC "; break;
			case SORT_BY_NAME: sql = sql + "ORDER BY prod.productName ASC "; break;
			default: throw new IllegalArgumentException("Sort Mode not implemented");
		}
		
		sql = sql + "LIMIT " + pageSize + " OFFSET " + pageNumber * pageSize + ") prod "
				+ "LEFT OUTER JOIN imse.image img "
				+ "	on img.productId = prod.productId;";

		System.out.println("sql="+sql);
		
		Query qprod = em.createNativeQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> prodRaws = qprod.getResultList();
		List<FoundProduct> foundProducts = new ArrayList<FoundProduct>();

		//System.out.println("prodRaws/len="+prodRaws.size());
		for (Object[] data : prodRaws) {
			//i think error in em.createNativeQuery
			if (data[0] == null) break; 
			//System.out.println("(String)data[6].len="+((String)data[6]).length());
			//System.out.println("(int)data[0]="+(int)data[0]);
			//System.out.println("(String)data[6]="+(String)data[6]);
			foundProducts.add(new FoundProduct( (int)data[0], (String)data[1], ((BigDecimal)data[2]).doubleValue(), (String)data[3], (int)data[4], (String)data[5], /*imgs.toArray(new String[imgs.size()])*/ ((String)data[6]).split("\"")) );
		}
		return new FoundResult(categories, foundProducts, foundCategoriesStat, searchText, categoryId, sortMode, pageNumber, pageSize);
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
