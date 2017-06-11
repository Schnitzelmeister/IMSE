package imse.SS2017.team1.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.nosql.annotations.NoSql;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;

//		   query = "function() { var ret=[]; var cursor = db.CATEGORY.find({\"_id\":\"5934590A427D5D9E20E75839\"}); while (cursor.hasNext()) { ret.push(cursor.next()); } return ret; }",

@Entity
@Table(name = "category")
@NoSql(dataFormat = DataFormatType.MAPPED)
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Field(name = "_id")
	private String id;

	public String getId() {
		return id;
	}

	/* @Id */
	// we save categoryId for compatibility with RDBMS
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

	// @OneToMany(mappedBy="category")
	// private List<ProductBelongsCategory> products;
}
