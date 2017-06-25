package imse.SS2017.team1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.Address;
import imse.SS2017.team1.model.Admin;
import imse.SS2017.team1.model.Category;
import imse.SS2017.team1.model.CreditCard;
import imse.SS2017.team1.model.Customer;
import imse.SS2017.team1.model.CustomerOrder;
import imse.SS2017.team1.model.Image;
import imse.SS2017.team1.model.OrderDetail;
import imse.SS2017.team1.model.Product;

public class DataMigration {

	static Connection connect = null;
	static Statement statement = null;
	static Statement statement2 = null;
	static Statement statement3 = null;
	Dao dao = new Dao();

	public DataMigration() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/imse", "root", "born2kil");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement = connect.createStatement();
			statement2 = connect.createStatement();
			statement3 = connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String args[]) throws Exception {
		DataMigration dm=	new DataMigration();
		
		dm.migrateCustomer();
		dm.migrateAdmin();
		dm.migrateCategory();
		dm.migrateProduct();
		dm.migrateCustomerOrder();
		dm.closeConnection();
	
	}

	private void migrateCustomer() {
		Customer customer = new Customer();
		CreditCard creditcard = new CreditCard();
		Address address = new Address();
		
		try {

			ResultSet resultset = statement.executeQuery("SELECT * FROM customer");
			ResultSet resultsetCreditCards = null;
			ResultSet resultsetDelAddress = null;

			try {
				
				while (resultset.next()) {
					
					int numColumns = resultset.getMetaData().getColumnCount();
					for (int i = 1; i <= numColumns; i += 8) {
						
						resultsetCreditCards = statement2.executeQuery("SELECT * FROM creditcard WHERE cardnumber='" +
								((String) resultset.getObject(i+5))+"'");
						int numColumnsCreditCard = resultsetCreditCards.getMetaData().getColumnCount();
						
						resultsetDelAddress = statement3.executeQuery("SELECT * FROM address WHERE addressID="+
								((Integer) resultset.getObject(i+6)));
						int numColumnsDelAddress = resultsetDelAddress.getMetaData().getColumnCount();
						
						customer = new Customer();
						customer.setEmailAddress((String) resultset.getObject(i));
						customer.setPassword((String) resultset.getObject(i+1));
						customer.setFirstName((String) resultset.getObject(i+2));
						customer.setLastName((String) resultset.getObject(i+3));
						customer.setPhoneNumber((String) resultset.getObject(i+4));
						customer.setCreditCardInfo((String) resultset.getObject(i+5));
						customer.setShippingAddress((Integer) resultset.getObject(i+6));
						customer.setBillingAddress((Integer) resultset.getObject(i+7));
						
						while (resultsetCreditCards.next()) {
							for (int j = 1; j <= numColumnsCreditCard; j += 7) {
								creditcard = new CreditCard();
								creditcard.setCardNumber((String) resultsetCreditCards.getObject(j));
								creditcard.setFirstName((String) resultsetCreditCards.getObject(j+1));
								creditcard.setLastName((String) resultsetCreditCards.getObject(j+2));
								creditcard.setType((String) resultsetCreditCards.getObject(j+3));
								creditcard.setCvv((String) resultsetCreditCards.getObject(j+4));
								creditcard.setExpiryMonth((Integer) resultsetCreditCards.getObject(j+5));
								creditcard.setExpiryYear((Integer) resultsetCreditCards.getObject(j+6));
							}
						}
						customer.setCreditCard(creditcard);
						
						while (resultsetDelAddress.next()){
							for(int k = 1; k <= numColumnsDelAddress; k += 7){
								address = new Address();
								address.setAdressId(Integer.valueOf(String.valueOf(resultsetDelAddress.getObject(k))));
								address.setStreetName((String) resultsetDelAddress.getObject(k+1));
								address.setStreetNumber((String) resultsetDelAddress.getObject(k+2));
								address.setAdditionaolInfo((String) resultsetDelAddress.getObject(k+3));
								address.setCity((String) resultsetDelAddress.getObject(k+4));
								address.setPostCode((String) resultsetDelAddress.getObject(k+5));
								address.setCountry((String) resultsetDelAddress.getObject(k+6));
							}
						}
						customer.setShippingAdr(address);
						customer.setBillingAdr(address);
						
						dao.save(customer);
					}
				}
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void migrateAdmin() {
		Admin admin = new Admin();
		try {

			ResultSet resultset = statement.executeQuery("SELECT * FROM admin");

			try {
				while (resultset.next()) {
					int numColumns = resultset.getMetaData().getColumnCount();
					for (int i = 1; i <= numColumns; i += 6) {
						admin = new Admin();
						admin.setEmailAddress((String) resultset.getObject(i));
						admin.setPassword((String) resultset.getObject(i+1));
						admin.setFirstName((String) resultset.getObject(i+2));
						admin.setLastName((String) resultset.getObject(i+3));
						admin.setVerified(Boolean.valueOf(String.valueOf((resultset.getObject(i+4)))));
						admin.setManagerEmailAddress((String) resultset.getObject(i+5));
						
						dao.save(admin);
					}
				}
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void migrateProduct() {
		
		Product product = new Product();
		Image image = new Image();
		
		try {

			ResultSet resultsetProduct = statement.executeQuery("SELECT * FROM product");
			ResultSet resultsetProductbelCategory = null;
			ResultSet resultsetImage = null;
			
			try {
				while (resultsetProduct.next()) {
					int numColumns = resultsetProduct.getMetaData().getColumnCount();
					for (int i = 1; i <= numColumns; i += 5) {
						
						resultsetProductbelCategory = statement2.executeQuery("SELECT category.categoryId, categoryName "
								+ "FROM productbelongscategory INNER JOIN category ON productbelongscategory.categoryId = category.categoryId "
								+ "WHERE productId="+
								(Integer) resultsetProduct.getObject(i));
						int numColumnsCategory = resultsetProductbelCategory.getMetaData().getColumnCount();
						
						resultsetImage = statement3.executeQuery("SELECT * FROM image WHERE productId=" +
								(Integer) resultsetProduct.getObject(i));
						int numColumnsImage = resultsetImage.getMetaData().getColumnCount();
						
						product = new Product();
						product.setProductId((Integer) resultsetProduct.getObject(i));
						product.setProductName((String) resultsetProduct.getObject(i+1));
						product.setPrice(Float.valueOf(String.valueOf(resultsetProduct.getObject(i+2))));
						product.setDescription((String) resultsetProduct.getObject(i+3));
						product.setQuantity((Integer) resultsetProduct.getObject(i+4));
						
						while (resultsetProductbelCategory.next()) {
							for(int j = 1; j<= numColumnsCategory; j+= 2){
								product.setCategories(dao.getobject(Category.class, (Integer) resultsetProductbelCategory.getObject(j)));
							}
						}
						
						while (resultsetImage.next()) {
							for(int k = 1; k<= numColumnsImage; k+= 2){
								image = new Image();
								image.setImageId((Integer) resultsetImage.getObject(i));
								image.setProductId((Integer) resultsetImage.getObject(i+1));
								image.setImageString((String) resultsetImage.getObject(i+2));
								product.setImages(image);
							}					
						}
						
						dao.save(product);
					}
				}
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void migrateCategory() {
		Category category = new Category();
		try {

			ResultSet resultset = statement.executeQuery("SELECT * FROM category");

			try {
				while (resultset.next()) {
					int numColumns = resultset.getMetaData().getColumnCount();
					for (int i = 1; i <= numColumns; i += 2) {
						category = new Category();
						category.setCategoryId((Integer) resultset.getObject(i));
						category.setCategoryName((String) resultset.getObject(i + 1));
						dao.save(category);
					}
				}
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	

	private void migrateCustomerOrder() {
		OrderDetail orderDetail=new OrderDetail();
		try {

			ResultSet resultSetOrder = statement.executeQuery("SELECT * FROM customerOrder");

			try {
				while (resultSetOrder.next()) {
					int numColumns = resultSetOrder.getMetaData().getColumnCount();
					for (int i = 1; i <= numColumns; i += 5) {
						CustomerOrder customerOrder = new CustomerOrder();
						customerOrder.setOrderId((Integer) resultSetOrder.getObject(i));
						customerOrder.setDateCreated((String) resultSetOrder.getObject(i+1));
						customerOrder.setDateShipped((String) resultSetOrder.getObject(i+2));
						customerOrder.setCustomerEmail((String) resultSetOrder.getObject(i+3));
						customerOrder.setOrdered(resultSetOrder.getBoolean(i+4));
						//customerOrder.setOrdered((Boolean) resultset.getObject(i+4));
						ResultSet resultSetOrderDetail = statement2.executeQuery("SELECT * FROM orderdetail WHERE orderId=" +
								(Integer) resultSetOrder.getObject(i));
						int numColumnsOrderDetail = resultSetOrderDetail.getMetaData().getColumnCount();
						
						while (resultSetOrderDetail.next()) {
							for(int j = 1; j<= numColumnsOrderDetail; j+= 5){
								
								orderDetail=new OrderDetail();
								orderDetail.setOrderDetailId((Integer)resultSetOrderDetail.getObject(j));
								orderDetail.setOrderId((Integer)resultSetOrderDetail.getObject(j+1));
								orderDetail.setQuantity((Integer)resultSetOrderDetail.getObject(j+2));
								orderDetail.setSubTotal((Float.valueOf(String.valueOf(resultSetOrderDetail.getObject(j+3)))));
								orderDetail.setProductId((Integer)resultSetOrderDetail.getObject(j+4));
								customerOrder.setOrderDetail(orderDetail);
							
							}					
						}
						
						
						
						dao.save(customerOrder);
					}
				}
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void closeConnection(){
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (connect != null) {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
