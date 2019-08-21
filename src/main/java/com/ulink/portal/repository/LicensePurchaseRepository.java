package com.ulink.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ulink.portal.domain.LicensePurchase;

@Repository
public interface LicensePurchaseRepository extends CrudRepository<LicensePurchase, Long>{

	public Optional<LicensePurchase> findByLicenseId(String licenseId);
	
	@Query(value = "SELECT * FROM license_purchase WHERE license_id=:licenseId and user_id=:userId", nativeQuery = true)
	public Optional<LicensePurchase> findbyLicenseIdAndUserId(String licenseId,Long userId);
	
	@Query(value = "SELECT * FROM license_purchase WHERE license_id=:licenseId and license_type_id=:licenseTypeId", nativeQuery = true)
	public Optional<LicensePurchase> findbyLicenseIdAndLicenseTypeId(String licenseId,Long licenseTypeId);
	
}
