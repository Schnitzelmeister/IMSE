package imse.SS2017.team1.model;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
//@Table(name = "product")
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Field(name="_id")
	private String id;
	public String getId() {
		return id;
	}

	/*@Id*/
	//we save productId for compatibility with RDBMS
	private Integer productId;
	private String productName;
	private Float price;
	private String description;
	private Integer quantity;
	
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	//Only for MongoDB, in RDMS we use ProductBelongsCategory class
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Category> categories = new ArrayList<Category>();
	
	public List<Category> getCategories() {
		return categories;
	}

	//Only for MongoDB
	@ElementCollection
	private List<Image> images = new ArrayList<Image>();
	
	public List<Image> getImages() {
		return images;
	}

	
	//@OneToMany(mappedBy="product")
		//private List<ProductBelongsCategory> categories;
}
