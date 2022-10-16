package com.jbk.sort;

import java.util.Comparator;

import com.jbk.entity.Batch;



public class BatchIdComparator implements Comparator<Batch> {

	@Override
	public int compare(Batch b1,Batch b2) {
		
		if(b1.getBatchId()==b2.getBatchId()) {
			return 0;
		}else if(b1.getBatchId()>b2.getBatchId()) {
			return 1;
		}else {
			return -1;
		}
	}

}
