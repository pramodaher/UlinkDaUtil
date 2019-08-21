package com.ulink.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulink.portal.domain.RaidConfig;

/**
 * @author bpawar
 *
 */
@Repository
public interface RaidConfigRepository extends JpaRepository<RaidConfig, Long>{

}
