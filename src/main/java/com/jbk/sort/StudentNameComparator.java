package com.jbk.sort;

import java.util.Comparator;

import com.jbk.entity.Student;



public class StudentNameComparator implements Comparator<Student>{


	@Override
	public int compare(Student s1, Student s2) {
		
		return s1.getStudentName().compareTo(s2.getStudentName());
	}

}

