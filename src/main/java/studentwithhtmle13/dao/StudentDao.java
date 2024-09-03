package studentwithhtmle13.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import studentwithhtmle13.dto.Student;

public class StudentDao {
public EntityManager getEntityManager() {
	return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	
}


public void saveStudent(Student student) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(student);
	entityTransaction.commit();
}


public Student findStudentByEmail(String email) {
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("select s from Student s where s.email=?1");
	query.setParameter(1, email);
	
	 Student student=(Student) query.getSingleResult();
	 return student;
}


public List<Student> getAllStudents() {
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("select s from Student s");
	
	return query.getResultList();
	 
}


public Student findStudentById(int id) {
	EntityManager entityManager=getEntityManager();
	Student student=entityManager.find(Student.class, id);
	return student;
}


public Student updateStudent(int id, Student student) {
	EntityManager entityManager=getEntityManager();
	Student dbStudent=entityManager.find(Student.class, id);
	if(dbStudent!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		student.setId(id);
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}else {
		return null;
	}
	
	
}


public Student deleteStudentById(int id) {
	EntityManager entityManager=getEntityManager();
	Student dbStudent=entityManager.find(Student.class, id);
	if(dbStudent!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(dbStudent);
		entityTransaction.commit();
		return dbStudent;
	}else {
		return null;
	}
}









}
