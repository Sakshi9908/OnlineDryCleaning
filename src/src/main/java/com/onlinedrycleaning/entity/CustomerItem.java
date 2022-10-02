package com.onlinedrycleaning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "customerItem")
public class CustomerItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itemId")
	private long itemId;

	@Column(name = "name")
	@NotBlank(message = "Name should not be Empty.")
	private String name;

	@Column(name = "color")
	@NotBlank(message = "Name should not be Empty.")
	private String color;

	@Column(name = "category")
	@NotBlank(message = "Name should not be Empty.")
	private String category;

	@Column(name = "quantity")
//	@NotBlank(message = "Name should not be Empty.")
	private int quantity;

	@Column(name = "material")
	@NotBlank(message = "Name should not be Empty.")
	private String material;

	@Column(name = "description")
	@NotBlank(message = "Name should not be Empty.")
	private String description;

	public CustomerItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerItem(long itemId, String name, String color, String category, int quantity, String material,
			String description) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.color = color;
		this.category = category;
		this.quantity = quantity;
		this.material = material;
		this.description = description;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
