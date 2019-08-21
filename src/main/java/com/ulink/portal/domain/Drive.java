package com.ulink.portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A Drive.
 */
@Entity
@Table(name = "drive")
public class Drive extends AuditingEntity {

	private static final long serialVersionUID = 8461228868821987152L;

	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "serial_number")
	private String serialNumber;

	@NotNull
	@Column(name = "slot_number", length = 45)
	private String slotNumber;

	@Column(name = "storage_capacity")
	private Integer storageCapacity;

//	@Column(name = "is_active")
//	private boolean isActive;
//
	@Column(name = "storage_unit")
	private String storageUnit;
	
	@Column(name = "drive_type")
	private String driveType;

	@ManyToOne
	@JoinColumn(name = "interface_type_id")
	private InterfaceType interfaceType;

//	@ManyToOne
//	@JoinColumn(name = "storage_medium_id")
//	private StorageMedium storageMedium;

	@ManyToOne
	@JoinColumn(name = "drive_model_id")
	private DriveModel model;

//	@ManyToOne
//	@JoinColumn(name = "manufacturer_id")
//	private DriveManufacturer manufacturer;

//	@ManyToOne
//	@JoinColumn(name = "rack_id")
//	private Rack rack;


	@ManyToOne
	@JoinColumn(name = "user_product_id")
	private UserProduct userProduct;

	@ManyToOne
	@JoinColumn(name = "raid_config_id")
	private RaidConfig raidConfig;


	@ManyToOne
	@JoinColumn(name = "raid_status_id")
	private RaidStatus status;

	public RaidConfig getRaidConfig() {
		return this.raidConfig;
	}

	public void setRaidConfig(RaidConfig raidConfig) {
		this.raidConfig = raidConfig;
	}

	public String getName() {
		return name;
	}

	public Drive name(String name) {
		this.name = name;
		return this;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public Drive serialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
		return this;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getStorageCapacity() {
		return storageCapacity;
	}

	public Drive storageCapacity(Integer storageCapacity) {
		this.storageCapacity = storageCapacity;
		return this;
	}

	public void setStorageCapacity(Integer storageCapacity) {
		this.storageCapacity = storageCapacity;
	}

//	public boolean isIsActive() {
//		return isActive;
//	}
//
//	public Drive isActive(boolean isActive) {
//		this.isActive = isActive;
//		return this;
//	}
//
//	public void setIsActive(boolean isActive) {
//		this.isActive = isActive;
//	}
//
//	public boolean isIsDeleted() {
//		return isDeleted;
//	}
//
//	public Drive isDeleted(boolean isDeleted) {
//		this.isDeleted = isDeleted;
//		return this;
//	}
//
//	public void setIsDeleted(boolean isDeleted) {
//		this.isDeleted = isDeleted;
//	}

	public InterfaceType getInterfaceType() {
		return interfaceType;
	}

	public Drive interfaceType(InterfaceType interfaceType) {
		this.interfaceType = interfaceType;
		return this;
	}

	public void setInterfaceType(InterfaceType interfaceType) {
		this.interfaceType = interfaceType;
	}

//	public StorageMedium getStorageMedium() {
//		return storageMedium;
//	}
//
//	public Drive storageMedium(StorageMedium storageMedium) {
//		this.storageMedium = storageMedium;
//		return this;
//	}
//
//	public void setStorageMedium(StorageMedium storageMedium) {
//		this.storageMedium = storageMedium;
//	}

	public DriveModel getModel() {
		return model;
	}

	public Drive model(DriveModel driveModel) {
		this.model = driveModel;
		return this;
	}

	public void setModel(DriveModel driveModel) {
		this.model = driveModel;
	}

//	public DriveManufacturer getManufacturer() {
//		return manufacturer;
//	}
//
//	public Drive manufacturer(DriveManufacturer driveManufacturer) {
//		this.manufacturer = driveManufacturer;
//		return this;
//	}
//
//	public void setManufacturer(DriveManufacturer driveManufacturer) {
//		this.manufacturer = driveManufacturer;
//	}
//
//	public Rack getRack() {
//		return rack;
//	}
//
//	public Drive rack(Rack rack) {
//		this.rack = rack;
//		return this;
//	}
//
//	public void setRack(Rack rack) {
//		this.rack = rack;
//	}


	public String getSlotNumber() {
		return this.slotNumber;
	}

	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.interfaceType == null) ? 0 : this.interfaceType.hashCode());
//		result = prime * result + (this.isActive ? 1231 : 1237);
//		result = prime * result + (this.isDeleted ? 1231 : 1237);
//		result = prime * result + ((this.manufacturer == null) ? 0 : this.manufacturer.hashCode());
		result = prime * result + ((this.model == null) ? 0 : this.model.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
//		result = prime * result + ((this.rack == null) ? 0 : this.rack.hashCode());
		result = prime * result + ((this.raidConfig == null) ? 0 : this.raidConfig.hashCode());
		result = prime * result + ((this.serialNumber == null) ? 0 : this.serialNumber.hashCode());
		result = prime * result + ((this.slotNumber == null) ? 0 : this.slotNumber.hashCode());
		result = prime * result + ((this.storageCapacity == null) ? 0 : this.storageCapacity.hashCode());
//		result = prime * result + ((this.storageMedium == null) ? 0 : this.storageMedium.hashCode());
		return result;
	}

	public String getStorageUnit() {
		return storageUnit;
	}

	public void setStorageUnit(String storageUnit) {
		this.storageUnit = storageUnit;
	}

	public RaidStatus getStatus() {
		return status;
	}

	public void setStatus(RaidStatus status) {
		this.status = status;
	}

	public UserProduct getUserProduct() {
		return userProduct;
	}

	public void setUserProduct(UserProduct userProduct) {
		this.userProduct = userProduct;
	}

	public String getDriveType() {
		return driveType;
	}

	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}

	

}
