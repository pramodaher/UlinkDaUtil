package com.ulink.portal.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Base abstract class for entities which will hold definitions for created,
 * last modified by and created, last modified by date.
 */
@MappedSuperclass
//@Audited
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AuditingEntity extends Base {

	private static final long serialVersionUID = 4997719545994309033L;

	@CreatedBy
	@Column(name = "created_by", nullable = false, length = 50, updatable = false)
	private Long createdBy;

	@CreatedDate
	@Column(name = "created_at", updatable = false)
	private Date createdAt = new Date();

	@LastModifiedBy
	@Column(name = "updated_by", length = 50)
	private Long updatedBy;

	@LastModifiedDate
	@Column(name = "updated_at")
	private Date updatedAt = new Date();

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long lastModifiedBy) {
		this.updatedBy = lastModifiedBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
