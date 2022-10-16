package com.jbk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Staff {

	@Id
	private int staffId;
	
	@NotNull(message = "StaffName is required")
	private String staffName;
	
	@NotNull(message = "StaffDesignation is required")
	private String staffDesignation;
	
	@NotNull(message = "StaffGender is required")
	private String staffGender;
	
	@NotNull(message = "StaffRole is required")
	private String staffRole;

	public Staff() {
		super();
	}

	public Staff(int staffId, @NotNull(message = "StaffName is required") String staffName,
			@NotNull(message = "StaffDesignation is required") String staffDesignation,
			@NotNull(message = "StaffGender is required") String staffGender,
			@NotNull(message = "StaffRole is required") String staffRole) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffDesignation = staffDesignation;
		this.staffGender = staffGender;
		this.staffRole = staffRole;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffDesignation() {
		return staffDesignation;
	}

	public void setStaffDesignation(String staffDesignation) {
		this.staffDesignation = staffDesignation;
	}

	public String getStaffGender() {
		return staffGender;
	}

	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}

	public String getStaffRole() {
		return staffRole;
	}

	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", staffDesignation=" + staffDesignation
				+ ", staffGender=" + staffGender + ", staffRole=" + staffRole + "]";
	}

	
	
}
