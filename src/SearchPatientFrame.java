import java.awt.EventQueue;
import java.awt.Font;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;

/**  
 * Program: SearchPatientFrame.java <br>  
 * Date   : 01/18/2019 <br>  
 * Description: <br>  
 * 				Frame to find a medical records. <br>  
 * <br>  
 * History:<br>  
 * 				01/18/2019 - File created. IDLM, JRO, GMR<br>  
 * 				02/01/2019 - Project completed. IDLM, JRO, GMR <br>  
 * 
 * @author Isaías De León  Millán de_91747@stundents.pupr.edu <br>  
 * @author Julio G. Rivera Oriz rivara_95136@students.pupr.edu <br>
 * @author Gustavo A. Maldonado Rosado maldonado_9130@students.pupr.edu <br>
 */ 
public class SearchPatientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField dobTextField;
	private JTextField ssnTextField;
	private JTextField phoneNumberTextField;
	private JTextField address1TextField;
	private JTextField address2TextField;
	private JTextField cityTextField;
	private JTextField zipCodeTextField;
	private JTextField allergy1TextField;
	private JTextField allergy2TextField;
	private JTextField allergy3TextField;
	private String patientSsn;
	private JLabel photoLabel;
	private JButton changePatientRecord;

	/**
	 * Create the frame.
	 * 
	 * @param ssn - patients' social security number
	 */
	public SearchPatientFrame(String ssn) {
		
		//Set the content pane's attributes.
		setIconImage(new ImageIcon(getClass().getResource("SearchFrameIcon.png")).getImage());
		setForeground(new Color(211, 211, 211));
		setTitle("Patient Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 591, 437);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Initialize the label that will contain the patient' first name.
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(31, 16, 54, 14);
		firstNameLabel.setForeground(Color.BLACK);
		firstNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//Initialize the label that will contain the patient' last name.
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(136, 16, 52, 14);
		lastNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//Initialize the label that will contain the patient' date of birth.
		JLabel dateOfBirthLabel = new JLabel("Date of Birth");
		dateOfBirthLabel.setBounds(234, 16, 64, 14);
		dateOfBirthLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//Initialize the label that will contain the patient' ssn.
		JLabel ssnLabel = new JLabel("SSN");
		ssnLabel.setBounds(360, 16, 21, 14);
		ssnLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//Initialize the text field that will contain the patient' first name.
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(15, 36, 86, 20);
		firstNameTextField.setEditable(false);
		firstNameTextField.setColumns(15);
		
		//Initialize the text field that will contain the patient' last name.
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(119, 36, 86, 20);
		lastNameTextField.setEditable(false);
		lastNameTextField.setColumns(15);
		
		//Initialize the text field that will contain the patient' date of birth.
		dobTextField = new JTextField();
		dobTextField.setBounds(223, 36, 86, 20);
		dobTextField.setEditable(false);
		dobTextField.setColumns(15);
		
		//Initialize the text field that will contain the patient' ssn.
		ssnTextField = new JTextField();
		ssnTextField.setBounds(327, 36, 86, 20);
		ssnTextField.setEditable(false);
		ssnTextField.setColumns(15);
		
		//Initialize the label that will contain the patient' phone number.
		JLabel phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberLabel.setBounds(22, 74, 72, 14);
		phoneNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//Initialize the label that will contain the patient' address #1.
		JLabel address1Label = new JLabel("Address #1");
		address1Label.setBounds(25, 183, 55, 14);
		address1Label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//Initialize the label that will contain the patient' address #2.
		JLabel address2Label = new JLabel("Address #2");
		address2Label.setBounds(25, 227, 55, 14);
		address2Label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//Initialize the label that will contain the patient' city.
		JLabel cityLabel = new JLabel("City");
		cityLabel.setBounds(151, 74, 22, 14);
		cityLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//Initialize the text field that will contain the patient' phone number.
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setBounds(15, 94, 86, 20);
		phoneNumberTextField.setEditable(false);
		phoneNumberTextField.setColumns(15);
		
		//Initialize the text field that will contain the patient' address #1.
		address1TextField = new JTextField();
		address1TextField.setBounds(15, 203, 248, 20);
		address1TextField.setEditable(false);
		address1TextField.setColumns(20);
		
		//Initialize the text field that will contain the patient' address #2.
		address2TextField = new JTextField();
		address2TextField.setBounds(15, 247, 248, 20);
		address2TextField.setEditable(false);
		address2TextField.setColumns(20);
		
		//Initialize the text field that will contain the patient' city.
		cityTextField = new JTextField();
		cityTextField.setBounds(119, 94, 86, 20);
		cityTextField.setEditable(false);
		cityTextField.setColumns(15);
		
		//Initialize the label that will contain the patient' zipcode.
		JLabel zipCodeLabel = new JLabel("ZIP Code");
		zipCodeLabel.setBounds(243, 74, 47, 14);
		zipCodeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//Initialize the label that will contain the patient' allergy #1.
		JLabel allergy1Label = new JLabel("Allergy #1");
		allergy1Label.setBounds(33, 132, 51, 14);
		allergy1Label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//Initialize the label that will contain the patient' allergy #2.
		JLabel allergy2Label = new JLabel("Allergy #2");
		allergy2Label.setBounds(137, 132, 51, 14);
		allergy2Label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//Initialize the label that will contain the patient' allergy #3.
		JLabel allergy3Label = new JLabel("Allergy #3");
		allergy3Label.setBounds(241, 132, 51, 14);
		allergy3Label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//Initialize the text field that will contain the patient' zipcode.
		zipCodeTextField = new JTextField();
		zipCodeTextField.setBounds(223, 94, 86, 20);
		zipCodeTextField.setEditable(false);
		zipCodeTextField.setColumns(15);
		
		//Initialize the text field that will contain the patient' allergy #1.
		allergy1TextField = new JTextField();
		allergy1TextField.setBounds(15, 152, 86, 20);
		allergy1TextField.setEditable(false);
		allergy1TextField.setColumns(15);
		
		//Initialize the text field that will contain the patient' allergy #2.
		allergy2TextField = new JTextField();
		allergy2TextField.setBounds(119, 152, 86, 20);
		allergy2TextField.setEditable(false);
		allergy2TextField.setColumns(15);
		
		//Initialize the text field that will contain the patient' allergy #3.
		allergy3TextField = new JTextField();
		allergy3TextField.setBounds(223, 152, 86, 20);
		allergy3TextField.setEditable(false);
		allergy3TextField.setColumns(15);
		
		//Initialize the label that will contain the patient' photo
		photoLabel = new JLabel("");
		photoLabel.setBounds(327, 183, 200, 204);
		photoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//Initialize the patient's ssn.
		patientSsn = ssn;
		
		//Add all the components to the frame.
		contentPane.setLayout(null);
		contentPane.add(firstNameLabel);
		contentPane.add(lastNameLabel);
		contentPane.add(dateOfBirthLabel);
		contentPane.add(ssnLabel);
		contentPane.add(firstNameTextField);
		contentPane.add(lastNameTextField);
		contentPane.add(dobTextField);
		contentPane.add(ssnTextField);
		contentPane.add(phoneNumberLabel);
		contentPane.add(cityLabel);
		contentPane.add(phoneNumberTextField);
		contentPane.add(cityTextField);
		contentPane.add(zipCodeLabel);
		contentPane.add(allergy1Label);
		contentPane.add(allergy2Label);
		contentPane.add(allergy3Label);
		contentPane.add(address1Label);
		contentPane.add(zipCodeTextField);
		contentPane.add(allergy1TextField);
		contentPane.add(allergy2TextField);
		contentPane.add(allergy3TextField);
		contentPane.add(photoLabel);
		contentPane.add(address2Label);
		contentPane.add(address1TextField);
		contentPane.add(address2TextField);
		
		//Button that permits the user to change the patient that was selected.
		changePatientRecord = new JButton("Change Patient");
		changePatientRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				
				do {
					
					try {
						//Will receive the social security number of the patient.
						String ssn = new String();
						
						//Prompt the user to enter the patient's ssn.
						ssn = JOptionPane.showInputDialog(contentPane, "Enter the patient's Social Security number");
						
						//Validate the ssn that the user entered.
						ssn = ssnValidation(ssn);
						
						//If the user enter a valid ssn, the frame will be initialized with the new patient.
						if(ssn != null) {
					    	setPatientSsn(ssn);
					    	initializeFrame();
					    	setVisible(true);
						}
					   
					   flag = false;
					   
					//Receive the exception thrown by ssnValidation function.
					}catch(InputMismatchException inputMismatchException) {
						JOptionPane.showMessageDialog(contentPane, "You most enter a valid social security number","Error", JOptionPane.ERROR_MESSAGE);
						
					}catch(NumberFormatException numberFormatException) {
						JOptionPane.showMessageDialog(contentPane, "You most enter a valid social security number","Error", JOptionPane.ERROR_MESSAGE);
						
				    //If the record doesn't exist in the database, this exception will be catch.
					}catch(NullPointerException nullPointerException) {
						JOptionPane.showMessageDialog(contentPane, "The record you are looking for does not exist.","Error", JOptionPane.ERROR_MESSAGE);
						
					}
						
				}while(flag);
				
				//Initialize the frame with the corresponding patient.
				initializeFrame();
			}
		});
		changePatientRecord.setBounds(60, 311, 128, 40);
		contentPane.add(changePatientRecord);
		
		
		
		
	}
	
	/**
	 * Set the corresponding value to  the ssn.
	 * 
	 * @param ssn - patients' social security number.
	 */
	public void setPatientSsn(String ssn) {
		patientSsn = ssn;
	}
	
	/**
	 * Initialize the frame with the corresponding patient.
	 * 
	 */
	public void  initializeFrame() {
		//Connect to the database and find the patient.
		PatientSQL patientSQL = new PatientSQL();
		Patient patient = patientSQL.getBySSN(patientSsn);
		
		//Initialize all the text fields with the patient's information.
		firstNameTextField.setText(patient.getFirstName());
		lastNameTextField.setText(patient.getLastName());
		dobTextField.setText(patient.getDob().toLocalDate().format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
		ssnTextField.setText(patient.getSsn());
		phoneNumberTextField.setText(patient.getPhoneNo());
		address1TextField.setText(patient.getAddress1());
		address2TextField.setText(patient.getAddress2());
		cityTextField.setText(patient.getCity());
		zipCodeTextField.setText(patient.getZipcode());
		allergy1TextField.setText(patient.getAllergy1());
		allergy2TextField.setText(patient.getAllergy2());
		allergy3TextField.setText(patient.getAllergy3());
		
		 //Read the patient's photo from the local project file and show it to the user.
		if(patient.getPhoto() != null && patient.getPhoto().toString().length() != 0) {
			ObjectInputStream input = null;
			try {
				
			  input = new ObjectInputStream(Files.newInputStream(Paths.get(patient.getSsn()+".img")));
			  photoLabel.setIcon((Icon) input.readObject());
			  
			} catch (IOException iOException) {
				
				JOptionPane.showMessageDialog(contentPane, "The program can't find the photo","Error",JOptionPane.ERROR_MESSAGE);
				
			} catch (ClassNotFoundException iOException) {
				JOptionPane.showMessageDialog(contentPane, "Error code: 000","Error",JOptionPane.ERROR_MESSAGE);
			}
			
			try {
				if(input != null)
					input.close();
			}
			catch(IOException iOException) {
				JOptionPane.showMessageDialog(contentPane, "Error code: 001","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		else
			photoLabel.setIcon(null);
	}
	
	/**
	 * Validates the social security number.
	 * 
	 * @param ssn
	 * @return - validated ssn.
	 */
	private String ssnValidation(String ssn) {
		
		if(ssn != null) {
			//Verify if the ssn is empty.
			if(ssn.equals(""))
				throw new InputMismatchException();
			
			else if(ssn.length() == 11) {
				if(ssn.indexOf("-") != 3 && ssn.indexOf('-', 4) != 6)
					throw new InputMismatchException(); //Verify if the user use the corresponding "-".
				else {
					ssn = ssn.substring(0,3) + ssn.substring(4,6) + ssn.substring(7);
					Integer.parseInt(ssn); //Verify if the user enter only numbers with the corresponding "-".
						}
					}
			
			//Verify if the ssn has an incorrect length.
			else if(ssn.length() != 9)
				throw new InputMismatchException();
			
			else
				Integer.parseInt(ssn); //Verify if the user enter only numbers.
		}
		return ssn;
	}
}


