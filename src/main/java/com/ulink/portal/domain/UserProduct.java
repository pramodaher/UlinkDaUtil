package com.ulink.portal.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * A UserSystem.
 */
@Entity
@Table(name = "user_product")
public class UserProduct extends AuditingEntity {

	private static final long serialVersionUID = 2523676630790000317L;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "product_type_id")
	private ProductType productType;

	@Column(name="serial_number")
	String serialNumber;
	
	@ManyToOne
	@JoinColumn(name = "rack_id")
	private Rack rack;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "parent_user_product_id")
	private UserProduct parentUserProduct;

	@Column(name = "firmware")
	private String firmware;
	
	@Column(name = "operating_system")
	private String operatingSystem;

	@Column(name = "host_id")
	private String hostId;

	@Column(name = "host_ip")
	private String hostIp;
	

	@OneToMany(fetch=FetchType.LAZY,mappedBy="userProduct",cascade=CascadeType.ALL)
	@Fetch(value=FetchMode.SELECT)
	private List<LicenseUserProduct> licenseUserProduct;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Rack getRack() {
		return rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public UserProduct getParentUserProduct() {
		return parentUserProduct;
	}

	public void setParentUserProduct(UserProduct parentUserProduct) {
		this.parentUserProduct = parentUserProduct;
	}

	public String getFirmware() {
		return firmware;
	}

	public void setFirmware(String firmware) {
		this.firmware = firmware;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
	}

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public List<LicenseUserProduct> getLicenseUserProduct() {
		return licenseUserProduct;
	}

	public void setLicenseUserProduct(List<LicenseUserProduct> licenseUserProduct) {
		this.licenseUserProduct = licenseUserProduct;
	}

	

	
	
	

}
