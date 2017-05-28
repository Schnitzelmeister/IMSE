package imse.SS2017.team1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Image")
public class Image {

	@Id
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
