/**
 * 
 */
package com.ulink.portal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ulink.portal.domain.LicenseUserProduct;
import com.ulink.portal.domain.UserProduct;

/**
 * @author sourabh
 *
 */
public interface LicenseUserProductRepository extends CrudRepository<LicenseUserProduct, Long> {

	@Query(value = "SELECT * FROM license_user_product WHERE user_product_id=:userProductId", nativeQuery = true)
	List<LicenseUserProduct> findByUserProduct(Long userProductId);

	Optional<LicenseUserProduct> findByUserProduct(UserProduct userProduct);

}
