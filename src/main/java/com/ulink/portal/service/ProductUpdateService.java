package com.ulink.portal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ulink.portal.domain.Product;
import com.ulink.portal.dto.ProductInfoPojo;
import com.ulink.portal.repository.ProductRepository;

@Service
public class ProductUpdateService {

	private static final Logger log = LoggerFactory.getLogger(ProductUpdateService.class);
	
	@Autowired
	ProductRepository productRepository;
	

	public void updateStorageSystem()  {

		List<Product> productList = null;

		productList = productRepository.findAll();

		if(productList == null) {
			log.error("unable to fetch product data from database");
			return;
		}
		for(Product product : productList){

			Date updateDate=product.getUpdatedAt();			
			Date currentDate = new Date();
			long diff=0;
			long dayDiff=0;
			if(updateDate!=null){
				
				diff = currentDate.getTime() - updateDate.getTime();
				dayDiff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			}
			

			if((product.getIsFetch() == false) || (product.getIsFetch() == true && dayDiff >= 30)) {

				ProductInfoPojo temp = getProduct(product.getModel());
				if (temp == null) {
					log.error("unable to fetch product Information from qnap site");
					continue;
				} else {
					product.setProductURL(temp.getProductUrl());
					product.setImageURL(temp.getImageUrl());
					product.setIsFetch(true);
					productRepository.save(product);

				}
			}
		}

	}

	public ProductInfoPojo getProduct(String model) {

		List<ProductInfoPojo> productList = getProductInfo();
		
		if(productList==null) {
			return null;
		}	
		for (ProductInfoPojo pInfo : productList) {
			if (pInfo.getModel().equalsIgnoreCase(model)) {
				return pInfo;
			}
		}

		return null;
	}

	public List<ProductInfoPojo> getProductInfo()  {

		List<ProductInfoPojo> productListView = new ArrayList<ProductInfoPojo>();
		Document doc=null;
		
		try {
			 doc = Jsoup.connect("https://www.qnap.com/en/product/").get();
		}
		catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
				
		Elements productList = doc.select("div[class=product-item-wrapper]");
		int size = productList.size();
		for (int i = 0; i < size; i++) {
			Elements product = productList.select("span[class=product-image]").select("a[href]").eq(i);
			Elements image = productList.select("span[class=product-image]").select("img[src~=(?i)\\.(png|jpe?g|gif)]").eq(i);
			Elements model = productList.select("span[class=product-model]").select("a").eq(i);

			String productUrl = "https://www.qnap.com" + product.attr("href");
			String modelNo = model.text();
			String imageUrl = image.attr("src");

			productListView.add(new ProductInfoPojo(modelNo, productUrl, imageUrl));
		}

		return productListView;
	}

}
