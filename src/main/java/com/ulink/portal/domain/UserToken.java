package com.ulink.portal.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

import com.ulink.portal.enumeration.TokenType;

@Entity
@Table(name = "user_token")
public class UserToken extends AuditingEntity {

	private static final long serialVersionUID = 5138242777228104342L;

	@Enumerated(EnumType.STRING)
	@Column(name = "token_type")
	TokenType tokenType;

	@Column(name = "token")
	String token;

	@Column(name = "expiration_time")
	Date expirationTime;

	@OneToOne
	User user;

	@NonNull
	@NotEmpty
	@Column(name = "device_id")
	String deviceId;

	public TokenType getTokenType() {
		return tokenType;
	}

	public void setTokenType(TokenType tokenType) {
		this.tokenType = tokenType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserToken() {

	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public UserToken(TokenType tokenType, String token, Date expirationTime, User user, String deviceId) {
		super();
		this.tokenType = tokenType;
		this.token = token;
		this.expirationTime = expirationTime;
		this.user = user;
		this.deviceId = deviceId;
	}

}
