package com.dimediary.model.category;

public class Category implements ICategory {

	private String name;

	public Category(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
