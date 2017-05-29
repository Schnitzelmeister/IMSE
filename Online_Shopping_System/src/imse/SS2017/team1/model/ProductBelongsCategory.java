package imse.SS2017.team1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ProductBelongsCategory")
public class ProductBelongsCategory {
	
	@Id
	private Integer productId;
	
	@Id
	private Integer categoryId;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="productId", referencedColumnName="productId")
	private Product product;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="categoryId", referencedColumnName="categoryId")
	private Category category;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}
