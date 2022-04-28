package cate_pro.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Category {
	@Id
	@Column(name = "CateId")
	private String cateId;
	@Column(name = "CateName")
	private String cateName;
	@OneToMany(mappedBy = "cate")
	private Set<Product> listPro;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String cateId, String cateName, Set<Product> listPro) {
		super();
		this.cateId = cateId;
		this.cateName = cateName;
		this.listPro = listPro;
	}
	public String getCateId() {
		return cateId;
	}
	public void setCateId(String cateId) {
		this.cateId = cateId;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public Set<Product> getListPro() {
		return listPro;
	}
	public void setListPro(Set<Product> listPro) {
		this.listPro = listPro;
	}
	
	
}
