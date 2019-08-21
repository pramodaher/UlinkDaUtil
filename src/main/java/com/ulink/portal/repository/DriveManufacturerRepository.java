package com.ulink.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulink.portal.domain.DriveManufacturer;

/**
 * Spring Data repository for the DriveManufacturer entity.
 */
@Repository
public interface DriveManufacturerRepository extends JpaRepository<DriveManufacturer, Long> {

	Optional<DriveManufacturer> findByName(String name);
	


}
