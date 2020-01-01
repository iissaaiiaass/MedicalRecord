import java.time.LocalDate;

public class Patient {
	private String ssn;
	private String firstName;
	private String lastName;
	private java.sql.Date dob;
	private String phoneNo;
	private String address1;
	private String address2;
	private String city;
	private String zipcode;
	private String allergy1;
	private String allergy2;
	private String allergy3;
	private String photo;
	
	public Patient() {}
	
	public Patient(String firstName, String lastName, String ssn, java.sql.Date dob, String phoneNo, String address1,
			String address2, String city, String zipcode, String allergy1, String allergy2, String allergy3,
			String photo) {
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.phoneNo = phoneNo;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.zipcode = zipcode;
		this.allergy1 = allergy1;
		this.allergy2 = allergy2;
		this.allergy3 = allergy3;
		this.photo = photo;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public java.sql.Date getDob() {
		return dob;
	}

	public void setDob(java.sql.Date dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAllergy1() {
		return allergy1;
	}

	public void setAllergy1(String allergy1) {
		this.allergy1 = allergy1;
	}

	public String getAllergy2() {
		return allergy2;
	}

	public void setAllergy2(String allergy2) {
		this.allergy2 = allergy2;
	}

	public String getAllergy3() {
		return allergy3;
	}

	public void setAllergy3(String allergy3) {
		this.allergy3 = allergy3;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
