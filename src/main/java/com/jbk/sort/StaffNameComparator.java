package com.jbk.sort;

import java.util.Comparator;

import com.jbk.entity.Staff;



public class StaffNameComparator implements Comparator<Staff> {

	@Override
	public int compare(Staff s1, Staff s2) {
		
		return s1.getStaffName().compareTo(s2.getStaffName());
	}

}
