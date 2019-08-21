package com.ulink.portal.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A StorageSystem.
 */
@Entity
@Table(name = "product")
public class Product extends Base {

	private static final long serialVersionUID = -3030732144061365909L;

	@Column(name = "description")
	private String description;

	@Column(name = "image_url")
	private String imageURL;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "number_of_bays")
	private Integer numberOfBays;
	
	@Column(name = "product_url")
	private String productURL;

	@Column(name = "supported_extensions")
	private Integer supportedExtensions;

	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "last_fetch_at")
	private String lastFetchAt;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "created_by")
	private Long createdBy;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "updated_by")
	private Long updatedBy;
	
	@Column(name = "is_fetch")
	private Boolean isFetch;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfBays() {
		return numberOfBays;
	}

	public void setNumberOfBays(Integer numberOfBays) {
		this.numberOfBays = numberOfBays;
	}

	public String getProductURL() {
		return productURL;
	}

	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}

	public Integer getSupportedExtensions() {
		return supportedExtensions;
	}

	public void setSupportedExtensions(Integer supportedExtensions) {
		this.supportedExtensions = supportedExtensions;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getLastFetchAt() {
		return lastFetchAt;
	}

	public void setLastFetchAt(String lastFetchAt) {
		this.lastFetchAt = lastFetchAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Boolean getIsFetch() {
		return isFetch;
	}

	public void setIsFetch(Boolean isFetch) {
		this.isFetch = isFetch;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((imageURL == null) ? 0 : imageURL.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((isFetch == null) ? 0 : isFetch.hashCode());
		result = prime * result + ((lastFetchAt == null) ? 0 : lastFetchAt.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((numberOfBays == null) ? 0 : numberOfBays.hashCode());
		result = prime * result + ((productURL == null) ? 0 : productURL.hashCode());
		result = prime * result + ((supportedExtensions == null) ? 0 : supportedExtensions.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (imageURL == null) {
			if (other.imageURL != null)
				return false;
		} else if (!imageURL.equals(other.imageURL))
			return false;
		if (isActive != other.isActive)
			return false;
		if (isFetch == null) {
			if (other.isFetch != null)
				return false;
		} else if (!isFetch.equals(other.isFetch))
			return false;
		if (lastFetchAt == null) {
			if (other.lastFetchAt != null)
				return false;
		} else if (!lastFetchAt.equals(other.lastFetchAt))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfBays == null) {
			if (other.numberOfBays != null)
				return false;
		} else if (!numberOfBays.equals(other.numberOfBays))
			return false;
		if (productURL == null) {
			if (other.productURL != null)
				return false;
		} else if (!productURL.equals(other.productURL))
			return false;
		if (supportedExtensions == null) {
			if (other.supportedExtensions != null)
				return false;
		} else if (!supportedExtensions.equals(other.supportedExtensions))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (updatedBy == null) {
			if (other.updatedBy != null)
				return false;
		} else if (!updatedBy.equals(other.updatedBy))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [description=" + description + ", imageURL=" + imageURL + ", model=" + model + ", name=" + name
				+ ", numberOfBays=" + numberOfBays + ", productURL=" + productURL + ", supportedExtensions="
				+ supportedExtensions + ", isActive=" + isActive + ", lastFetchAt=" + lastFetchAt + ", createdAt="
				+ createdAt + ", createdBy=" + createdBy + ", updatedAt=" + updatedAt + ", updatedBy=" + updatedBy
				+ ", isFetch=" + isFetch + "]";
	}

	
	
	
}
