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









}
