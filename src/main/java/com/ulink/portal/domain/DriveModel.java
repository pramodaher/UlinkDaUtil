package com.ulink.portal.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A DriveModel.
 */
@Entity
@Table(name = "drive_model")
public class DriveModel extends Base {

	private static final long serialVersionUID = 8486143792209801771L;

	@NotNull
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description")
	private String description;

//	@Column(name = "is_active")
//	private boolean isActive;
//
//	@Column(name = "is_deleted")
//	private boolean isDeleted;

	@ManyToOne
    @JoinColumn(name = "manufacturer_id")
	private DriveManufacturer manufacturer;

	public String getName() {
		return name;
	}

	public DriveModel name(String name) {
		this.name = name;
		return this;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public DriveModel description(String description) {
		this.description = description;
		return this;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public boolean isIsActive() {
//		return isActive;
//	}
//
//	public DriveModel isActive(boolean isActive) {
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
//	public DriveModel isDeleted(boolean isDeleted) {
//		this.isDeleted = isDeleted;
//		return this;
//	}
//
//	public void setIsDeleted(boolean isDeleted) {
//		this.isDeleted = isDeleted;
//	}

	public DriveManufacturer getManufacturer() {
		return manufacturer;
	}

	public DriveModel manufacturer(DriveManufacturer driveManufacturer) {
		this.manufacturer = driveManufacturer;
		return this;
	}

	public void setManufacturer(DriveManufacturer driveManufacturer) {
		this.manufacturer = driveManufacturer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DriveModel driveModel = (DriveModel) o;
		if (driveModel.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), driveModel.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "DriveModel [name=" + name + ", description=" + description + ", manufacturer=" + manufacturer + "]";
	}

	
	
}
