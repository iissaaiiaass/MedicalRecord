import java.util.Iterator;
import java.util.List;

public class ManagePatient {
	public static void main(String [] args) {
		PatientSQL patient = new PatientSQL();
		
		//
		patient.add("Carlos", "Lopez", "123121245", java.sql.Date.valueOf("1980-01-01"), "7872341234", "250 calle Paraquay", "PMB 4534", "San Juan", "00917", "crustaceos", null, null, "DisplayPatientsFramePhoto.jpg");
		
		Patient staff  = patient.getBySSN("123121234");
		
		System.out.println(String.format("First name: %s  Last name:%s  SSN: %s", 
				staff.getFirstName(), staff.getLastName(), staff.getSsn()));
		
		System.out.println("\n==================================================\n");
		
		List<Patient> patients = patient.list();
		
		for (Iterator iterator = patients.iterator(); iterator.hasNext();) {
			staff = (Patient) iterator.next();
			
			System.out.println(String.format("First name: %s  Last name:%s  SSN: %s", 
					staff.getFirstName(), staff.getLastName(), staff.getSsn()));
		}
		
		System.out.println("\n==================================================\n");
		
		//patient.update(19, 20000);
		
		patients = patient.list();
		
		for (Iterator iterator = patients.iterator(); iterator.hasNext();) {
			staff = (Patient) iterator.next();
			
			System.out.println(String.format("First name: %s  Last name:%s  SSN: %s", 
					staff.getFirstName(), staff.getLastName(), staff.getSsn()));
		}
	}
}