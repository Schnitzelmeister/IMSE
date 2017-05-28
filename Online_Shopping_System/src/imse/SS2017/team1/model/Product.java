package imse.SS2017.team1.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	private Integer productId;
	private String productName;
	private Float price;
	private String description;
	//ArrayList<Image> image=new ArrayList<Image>();
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
