package imse.SS2017.team1.model;

import java.io.Serializable;


import javax.persistence.Embeddable;

import javax.persistence.Transient;

import org.eclipse.persistence.nosql.annotations.NoSql;
import org.eclipse.persistence.nosql.annotations.DataFormatType;



@Embeddable
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Image() {
	}
	
	public Image(String image) {
		this.image = image;
	}
	
	private Integer imageId;
	@Transient
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
