package com.ulink.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ulink.portal.domain.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
