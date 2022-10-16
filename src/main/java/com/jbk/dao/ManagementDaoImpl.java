package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Batch;
import com.jbk.entity.Staff;
import com.jbk.entity.Student;
import com.jbk.entity.Subject;




@Repository
public class ManagementDaoImpl implements ManagementDao {

	@Autowired
	private SessionFactory sf;
	
 //batch
	
	@Override
	public boolean saveBatch(Batch batch) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isAdded = false;
		try {
			Batch bth = session.get(Batch.class, batch.getBatchId());

			if (bth == null) {
				session.save(batch);
				transaction.commit();
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isAdded;
	}

	@Override
	public List<Batch> getAllBatches() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Batch.class);
		List<Batch> list = null;

		try {
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}
	

	@Override
	public int getTotalCountOfBatches() {
		// TODO Auto-generated method stub
		return 0;
	}
//----------------------------------------------------------------------------------------------------------	
	//Staff
	
	@Override
	public boolean saveStaffInfo(Staff staff) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isAdded = false;
		try {
			Staff stf = session.get(Staff.class, staff.getStaffId());
			if (stf == null) {
				session.save(staff);
				transaction.commit();
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isAdded;
	}
	

	@Override
	public List<Staff> getAllStaff() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		List<Staff> list = null;
		try {
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}
	

	@Override
	public boolean updateStaff(Staff staff) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated=false;
		try {
			Staff stf = session.get(Staff.class,staff.getStaffId());
			if(stf != null) {
				session.evict(stf);
				session.update(staff);
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}
	
//------------------------------------------------------------------------------------------------------------------------	
	
	
   //student
	
	@Override
	public List<Student> getStudents() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> list=null;
		
		try {
			list=criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public boolean updateStudentInfo(Student student) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated=false;
		try {
			Student std = session.get(Student.class, student.getStudentId());
			if(std != null) {
				session.evict(std);
				session.update(student);
				transaction.commit();
				isUpdated=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

//--------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public List<Subject> getAllSubjects() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Subject.class);
		List<Subject> list = null;

		try {
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public Subject getSubjectById(int subjectId) {
		Session session = sf.openSession();
		Subject subject=null;
		try {
			session.get(Subject.class,subjectId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return subject;
	}
	
	@Override
	public boolean addSubject(Subject subject) {// subject=this is a object and have to save
		Session session = sf.openSession(); // sbj =we are saving that object which is present in our data in this
											// variable
		Transaction transaction = session.beginTransaction();
		boolean isAdded = false;
		try {
			Subject sbj = session.get(Subject.class, subject.getSubjectId());
			if (sbj == null) {
				session.save(subject);
				transaction.commit();
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isAdded;
	}

	@Override
	public boolean removeSubject(int subjectId) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isRemoved=false;
		try {
			Subject subject = session.get(Subject.class, subjectId);
			if(subject != null) {
				session.delete(subject);
				transaction.commit();
				isRemoved=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return isRemoved;
	}

	@Override
	public int uploadStaffList(List<Staff> list) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	
	



}
