/**
 * 
 */
package com.ulink.portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author bpawar
 *
 */
@Entity
@Table(name = "role")
public class Role  extends Base{

	private static final long serialVersionUID = 3871649807878382565L;

	@Column(name = "role_name")
	String roleName;
	
	@Column(name = "role_desc")
	String roleDesc;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
	
	
}
