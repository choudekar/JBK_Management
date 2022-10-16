package com.jbk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Student {

	@Id
	private int studentId;
	
	@NotNull(message = "StudentName is required")
	private String studentName;
	
	@NotNull(message = "StudentMail is required")
	private String studentMail;
	
	@Min(1)
	private long studentPhoneNo;
	
	@NotNull(message = "StudentCity is required")
	private String studentCity;
	
	@NotNull(message = "StudentQualification is required")
	private String studentQualification;

	public Student() {
		super();
	}

	public Student(String studentQualification) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMail = studentMail;
		this.studentPhoneNo = studentPhoneNo;
		this.studentCity = studentCity;
		this.studentQualification = studentQualification;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentMail() {
		return studentMail;
	}

	public void setStudentMail(String studentMail) {
		this.studentMail = studentMail;
	}

	public long getStudentPhoneNo() {
		return studentPhoneNo;
	}

	public void setStudentPhoneNo(long studentPhoneNo) {
		this.studentPhoneNo = studentPhoneNo;
	}

	public String getStudentCity() {
		return studentCity;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	public String getStudentQualification() {
		return studentQualification;
	}

	public void setStudentQualification(String studentQualification) {
		this.studentQualification = studentQualification;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentMail=" + studentMail
				+ ", studentPhoneNo=" + studentPhoneNo + ", studentCity=" + studentCity + ", studentQualification="
				+ studentQualification + "]";
	}

	
}
