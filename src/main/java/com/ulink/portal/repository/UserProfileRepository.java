package com.ulink.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulink.portal.domain.User;
import com.ulink.portal.domain.UserProfile;

/**
 * Spring Data repository for the UserProfile entity.
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	Optional<UserProfile> findByEmail(String email);
	
	Optional<UserProfile> findByUser(User user);

}
