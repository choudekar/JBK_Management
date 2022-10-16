package com.jbk.sort;

import java.util.Comparator;

import com.jbk.entity.Batch;

public class BatchNameComparator implements Comparator<Batch>{

	@Override
	public int compare(Batch s1, Batch s2) {
		
		return s1.getBatchName().compareTo(s2.getBatchName());
	}
}
