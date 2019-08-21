package com.ulink.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ulink.portal.domain.LicenseType;

/**
 * Spring Data repository for the License entity.
 */
@Repository
public interface LicenseTypeRepository extends JpaRepository<LicenseType, Long> {

	
	@Query(value = "SELECT * FROM license_type WHERE name=:name", nativeQuery = true)
	public Optional<LicenseType> findByName(String name);
   
	
}
