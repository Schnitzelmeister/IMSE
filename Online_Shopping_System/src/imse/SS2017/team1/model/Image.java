package imse.SS2017.team1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@Table(name = "Image")
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Image implements Serializable{

	@Id
	@GeneratedValue
	@Field(name="_id")
	private Integer imageId;
	private Integer productId;
	private String image;
	
	public Integer getImageId() {
		return imageId;
	}
	
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public String getImageString() {
		return image;
	}
	
	public void setImageString(String image) {
		this.image = image;
	}
}
