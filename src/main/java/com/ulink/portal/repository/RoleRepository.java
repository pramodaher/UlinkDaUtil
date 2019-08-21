package com.ulink.portal.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ulink.portal.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

	public Optional<Role> findOneByRoleName(String roleName);
	
}
