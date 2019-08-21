package com.ulink.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulink.portal.domain.ProductType;

/**
 * Spring Data repository for the SystemType entity.
 */
@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

	Optional<ProductType> findOneByNameIgnoreCase(String name);

	Optional<ProductType> findByName(String name);

}
