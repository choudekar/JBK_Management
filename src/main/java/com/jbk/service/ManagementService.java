package com.jbk.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.entity.Batch;
import com.jbk.entity.Staff;
import com.jbk.entity.Student;
import com.jbk.entity.Subject;

public interface ManagementService {

	//student
	public List<Student> getStudents();
	
	public boolean updateStudentInfo(Student student);
	
	public List<Student> sortStudents(String sortBy);
	//subject
	public List<Subject> getAllSubjects();
	
	public Subject getSubjectById(int subjectId);
	
	public boolean addSubject (Subject subject);
	
	public boolean removeSubject (int subjectId);
	
	public List<Subject> sortSubjects(String sortBy);
	//batch
	public boolean saveBatch (Batch batch);
	
	public List<Batch> getAllBatches();
	
	public int getTotalCountOfBatches();
	
	public List<Batch> sortBatches(String sortBy);
	//staff
	public boolean saveStaffInfo (Staff staff);
	
	public boolean updateStaff(Staff staff);
	
	public List<Staff> getAllStaff ();
	
	public List<Staff> sortStaffInformation(String sortBy);
	//sheet
	 public Map<String, Object> uploadSheet(CommonsMultipartFile file, HttpSession httpSession);
	
}
