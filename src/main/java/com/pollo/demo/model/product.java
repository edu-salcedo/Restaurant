package com.pollo.demo.model;

public class product {

	private int id;
	private String name;
	private String imgUrl;
	private String description;
	private float price;
	private boolean state;
	
	
	public product() {
		super();

	}

	public product(int id, String name, String imgUrl, String description, float price, boolean state) {
		super();
		this.id = id;
		this.name = name;
		this.imgUrl = imgUrl;
		this.description = description;
		this.price = price;
		this.state = state;
	}
	
}
