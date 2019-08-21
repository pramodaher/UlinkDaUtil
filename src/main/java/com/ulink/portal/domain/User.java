package com.ulink.portal.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A user.
 */

@Entity
@Table(name = "user")
public class User extends AuditingEntity {

	private static final long serialVersionUID = 3107583970337428568L;

	
	@Size(min = 5, max = 254)
	@Column(length = 254, unique = true)
	private String email;

	@NotNull
	@Size(min = 1)
	@Column(unique = true, nullable = false)
	private String login;

	@JsonIgnore
//	@Size(min = 10)
	private String password;

	@Column(name = "account_id")
	private Long accountId;

	@Column(name = "is_active")
	private boolean isActive;
	
	@ManyToMany
	List<Role> role;
	
	@Fetch(value = FetchMode.SELECT)
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	List<UserToken> userTokens;
	
	@Column(name = "is_profile_fetch")
	private boolean isProfileFetch;
	
	
	@Column(name = "profile_updated_at")
    private Date profileUpdatedAt;
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Role> getRoles() {
		return role;
	}

	public void setRoles(List<Role> roles) {
		this.role = roles;
	}

	public Long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isProfileFetch() {
		return isProfileFetch;
	}

	public void setProfileFetch(boolean isProfileFetch) {
		this.isProfileFetch = isProfileFetch;
	}

	public Date getProfileUpdatedAt() {
		return profileUpdatedAt;
	}

	public void setProfileUpdatedAt(Date profileUpdatedAt) {
		this.profileUpdatedAt = profileUpdatedAt;
	}

	
	
}
