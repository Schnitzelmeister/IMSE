package imse.SS2017.team1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;
import org.eclipse.persistence.nosql.annotations.DataFormatType;

@Entity
@Table(name = "ProductBelongsCategory")
@NoSql(dataFormat=DataFormatType.MAPPED)
public class ProductBelongsCategory implements Serializable{
	
	@Id
	@GeneratedValue
	@Field(name="_id")
	private Integer productId;
	
	@Id
	@GeneratedValue
	@Field(name="_id")
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
