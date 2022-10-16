package com.jbk.sort;

import java.util.Comparator;

import com.jbk.entity.Subject;



public class SubjectNameComparator implements Comparator<Subject> {

	@Override
	public int compare(Subject s1, Subject s2) {
		
		return s1.getSubjectName().compareTo(s2.getSubjectName());
	}
}
