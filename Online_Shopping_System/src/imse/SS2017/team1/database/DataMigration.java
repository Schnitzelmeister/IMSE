package imse.SS2017.team1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	static Statement statement4 = null;
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
			statement4 = connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String args[]) throws Exception {
		DataMigration dm=	new DataMigration();
		
		//dm.migrateAdress();
		//dm.migrateCreditCard();
		//dm.migrateCustomer();
		//dm.migrateAdmin();
		//dm.migrateCategory();
		dm.migrateProduct();
		//dm.migrateImage();
		//dm.migrateProductBelongsCategory();
		//dm.migrateCustomerOrder();
		//dm.migrateOrderDetail();
		
		dm.closeConnection();
	
	}

	private void migrateAdress() {
		Address address = new Address();
		try {

			ResultSet resultset = statement.executeQuery("SELECT * FROM address");

			try {
				while (resultset.next()) {
					int numColumns = resultset.getMetaData().getColumnCount();
					for (int i = 1; i <= numColumns; i += 7) {
						address.setAdressId((Integer) resultset.getObject(i));
						address.setStreetName((String) resultset.getObject(i+1));
						address.setStreetNumber((String) resultset.getObject(i+2));
						address.setAdditionaolInfo((String) resultset.getObject(i+3));
						address.setCity((String) resultset.getObject(i+4));
						address.setPostCode((String) resultset.getObject(i+5));
						address.setCountry((String) resultset.getObject(i+6));
						dao.save(address);
					}
				}
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
			


	}

	private void migrateCreditCard() {
		CreditCard creditCard = new CreditCard();
		try {

			ResultSet resultset = statement.executeQuery("SELECT * FROM creditCard");

			try {
				while (resultset.next()) {
					int numColumns = resultset.getMetaData().getColumnCount();
					for (int i = 1; i <= numColumns; i += 7) {
						creditCard.setCardNumber((String) resultset.getObject(i));
						creditCard.setFirstName((String) resultset.getObject(i+1));
						creditCard.setLastName((String) resultset.getObject(i+2));
						creditCard.setType((String) resultset.getObject(i+3));
						creditCard.setCvv((String) resultset.getObject(i+4));
						creditCard.setExpiryMonth((Integer) resultset.getObject(i+5));
						creditCard.setExpiryYear((Integer) resultset.getObject(i+6));
						dao.save(creditCard);
					}
				}
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void migrateCustomer() {
		Customer customer = new Customer();
		try {

			ResultSet resultset = statement.executeQuery("SELECT * FROM customer");

			try {
				while (resultset.next()) {
					int numColumns = resultset.getMetaData().getColumnCount();
					for (int i = 1; i <= numColumns; i += 8) {
						customer.setEmailAddress((String) resultset.getObject(i));
						customer.setPassword((String) resultset.getObject(i+1));
						customer.setFirstName((String) resultset.getObject(i+2));
						customer.setLastName((String) resultset.getObject(i+3));
						customer.setPhoneNumber((String) resultset.getObject(i+4));
						customer.setCreditCardInfo((String) resultset.getObject(i+5));
						customer.setShippingAddress((Integer) resultset.getObject(i+6));
						customer.setBillingAddress((Integer) resultset.getObject(i+7));
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
		List<Product> productList = new ArrayList();
		Product product = new Product();
		Category category = new Category();
		Image image = new Image();
		try {

			ResultSet resultsetProduct = statement.executeQuery("SELECT * FROM product");
			ResultSet resultsetProductbelCategory = null;
			ResultSet resultsetImage = null;
			
			try {
				while (resultsetProduct.next()) {
					int numColumns = resultsetProduct.getMetaData().getColumnCount();
					for (int i = 1; i <= numColumns; i += 5) {
						
						resultsetProductbelCategory = statement2.executeQuery("SELECT category.categoryId, categoryName FROM productbelongscategory INNER JOIN category ON productbelongscategory.categoryId = category.categoryId WHERE productId="+
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
								category = new Category();
								product.setCategories(dao.getobject(Category.class, (Integer) resultsetProductbelCategory.getObject(j)));
							}
						}
						while (resultsetImage.next()) {
							for(int k = 1; k<= numColumnsImage; k+= 2){
								image = new Image();
								product.setImages(dao.getobject(Image.class, (Integer) resultsetImage.getObject(k)));
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

	private void migrateImage() {
		Image image = new Image();
		try {

			ResultSet resultset = statement.executeQuery("SELECT * FROM image");

			try {
				while (resultset.next()) {
					int numColumns = resultset.getMetaData().getColumnCount();
					for (int i = 1; i <= numColumns; i += 3) {
						image.setImageId((Integer) resultset.getObject(i));
						image.setProductId((Integer) resultset.getObject(i+1));
						image.setImageString((String) resultset.getObject(i+2));
					
						dao.save(image);
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
		CustomerOrder customerOrder = new CustomerOrder();
		try {

			ResultSet resultset = statement.executeQuery("SELECT * FROM customerOrder");

			try {
				while (resultset.next()) {
					int numColumns = resultset.getMetaData().getColumnCount();
					for (int i = 1; i <= numColumns; i += 5) {
						customerOrder.setOrderId((Integer) resultset.getObject(i));
						customerOrder.setDateCreated((String) resultset.getObject(i+1));
						customerOrder.setDateShipped((String) resultset.getObject(i+2));
						customerOrder.setCustomerEmail((String) resultset.getObject(i+3));
						customerOrder.setOrdered(resultset.getBoolean(i+4));
						//customerOrder.setOrdered((Boolean) resultset.getObject(i+4));
					
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

	private void migrateOrderDetail() {
		OrderDetail orderDetail = new OrderDetail();
		try {

			ResultSet resultset = statement.executeQuery("SELECT * FROM orderDetail");

			try {
				while (resultset.next()) {
					int numColumns = resultset.getMetaData().getColumnCount();
					for (int i = 1; i <= numColumns; i += 5) {
						orderDetail.setOrderDetailId((Integer) resultset.getObject(i));
						orderDetail.setOrderId((Integer) resultset.getObject(i+1));
						orderDetail.setQuantity((Integer) resultset.getObject(i+2));
						orderDetail.setSubTotal(Float.valueOf(String.valueOf(resultset.getObject(i+3))));
						orderDetail.setProductId((Integer) resultset.getObject(i+4));
						
						dao.save(orderDetail);
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
