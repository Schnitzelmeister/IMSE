package imse.SS2017.team1.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@Table(name = "category")
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Category implements Serializable{

	@Id
	@GeneratedValue
	@Field(name="_id")
	private Integer categoryId;
	private String categoryName;
	
	public Integer getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	//@OneToMany(mappedBy="category")
	//private List<ProductBelongsCategory> products;
}
