package hibernateconcepts.learning.beans.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernateconcepts.learning.beans.Student;

public class StudentClient {

	public static void main(String[] args) {
		Student student = new Student();
		student.setEmail("chhotabheem@learning.com");
		student.setMarks(500);
		student.setName("chhota bheem");
		student.setId(1);
		student.setMobNumber(991125720L);
		//object state is transient
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.save(student);
		
		// here object state has changed from transient to persistent
		session.beginTransaction().commit();
		//student object will move to database state or permanent state
		
		
		session.evict(student);
		//student object detached state
		System.out.println(student);
		
		//student object will be removed from persistent , then gc can collect your student object
		

	}

}
