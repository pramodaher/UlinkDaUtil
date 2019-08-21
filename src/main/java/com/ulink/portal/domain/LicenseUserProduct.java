package com.ulink.portal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "license_user_product")
public class LicenseUserProduct extends Base {

	private static final long serialVersionUID = 7679448205029157977L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "license_purchase_id")
	private LicensePurchase licensePurchase;

	@ManyToOne
	@JoinColumn(name = "user_product_id")
	private UserProduct userProduct;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LicensePurchase getLicensePurchase() {
		return licensePurchase;
	}

	public void setLicensePurchase(LicensePurchase licensePurchase) {
		this.licensePurchase = licensePurchase;
	}

	public UserProduct getUserProduct() {
		return userProduct;
	}

	public void setUserProduct(UserProduct userProduct) {
		this.userProduct = userProduct;
	}
}
