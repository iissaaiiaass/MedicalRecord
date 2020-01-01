import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PatientSQL {
	private SessionFactory factory;

	public PatientSQL() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);

			throw new ExceptionInInitializerError(ex);
		}
	}

	public void add(Patient patient) {
		Session session = factory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.save(patient);

			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();

			System.err.println("Can not add patient to DB!");
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to CREATE an patient in the database */
	public void add(String fname, String lname, String ssn, java.sql.Date dob, String phoneNo, String address1, String address2, String city, String zipcode, String allergy1, String allergy2, String allergy3, String photo) {
		Patient patient = new Patient(fname, lname, ssn, dob, phoneNo, address1, address2, city, zipcode, allergy1, allergy2, allergy3, photo);

		add(patient);
	}

	/* Method to UPDATE salary for an patient */
	public void update(String fname, String lname, String ssn, java.sql.Date dob, String phoneNo, String address1, String address2, String city, String zipcode, 
			          String allergy1, String allergy2, String allergy3, String photo) {
		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Patient patient = (Patient) session.get(Patient.class, ssn);

			patient.setFirstName(fname);
			patient.setLastName(lname);
			patient.setSsn(ssn);
			patient.setDob(dob);
			patient.setPhoneNo(phoneNo);
			patient.setAddress1(address1);
			patient.setAddress2(address2);
			patient.setCity(city);
			patient.setZipcode(zipcode);
			patient.setAllergy1(allergy1);
			patient.setAllergy2(allergy2);
			patient.setAllergy3(allergy3);
			patient.setPhoto(photo);
			
			session.update(patient);

			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();

			System.err.println("Can not update patient's record!");
		} finally {
			session.close();
		}
	}
	
	//Find a patient by SSN
	public Patient getBySSN(String ssn) {
		Session session = factory.openSession();
		Patient patient = null;
		
		try {
			patient = (Patient) session.get(Patient.class, ssn);

		} catch (HibernateException e) {
			System.err.println("Can not find patient ssn: " + ssn);
		} finally {
			session.close();
		}
		
		return patient;
	}
	
	/* Method to READ all the patients */
	public List<Patient> list() {
		Session session = factory.openSession();
		List<Patient> patients = null;

		try {
			patients = session.createQuery("FROM Patient").list();
			
		} catch (HibernateException e) {
			System.err.println("Patient list have problems!");
		} finally {
			session.close();
		}
		
		return patients;
	}
}
