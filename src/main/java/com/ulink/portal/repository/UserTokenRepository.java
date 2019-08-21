package com.ulink.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ulink.portal.domain.UserToken;
import com.ulink.portal.enumeration.TokenType;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, Long>{

	Optional<UserToken> findByTokenTypeAndUserId(TokenType tokenType,Long id);
	
	Optional<UserToken> findByTokenTypeAndToken(TokenType tokenType,String token);
	
	Optional<UserToken> findByTokenTypeAndUserIdAndDeviceId(TokenType tokenType,Long id,String deviceId);
	
	@Modifying
	@Query(value="delete from user_token where user_id=:id and device_id=:deviceId",nativeQuery=true)
	void deleteUserTokenByUserIdAndDeviceId(@Param("id")Long id,@Param("deviceId")String deviceId);
	
	
}

