package com.jbk.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.entity.Batch;
import com.jbk.entity.Staff;
import com.jbk.entity.Student;
import com.jbk.entity.Subject;
import com.jbk.exception.BatchIsNotValidException;
import com.jbk.exception.InvalidInfoException;
import com.jbk.exception.NotFoundException;
import com.jbk.exception.StaffDoesNotExistException;
import com.jbk.service.ManagementService;

@RestController
public class ManagementController {

	@Autowired
	private ManagementService service;
	
	//Batch_API
	
	@PostMapping(value = "/saveBatchInfo")
	public ResponseEntity<Boolean> saveBatchInfo(@Valid @RequestBody Batch batch){
		boolean isAdded=service.saveBatch(batch);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		} else {
			throw new InvalidInfoException("Provide valid Information");
		}
	}
	@GetMapping(value ="/ ")
	public ResponseEntity<Integer>getTotalCountOfBatches(){
		int count = service.getTotalCountOfBatches();
		if(count > 0)
			return new ResponseEntity<Integer>(count,HttpStatus.OK);
		else {
			return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping (value = "/getAllBatches")
	public ResponseEntity<List<Batch>> getAllBatches(){
		List<Batch> allBatches =service.getAllBatches();
		if(!allBatches.isEmpty()) {
			return new ResponseEntity<List<Batch>> (allBatches, HttpStatus.OK);
		}else {
			throw new BatchIsNotValidException("Batch is Not valid");
		}
	}
	@GetMapping(value = "/sortBatches")
	public ResponseEntity<List<Batch>> sortBatches(@RequestParam String sortBy) {
		List<Batch> sortedBatches = service.sortBatches(sortBy);

		if (!sortedBatches.isEmpty()) {
			return new ResponseEntity<List<Batch>>(sortedBatches, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Batch>>(HttpStatus.NO_CONTENT);
		}
	}
	//Student_API
	@GetMapping(value ="/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> allStudents = service.getStudents();
		if(!allStudents.isEmpty()) {
			return new ResponseEntity<List<Student>> (allStudents,HttpStatus.OK);
		}else {
			throw new NotFoundException("Student not found");
		}
	}
	@PutMapping(value = "/updateStudentInfo")
	public ResponseEntity<Boolean> updateStudentInfo(@Valid @RequestBody Student student){
		boolean isUpdated = service.updateStudentInfo(student);
		if(isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated,HttpStatus.OK);
		}else {
			throw new NotFoundException("Student not Found for update with id :"+student.getStudentId());
		}
	}
	@GetMapping(value = "/sortStudents")
	public ResponseEntity<List<Student>> sortStudents(@RequestParam String sortBy) {
		List<Student> sortedStudents = service.sortStudents(sortBy);

		if (!sortedStudents.isEmpty()) {
			return new ResponseEntity<List<Student>>(sortedStudents, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
	}
	//Staff_API
	@PutMapping(value = "/updateStaffInfo")
	public ResponseEntity<Boolean> updateStaffInfo(@Valid @RequestBody Staff staff){
		boolean isUpdated = service.updateStaff(staff);
		if(isUpdated) {
			return new ResponseEntity<Boolean> (isUpdated,HttpStatus.OK);
		}else {
			throw new StaffDoesNotExistException("staff does not exist");
		}
	}
	@PostMapping(value = "/saveStaffInfo")
		public ResponseEntity<Boolean> saveStaffInfo (@Valid @RequestBody Staff staff){
			boolean isAdded = service.saveStaffInfo(staff);
			if(isAdded) {
				return new ResponseEntity<Boolean>(isAdded,HttpStatus.OK);
			}else {
				throw new InvalidInfoException("Provide valid Information");
			}
		}
	@GetMapping(value = "/getAllStaffMembers")
	   public ResponseEntity<List<Staff>> getAllStaffMembers(){
		List<Staff> allStaffMembers=service.getAllStaff();
		if(!allStaffMembers.isEmpty()) {
			return new ResponseEntity<List<Staff>>(allStaffMembers,HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Staff>> (allStaffMembers,HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping(value = "/sortStaff")
	public ResponseEntity<List<Staff>> sortStaff(@RequestParam String sortBy) {
		List<Staff> sortedStaff = service.sortStaffInformation(sortBy);

		if (!sortedStaff.isEmpty()) {
			return new ResponseEntity<List<Staff>>(sortedStaff, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Staff>>(HttpStatus.NO_CONTENT);
		}
	}
	@PostMapping(value = "/uploadSheet")
	public ResponseEntity<Map<String, Object>> uploadSheet(@RequestParam CommonsMultipartFile file,
			HttpSession httpSession) {
		Map<String, Object> map = service.uploadSheet(file, httpSession);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

	}

	@GetMapping(value = "/getAllSubjects")
	public ResponseEntity<List<Subject>> getAllSubjects(){
		List<Subject> allSubjects = service.getAllSubjects();
		if(!allSubjects.isEmpty()) {
			return new ResponseEntity<List<Subject>> (allSubjects,HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Subject>>(allSubjects,HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping(value = "/removeSubjectById")
	public ResponseEntity<Boolean> removeSubject(@RequestParam int subjectId){
		boolean isRemoved = service.removeSubject(subjectId);
		if(isRemoved) {
			return new ResponseEntity<Boolean>(isRemoved,HttpStatus.OK);
		}else {
			throw new NotFoundException("Subject not found for Id : "+subjectId);
		}
	}
	
	@GetMapping(value = "/getSubjectById")
	public ResponseEntity<Subject> getSubjectById(@RequestBody int subjectId){
		Subject subject =service.getSubjectById(subjectId);
		if(subject != null) {
			return new ResponseEntity<Subject>(subject,HttpStatus.OK);
		}else {
			throw new NotFoundException("Subject not found for id : "+subjectId);
		}
	}
	
	@PostMapping(value = "/addSubjectDetails")
	public ResponseEntity<Boolean> addSubjectDeatils(@Valid @RequestBody Subject subject){
		boolean isAdded= service.addSubject(subject);
		if(isAdded) {
			return new ResponseEntity<Boolean>(isAdded,HttpStatus.OK);
		}else {
			throw new InvalidInfoException("Provide Valid Information");
		}
	}
	
	@GetMapping(value = "/sortSubjects")
	public ResponseEntity<List<Subject>> sortSubject(@RequestParam String sortBy) {
		List<Subject> sortedSubjects = service.sortSubjects(sortBy);

		if (!sortedSubjects.isEmpty()) {
			return new ResponseEntity<List<Subject>>(sortedSubjects, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Subject>>(HttpStatus.NO_CONTENT);

		}
	}
}
