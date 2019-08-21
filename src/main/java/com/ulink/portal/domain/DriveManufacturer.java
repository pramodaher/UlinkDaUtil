package com.ulink.portal.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A DriveManufacturer.
 */
@Entity
@Table(name = "drive_manufacturer")
public class DriveManufacturer extends Base {

	private static final long serialVersionUID = 7568783588913825197L;

	@NotNull
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "image_url")
	private String imageUrl;

//	@Column(name = "is_active")
//	private boolean isActive;
//
//	@Column(name = "is_deleted")
//	private boolean isDeleted;

	public String getName() {
		return name;
	}

	public DriveManufacturer name(String name) {
		this.name = name;
		return this;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public DriveManufacturer imageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

//	public boolean isIsActive() {
//		return isActive;
//	}
//
//	public DriveManufacturer isActive(boolean isActive) {
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
//	public DriveManufacturer isDeleted(boolean isDeleted) {
//		this.isDeleted = isDeleted;
//		return this;
//	}
//
//	public void setIsDeleted(boolean isDeleted) {
//		this.isDeleted = isDeleted;
//	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DriveManufacturer driveManufacturer = (DriveManufacturer) o;
		if (driveManufacturer.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), driveManufacturer.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "DriveManufacturer [name=" + name + ", imageUrl=" + imageUrl + "]";
	}

	
}
