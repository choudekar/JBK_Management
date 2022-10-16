package com.jbk.sort;

import java.util.Comparator;


import com.jbk.entity.Subject;

public class SubjectIdComparator implements Comparator<Subject>{

	@Override
	public int compare(Subject s1,Subject s2) {
		
		if(s1.getSubjectId()==s2.getSubjectId()) {
			return 0;
		}else if(s1.getSubjectId()>s2.getSubjectId()) {
			return 1;
		}else {
			return -1;
		}
	}
}
