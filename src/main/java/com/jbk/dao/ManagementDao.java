package com.jbk.dao;

import java.util.List;

import com.jbk.entity.Batch;
import com.jbk.entity.Staff;
import com.jbk.entity.Student;
import com.jbk.entity.Subject;


public interface ManagementDao {


	//student
	public List<Student> getStudents();
	
	public boolean updateStudentInfo(Student student);
	
	//subject
	public List<Subject> getAllSubjects();
	
	public Subject getSubjectById(int subjectId);
	
	public boolean addSubject (Subject subject);
	
	public boolean removeSubject (int subjectId);
	
	//batch
	public boolean saveBatch (Batch batch);
	
	public List<Batch> getAllBatches();
	
	public int getTotalCountOfBatches();

	//staff
	public List<Staff> getAllStaff ();
	
	public boolean saveStaffInfo (Staff staff);
	
	public boolean updateStaff(Staff staff);
		
	public int uploadStaffList(List<Staff> list);
	
}
