package com.ulink.portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A SystemType.
 */
@Entity
@Table(name = "product_type")
public class ProductType extends Base {

	private static final long serialVersionUID = 296145391756446680L;

	@NotNull
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description")
	private String description;

	public String getName() {
		return name;
	}

	public ProductType name(String name) {
		this.name = name;
		return this;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public ProductType description(String description) {
		this.description = description;
		return this;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
