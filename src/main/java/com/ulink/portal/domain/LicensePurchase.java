package com.ulink.portal.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.ulink.portal.enumeration.GracePeriodUnit;

/**
 * A SystemLicense.
 */
@Entity
@Table(name = "license_purchase")
public class LicensePurchase extends AuditingEntity {

	private static final long serialVersionUID = 1628016131802382622L;

	@Column(name="license_token")
	private String licenseToken;
	
	@NotNull
	@Column(name = "purchase_date", nullable = false)
	private Date purchaseDate;

	@Column(name="license_id")
	String licenseId;
	
	@NotNull
	@Column(name = "is_active", nullable = false)
	private boolean isActive;
	

	@Column(name = "activation_date", nullable = false)
	private Date activationDate;

	@Column(name = "expiration_date", nullable = false)
	private Date expirationDate;
	
	@Column(name = "deactivation_date", nullable = false)
	private Date deactivationDate;
	
	
	@Column(name="grace_period")
	int gracePeriod;
	
	@Column (name="grace_period_unit")
	@Enumerated(EnumType.STRING)
	GracePeriodUnit gracePeriodUnit;

	@OneToOne
	@JoinColumn(name = "license_type_id")
	private LicenseType licenseType;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	User user;
	

	@OneToMany(fetch=FetchType.LAZY,mappedBy="licensePurchase",cascade=CascadeType.ALL)
	@Fetch(value=FetchMode.SELECT)
	List<LicenseUserProduct> userProduct;

	
	@Column(name="parent_license_purchase_id")
	Long parentLicensePurchaseId;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;
	
	public Long getParentLicensePurchaseId() {
		return parentLicensePurchaseId;
	}

	public void setParentLicensePurchaseId(Long parentLicensePurchaseId) {
		this.parentLicensePurchaseId = parentLicensePurchaseId;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getLicenseToken() {
		return licenseToken;
	}

	public void setLicenseToken(String licenseToken) {
		this.licenseToken = licenseToken;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}


	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getGracePeriod() {
		return gracePeriod;
	}

	public void setGracePeriod(int gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	public GracePeriodUnit getGracePeriodUnit() {
		return gracePeriodUnit;
	}

	public void setGracePeriodUnit(GracePeriodUnit gracePeriodUnit) {
		this.gracePeriodUnit = gracePeriodUnit;
	}

	public LicenseType getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(LicenseType licenseType) {
		this.licenseType = licenseType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Date getDeactivationDate() {
		return deactivationDate;
	}

	public void setDeactivationDate(Date deactivationDate) {
		this.deactivationDate = deactivationDate;
	}

	public List<LicenseUserProduct> getUserProduct() {
		return userProduct;
	}

	public void setUserProduct(List<LicenseUserProduct> userProduct) {
		this.userProduct = userProduct;
	}

	

 
}
