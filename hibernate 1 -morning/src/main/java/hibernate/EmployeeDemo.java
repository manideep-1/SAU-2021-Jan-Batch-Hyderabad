package hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Address;
import hibernate.entity.Employee;
import hibernate.entity.EmployeeDetails;
import hibernate.entity.ILearnSessions;

public class EmployeeDemo {
	public static void main(String[] args)
	{
		SessionFactory sessionFactory=(SessionFactory) new Configuration().configure()
				.addAnnotatedClass(Employee.class).addAnnotatedClass(ILearnSessions.class)
				.addAnnotatedClass(EmployeeDetails.class).addAnnotatedClass(Address.class)
				.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Employee employee=new Employee("Manideep","Laxmishetty",new Date());
		Employee employee2=new Employee("Anudeep","Kakkireni",new Date());
		employee2.getSkillSet().add("html");
		employee2.getSkillSet().add("css");
		employee.getSkillSet().add("c++");
		employee.getSkillSet().add("java");
		
		
		Address a1=new Address("addressLine1","addressLine2",132455,"state","country");
		Address a2=new Address("addressLine3","addressLine4",500074,"state1","country1");
		Address a3=new Address("addressLine5","addressLine6",500073,"state2","country2");
		
		EmployeeDetails ed1=new EmployeeDetails();
		ed1.setEmail("laxmishettymani@gmail.com");
		ed1.setNumber("1234567890");
		EmployeeDetails ed2=new EmployeeDetails();
		ed2.setEmail("kanudeep2@gmail.com");
		ed2.setNumber("987654321");
		
		employee.getAddresses().add(a1);
		a1.setEmployee(employee);
		employee.getAddresses().add(a2);
		a2.setEmployee(employee);
		employee2.getAddresses().add(a3);
		a3.setEmployee(employee2);
		employee.setEmpdetails(ed1);
		employee2.setEmpdetails(ed2);
		
		ILearnSessions iLearnsession1=new ILearnSessions();
		iLearnsession1.setSessionName("Hibernate1");
		ILearnSessions iLearnsession2=new ILearnSessions();
		iLearnsession2.setSessionName("Hibernate2");
		ILearnSessions iLearnsession3=new ILearnSessions();
		iLearnsession2.setSessionName("Hibernate3");
		
		
		employee.getiLearnsession().add(iLearnsession1);
		iLearnsession1.getEmps().add(employee);
		employee.getiLearnsession().add(iLearnsession2);
		iLearnsession2.getEmps().add(employee);
		
		
		iLearnsession1.getEmps().add(employee2);
		employee2.getiLearnsession().add(iLearnsession1);
		iLearnsession2.getEmps().add(employee2);
		employee2.getiLearnsession().add(iLearnsession2);
		iLearnsession3.getEmps().add(employee2);
		employee2.getiLearnsession().add(iLearnsession3);
		
		
		try {
			session.beginTransaction();
//			session.save(iLearnsession);
			session.save(employee);
			session.save(employee2);
			session.getTransaction().commit();
			session.close();
			session=sessionFactory.openSession();
			Employee empFromDB=session.get(Employee.class,12);
			session.close();
			System.out.println("Retreived from DB "+empFromDB.getFirstName());
			System.out.println(empFromDB.getLastName()+" "+empFromDB.getJoiningDate()+
					" "+ empFromDB.getSkillSet());
		 
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
}
