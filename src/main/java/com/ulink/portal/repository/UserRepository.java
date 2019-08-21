package com.ulink.portal.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulink.portal.domain.User;

/**
 * Spring Data JPA repository for the User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	String USERS_BY_LOGIN_CACHE = "usersByLogin";

	String USERS_BY_EMAIL_CACHE = "usersByEmail";

	/* Optional<User> findOneByActivationKey(String activationKey); */

	Optional<User> findOneByEmailIgnoreCase(String email);

	Optional<User> findOneByLogin(String login);

	/*
	 * @EntityGraph(attributePaths = "authorities") Optional<User>
	 * findOneWithAuthoritiesById(Long id);
	 * 
	 * @EntityGraph(attributePaths = "authorities")
	 * 
	 * @Cacheable(cacheNames = USERS_BY_LOGIN_CACHE) Optional<User>
	 * findOneWithAuthoritiesByLogin(String login);
	 * 
	 * @EntityGraph(attributePaths = "authorities")
	 * 
	 * @Cacheable(cacheNames = USERS_BY_EMAIL_CACHE) Optional<User>
	 * findOneWithAuthoritiesByEmail(String email);
	 */

	Page<User> findAllByLoginNot(Pageable pageable, String login);

	Optional<User> findByEmail(String mail);
}
