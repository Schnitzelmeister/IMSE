package at.ac.ac.univie.imse.SS2017.team1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Image {

	@Id
	private Integer imageId;
	private Integer productId;
	private String imageString;
	
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
		return imageString;
	}
	
	public void setImageString(String imageString) {
		this.imageString = imageString;
	}
}
