package com.jbk.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.dao.ManagementDao;
import com.jbk.entity.Batch;
import com.jbk.entity.Staff;
import com.jbk.entity.Student;
import com.jbk.entity.Subject;

import com.jbk.sort.BatchIdComparator;
import com.jbk.sort.BatchNameComparator;
import com.jbk.sort.StaffIdComparator;
import com.jbk.sort.StaffNameComparator;
import com.jbk.sort.StudentIdComparator;
import com.jbk.sort.StudentNameComparator;
import com.jbk.sort.SubjectIdComparator;
import com.jbk.sort.SubjectNameComparator;
import com.jbk.validation.ValidateObject;



@Service
public class ManagementServiceImpl implements ManagementService {

	@Autowired
	private ManagementDao dao;
	
	
	String excludedRows = "";
	int totalRecordCount = 0;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, String> validatedError = new HashMap<String, String>();
	Map<Integer, Map<String, String>> errorMap = new HashMap<Integer, Map<String, String>>();
	
	//batch
	@Override
	public boolean saveBatch(Batch batch) {
	boolean isAdded = dao.saveBatch(batch);
		return isAdded;
	}
	
	@Override
	public List<Batch> getAllBatches() {
		List<Batch> list = dao.getAllBatches();
		return list;
	}

	@Override
	public int getTotalCountOfBatches() {
		List<Batch> allBatches = getAllBatches();
		int size = 0;
		if (!allBatches.isEmpty()) {
			size = allBatches.size();
		}
		return size;
	}
	

	@Override
	public List<Batch> sortBatches(String sortBy) {
		List<Batch> allBatches= getAllBatches();
		
		if(allBatches.size() > 1) {
			
			if(sortBy.equalsIgnoreCase("batchId")) {
				Collections.sort(allBatches, new BatchIdComparator());
			}else if(sortBy.equalsIgnoreCase("batchName")) {
				Collections.sort(allBatches, new BatchNameComparator());
			    Collections.reverse(allBatches);
			}
		}
		return allBatches;
	}
	
	//student
	@Override
	public List<Student> getStudents() {
		List<Student> list = dao.getStudents();
		return list;
	}

	@Override
	public boolean updateStudentInfo(Student student) {
		boolean isUpdated = dao.updateStudentInfo(student);
		return isUpdated;
	}
	
	@Override
	public List<Student> sortStudents(String sortBy) {
		List<Student> allStudents = getStudents();
		
		if(allStudents.size() > 1) {
			
			if(sortBy.equalsIgnoreCase("studentId")) {
				Collections.sort(allStudents, new StudentIdComparator());
			}else if(sortBy.equalsIgnoreCase("studentName")) {
				Collections.sort(allStudents, new StudentNameComparator());
			}
		}
		return allStudents;
	}
	//subject
	@Override
	public List<Subject> getAllSubjects() {
		List<Subject> list = dao.getAllSubjects();
		return list;
	}

	@Override
	public Subject getSubjectById(int subjectId) {
		Subject subject = dao.getSubjectById(subjectId);
		return subject;
	}

	@Override
	public boolean addSubject(Subject subject) {
		boolean isAdded = dao.addSubject(subject);
		return isAdded;
	}

	@Override
	public boolean removeSubject(int subjectId) {
		boolean isRemoved = dao.removeSubject(subjectId);
		return isRemoved;
	}
	
	@Override
	public List<Subject> sortSubjects(String sortBy) {
		List<Subject> allSubjects = getAllSubjects();
		
		if(allSubjects.size() > 1) {
			
			if(sortBy.equalsIgnoreCase("subjectId")) {
				Collections.sort(allSubjects, new SubjectIdComparator());
			}else if(sortBy.equalsIgnoreCase("subjectName")) {
				Collections.sort(allSubjects,new SubjectNameComparator());
			}
		}
		return allSubjects;
	}
	//staff
	@Override
	public boolean saveStaffInfo(Staff staff) {
		boolean isAdded = dao.saveStaffInfo(staff);
		return isAdded;
	}

	@Override
	public boolean updateStaff(Staff staff) {
		boolean isUpdated = dao.updateStaff(staff);
		return isUpdated;
	}

	@Override
	public List<Staff> getAllStaff() {
		List<Staff> list = dao.getAllStaff();
		return list;
	}
	
	@Override
	public List<Staff> sortStaffInformation(String sortBy) {
		List<Staff> allStaffMembers = getAllStaff();
		
		if(allStaffMembers.size() > 1) {
			
			if(sortBy.equalsIgnoreCase("staffId")) {
				Collections.sort(allStaffMembers, new StaffIdComparator());
			}else if(sortBy.equalsIgnoreCase("staffName")) {
				Collections.sort(allStaffMembers, new StaffNameComparator());
			}
		}
		return allStaffMembers;
	}
		
	public List<Staff> readExcel(String filePath) {
		Workbook workbook = null;
		FileInputStream fis = null;
		List<Staff> list = new ArrayList<Staff>();
		Staff staff = null;

		try {
			fis = new FileInputStream(new File(filePath));
			workbook = new XSSFWorkbook(fis);

			Sheet sheet = workbook.getSheetAt(0);
			totalRecordCount = sheet.getLastRowNum();
			Iterator<Row> rows = sheet.rowIterator();
			int rowCount = 0;

			while (rows.hasNext()) {

				Row row = rows.next();
				if (rowCount == 0) {
					rowCount++;
					continue;
				}
				staff = new Staff();
				
				Iterator<Cell> cells = row.cellIterator();

				while (cells.hasNext()) {
					Cell cell = cells.next();

					int column = cell.getColumnIndex();

					switch (column) {
					case 0: {
						staff.setStaffId((int)cell.getNumericCellValue());
						break;
					}
					case 1: {
						staff.setStaffName(cell.getStringCellValue());
						break;
					}
					case 2: {
						staff.setStaffDesignation(cell.getStringCellValue());
						break;
					}
					case 3: {
						staff.setStaffGender(cell.getStringCellValue());
						break;
					}
					case 4:{
						staff.setStaffRole(cell.getStringCellValue());
						break;
					}

					}

				}
				validatedError = ValidateObject.validateStaff(staff);
				if (validatedError == null || validatedError.isEmpty()) {
					list.add(staff);

				} else {
					int rowNum = row.getRowNum() + 1;
					// excludedRows = excludedRows + rowNum + ",";

					errorMap.put(rowNum, validatedError);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return list;

	}
	@Override
	public Map<String, Object> uploadSheet(CommonsMultipartFile file, HttpSession httpSession) {

		String path = httpSession.getServletContext().getRealPath("/");
		String fileName = file.getOriginalFilename();

		int uploadedCount = 0;

		FileOutputStream fos = null;
		byte[] data = file.getBytes();
		try {
			System.out.println(path);
			fos = new FileOutputStream(new File(path + File.separator + fileName));
			fos.write(data);

			List<Staff> list = readExcel(path + File.separator + fileName);

			uploadedCount = dao.uploadStaffList(list);

			map.put("Total Record In Sheet", totalRecordCount);
			map.put("Uploaded Record In DB", uploadedCount);
			map.put("Total Excluded", errorMap.size());
			map.put("Bad Record Row Number", errorMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	
	

}
