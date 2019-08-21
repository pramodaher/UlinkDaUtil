package com.ulink.portal.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass	
public class CommonBaseModel  implements Serializable, Cloneable {
    /**
     * Primary id.
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * Constructor.
     */
    public CommonBaseModel() {
        // Private constructor to prevent direct instantiation.
    }

    /**
     * Primary id getter.
     */
    public Long getId() {
        return id;
    }

    /**
     * Primary id setter.
     */
    public void setId(final Long id) {
        this.id = id;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommonBaseModel other = (CommonBaseModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
