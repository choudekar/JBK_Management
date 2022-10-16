package com.jbk.sort;

import java.util.Comparator;

import com.jbk.entity.Staff;



public class StaffIdComparator implements Comparator<Staff> {

	@Override
	public int compare(Staff s1,Staff s2) {
		
		if(s1.getStaffId()==s2.getStaffId()) {
			return 0;
		}else if(s1.getStaffId()>s2.getStaffId()) {
			return 1;
		}else {
			return -1;
		}
	}

	
}

