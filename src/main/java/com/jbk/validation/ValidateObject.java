package com.jbk.validation;

import java.util.HashMap;
import java.util.Map;

import com.jbk.entity.Batch;
import com.jbk.entity.Staff;
import com.jbk.entity.Student;
import com.jbk.entity.Subject;




public class ValidateObject {
	
	public static Map<String, String> map=null;
	
	public static Map<String, String> validateBatch(Batch batch){
		map = new HashMap<>();
		
		if(batch.getBatchId() <= 0) {
			map.put("batchId", "BatchId should be gretaer than 0");
		}
		if(batch.getBatchName() == null || batch.getBatchName().equals("")) {
			map.put("batchName", "BatchName is required");
		}
		if(batch.getBatchCode() <= 0) {
			map.put("batchCode", "BatchCode Should be greater than 0");
		}
		return map;
	}
	
	public static Map<String,String> validateStaff(Staff staff){
		map = new HashMap<>();
		
		if(staff.getStaffId() <= 0) {
			map.put("staffId", "StaffId should be greater than 0");
		}
		if(staff.getStaffName() == null || staff.getStaffName().equals("")) {
			map.put("staffName","staffName is required");
		}
		if(staff.getStaffDesignation() == null || staff.getStaffDesignation().equals("")) {
			map.put("staffDesignation", "staffDesignation is required");
		}
		if(staff.getStaffGender() == null || staff.getStaffGender().equals("")) {
			map.put("staffGender","staffGender is required");
		}
		if(staff.getStaffRole() == null || staff.getStaffRole().equals("")) {
			map.put("staffRole","staffRole is required");
		}
		return map;
	}
	
	public static Map<String,String> validateStudent(Student student){
		map=new HashMap<>();
		
		if(student.getStudentId() <= 0) {
			map.put("studentId", "StudentId should be greater than 0");
		}
		if(student.getStudentName() == null || student.getStudentName().equals("")) {
			map.put("studentName", "studentName is required");
		}
		if(student.getStudentMail() == null || student.getStudentMail().equals("")) {
			map.put("studentMail", "studentMail is required");
		}
		if(student.getStudentPhoneNo() <= 0) {
			map.put("studentPhoneNo","StudentPhoneNo should be greater than 0");
		}
		if(student.getStudentCity() == null || student.getStudentCity().equals("")) {
			map.put("studentCity", "StudentCity is required");
		}
		if(student.getStudentQualification() == null || student.getStudentQualification().equals("")) {
			map.put("studentQualification", "StudentQualification is required");
		}
		return map;
	}
	
	public static Map<String,String> validateSubject(Subject subject){
		map=new HashMap<>();
		
		if(subject.getSubjectId() <= 0) {
			map.put("subjectId", "Subject id should be greater than  0");
		}
		if(subject.getSubjectName() == null || subject.getSubjectName().equals("")) {
			map.put("subjectName","SubjectName is required");
		}
		if(subject.getSubjectCode() <= 0) {
			map.put("subjectCode","SubjectCode should be greater than 0");
		}
		return map;
	}
	
	
	
	
	

}
