package com.ulink.portal.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A UserProfile.
 */
@Entity
@Table(name = "user_profile")
public class UserProfile extends AuditingEntity {

	private static final long serialVersionUID = 7064322678811182657L;

//	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@Column(
	        name = "email", 
	        nullable = false, 
	        updatable = false, 
	        unique = true)
	private String email;
	
	@NotNull
	@Column(name = "display_name", nullable = false)
	private String displayName;

	@Column(name = "company_name")
	private String companyName;
	
//	@NotNull
	@Column(name = "contact_no")
	private String contactNo;

//	@NotNull
	@Column(name = "gender")
	private String gender;

	@Column(name = "language")
	private String language;
	
	String address;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;


	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public UserProfile firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public UserProfile lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public UserProfile displayName(String displayName) {
		this.displayName = displayName;
		return this;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return email;
	}

	public UserProfile email(String email) {
		this.email = email;
		return this;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public UserProfile gender(String gender) {
		this.gender = gender;
		return this;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLanguage() {
		return language;
	}

	public UserProfile language(String language) {
		this.language = language;
		return this;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public UserProfile companyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	

	public User getUser() {
		return user;
	}

	public UserProfile user(User user) {
		this.user = user;
		return this;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserProfile userProfile = (UserProfile) o;
		if (userProfile.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), userProfile.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "UserProfile [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", displayName="
				+ displayName + ", companyName=" + companyName + ", contactNo=" + contactNo + ", gender=" + gender
				+ ", language=" + language + ", address=" + address + ", user=" + user + "]";
	}

	
}
