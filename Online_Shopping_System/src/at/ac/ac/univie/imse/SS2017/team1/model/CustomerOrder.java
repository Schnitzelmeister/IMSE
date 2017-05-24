
@Entity
public class CustomerOrder {
	
	@Id
	private Integer orderId
	private String customerEmail;
	private String customerFirstName;
	private String customerLastName;
	private String dateCreated;
	private String dateShipped;
	

}
