package edu.sxu.entity;

public class Category {
	private Integer id;
	private String name;
	private String cdesc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", cdesc=" + cdesc + "]";
	}
	

}
