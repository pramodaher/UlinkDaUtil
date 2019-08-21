package com.ulink.portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author bpawar
 *
 */
@Entity
@Table(name = "raid_config")
public class RaidConfig extends Base {

	private static final long serialVersionUID = 5933292943854882107L;

	@Column(name = "group_id")
	private long groupId;
	private String type;

	public RaidConfig() {
		// TODO Auto-generated constructor stub
	}

	public RaidConfig(long groupId, String type) {
		super();
		this.groupId = groupId;
		this.type = type;
	}

	public long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (this.groupId ^ (this.groupId >>> 32));
		result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RaidConfig other = (RaidConfig) obj;
		if (this.groupId != other.groupId)
			return false;
		if (this.type == null) {
			if (other.type != null)
				return false;
		} else if (!this.type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RaidConfig [groupId=" + this.groupId + ", type=" + this.type + "]";
	}

}
