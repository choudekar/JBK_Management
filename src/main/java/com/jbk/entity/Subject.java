package com.jbk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Subject {

	@Id
	private int subjectId;
	
	@NotNull(message = "SubjectName is required")
	private String subjectName;
	
	@Min(1)
	private long subjectCode;

	public Subject() {
		super();
	}

	public Subject(int subjectId, @NotNull(message = "SubjectName is required") String subjectName,
			@Min(1) long subjectCode) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public long getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(long subjectCode) {
		this.subjectCode = subjectCode;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectCode=" + subjectCode
				+ "]";
	}

	
	
	

	
}
