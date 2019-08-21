package com.ulink.portal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * A Rack.
 */
@Entity
@Table(name = "rack")
public class Rack extends Base {

	private static final long serialVersionUID = 956754699993768470L;

	@Column(name = "sequecne_no")
	private int sequecneNo;

	public int getSequecneNo() {
		return sequecneNo;
	}

	public void setSequecneNo(int sequecneNo) {
		this.sequecneNo = sequecneNo;
	}

}
