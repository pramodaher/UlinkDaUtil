package com.ulink.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulink.portal.domain.Rack;

/**
 * Spring Data repository for the Rack entity.
 */
@Repository
public interface RackRepository extends JpaRepository<Rack, Long> {

}
