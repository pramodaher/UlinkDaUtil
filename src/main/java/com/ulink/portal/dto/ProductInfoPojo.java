package com.ulink.portal.dto;

import org.springframework.stereotype.Component;

@Component
public class ProductInfoPojo {
	
	private String model;
	private String productUrl;
	private String imageUrl;
	
	public ProductInfoPojo() {
		
	}

	public ProductInfoPojo(String model, String productUrl, String imageUrl) {
		super();
		this.model = model;
		this.productUrl = productUrl;
		this.imageUrl = imageUrl;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((productUrl == null) ? 0 : productUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductInfoPojo other = (ProductInfoPojo) obj;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (productUrl == null) {
			if (other.productUrl != null)
				return false;
		} else if (!productUrl.equals(other.productUrl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductInfo [model=" + model + ", productUrl=" + productUrl + ", imageUrl=" + imageUrl + "]";
	}
	
	

}
