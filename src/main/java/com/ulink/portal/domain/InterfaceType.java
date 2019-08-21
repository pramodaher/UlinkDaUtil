package com.ulink.portal.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A InterfaceType.
 */
@Entity
@Table(name = "interface_type")
public class InterfaceType extends Base {

	private static final long serialVersionUID = 6247404980575133279L;

	@NotNull
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description")
	private String description;

	public String getName() {
		return name;
	}

	public InterfaceType name(String name) {
		this.name = name;
		return this;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public InterfaceType description(String description) {
		this.description = description;
		return this;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		InterfaceType interfaceType = (InterfaceType) o;
		if (interfaceType.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), interfaceType.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "InterfaceType{" + "id=" + getId() + ", name='" + getName() + "'" + ", description='" + getDescription()
		        + "'" + "}";
	}
}
