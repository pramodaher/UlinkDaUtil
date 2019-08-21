package com.ulink.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulink.portal.domain.DriveModel;

/**
 * Spring Data repository for the DriveModel entity.
 */
@Repository
public interface DriveModelRepository extends JpaRepository<DriveModel, Long> {

	Optional<DriveModel> findByNameIgnoreCase(String name);

}
