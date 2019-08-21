package com.ulink.portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A License.
 */
@Entity
@Table(name = "license_type")
public class LicenseType extends CommonBaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@NotNull
	@Column(name = "name", nullable = false)
	private String name;


	@Column(name = "max_bays")
	private Integer maxBays;

	@Column(name = "description")
	private String description;
	
	@OneToOne
    @JoinColumn(name="product_type_id")
    private ProductType productType;
	
	
	public Integer getMaxBays() {
		return maxBays;
	}

	public void setMaxBays(Integer maxBays) {
		this.maxBays = maxBays;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

    
	
}
