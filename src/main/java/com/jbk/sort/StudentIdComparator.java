package com.jbk.sort;

import java.util.Comparator;


import com.jbk.entity.Student;

public class StudentIdComparator implements Comparator<Student> {
	
	@Override
	public int compare(Student s1,Student s2) {
	if(s1.getStudentId()==s2.getStudentId()) {
		return 0;
	}else if(s1.getStudentId()>s2.getStudentId()) {
		return 1;
	}else {
		return -1;
	}
  }
}
