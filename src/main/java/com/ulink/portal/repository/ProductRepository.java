package com.ulink.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulink.portal.domain.Product;

/**
 * Spring Data repository for the StorageSystem entity.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByModelIgnoreCase(String model);

	/**@Query(
	        nativeQuery = true,
	        value =
	            "SELECT " +
	            "    st.id, " +
	            "    st.number_of_bays as bays, " +
	            "FROM " +
	            "    user_product s " +
	            "        INNER JOIN " +
	            "    product st ON st.id = s.product " +
	            "WHERE " +
	            "    dr.user_id = :userId " +
	            "ORDER BY s.hour_year DESC ")
	    Object[][] getSystemDriveHealthStats(@Param(value = "userId") long userId);*/

}
