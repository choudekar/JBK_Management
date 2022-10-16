package com.jbk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Batch {

	@Id
	private int batchId;
	
	@NotNull(message = "BatchName is required")
	private String batchName;
	
	@Min(1)
	private long batchCode;

	public Batch() {
		super();
	}

	public Batch(int batchId, @NotNull(message = "BatchName is required") String batchName, long batchCode) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.batchCode = batchCode;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public long getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(long batchCode) {
		this.batchCode = batchCode;
	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", batchName=" + batchName + ", batchCode=" + batchCode + "]";
	}
	
	
	
	
}
