import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.hibernate.exception.ConstraintViolationException;

import java.awt.Color;


import javax.persistence.PersistenceException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**  
 * Program: AddPatientFrame.java <br>  
 * Date   : 01/22/2019 <br>  
 * Description: <br>  
 * 				Frame to add a medical records. <br>  
 * <br>  
 * History:<br>  
 * 				01/22/2019 - File created. IDLM, JRO, GMR<br>  
 * 				02/01/2019 - Project completed. IDLM, JRO, GMR <br>  
 * 
 * @author Isaías De León  Millán de_91747@stundents.pupr.edu <br>  
 * @author Julio G. Rivera Oriz rivara_95136@students.pupr.edu <br>
 * @author Gustavo A. Maldonado Rosado maldonado_9130@students.pupr.edu <br>
 */ 
public class AddPatientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField ssnTextField;
	private JTextField phoneNumberTextField;
	private JTextField address1TextField;
	private JTextField address2TextField;
	private JTextField cityTextField;
	private JTextField zipCodeTextField;
	private JTextField allergy1TextField;
	private JTextField allergy2TextField;
	private JTextField allergy3TextField;
	private JLabel photoLabel;
	private JDateChooser dobChooser;


	/**
	 * Create the frame and here we began all of the project for the medical records and files.
	 */
	public AddPatientFrame() {
		
		//Set the content pane's attributes.
		setTitle("Add Patient");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100,  554, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//First Name Label
		JLabel firstNameLabel = new JLabel("*First Name");
		firstNameLabel.setBounds(10, 11, 68, 14);
		firstNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//Last Name Label
		JLabel lastNameLabel = new JLabel("*Last Name");
		lastNameLabel.setBounds(124, 11, 72, 14);
		lastNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//date of birth label
		JLabel dateOfBirthLabel = new JLabel("*Date of Birth");
		dateOfBirthLabel.setBounds(220, 11, 86, 14);
		dateOfBirthLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//social security label
		JLabel ssnLabel = new JLabel("*SSN");
		ssnLabel.setBounds(326, 11, 29, 14);
		ssnLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//phone number label
		JLabel phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberLabel.setBounds(20, 67, 72, 14);
		phoneNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//address1 label
		JLabel address1Label = new JLabel("*Address #1");
		address1Label.setBounds(24, 138, 68, 14);
		address1Label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//address2 label
		JLabel address2Label = new JLabel("*Address #2");
		address2Label.setBounds(24, 194, 68, 14);
		address2Label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//city label
		JLabel cityLabel = new JLabel("*City");
		cityLabel.setBounds(24, 258, 29, 14);
		cityLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//zip code label
		JLabel zipCodeLabel = new JLabel("*ZIP Code");
		zipCodeLabel.setBounds(140, 258, 56, 14);
		zipCodeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//allergy1 label
		JLabel allergy1Label = new JLabel("Allergy #1");
		allergy1Label.setBounds(121, 67, 56, 14);
		allergy1Label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//allergy2 label
		JLabel allergy2Label = new JLabel("Allergy #2");
		allergy2Label.setBounds(208, 67, 56, 14);
		allergy2Label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//allergy3 label
		JLabel allergy3Label = new JLabel("Allergy #3");
		allergy3Label.setBounds(326, 67, 56, 14);
		allergy3Label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//here the user enters the first name
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(10, 36, 86, 20);
		firstNameTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				firstNameTextField.selectAll();
			}
		});
		firstNameTextField.setText(null);
		firstNameTextField.setColumns(10);
		
		//The user enters the last name
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(111, 36, 86, 20);
		lastNameTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lastNameTextField.selectAll();
			}
		});
		lastNameTextField.setText(null);
		lastNameTextField.setColumns(10);
		
		//here the user enters the social security
		ssnTextField = new JTextField();
		ssnTextField.setBounds(326, 36, 135, 20);
		ssnTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ssnTextField.selectAll();
			}
		});
		ssnTextField.setText(null);
		ssnTextField.setColumns(10);
		
		//here the user enters the phone number
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setBounds(10, 92, 86, 20);
		phoneNumberTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				phoneNumberTextField.selectAll();
			}
		});
		phoneNumberTextField.setText(null);
		phoneNumberTextField.setColumns(10);
		
		//here the user enters the address #1
		address1TextField = new JTextField();
		address1TextField.setBounds(10, 163, 238, 20);
		address1TextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				address1TextField.selectAll();
			}
		});
		address1TextField.setColumns(10);
		address1TextField.setText(null);
		
		//here the user enters the address #2
		address2TextField = new JTextField();
		address2TextField.setBounds(10, 219, 238, 20);
		address2TextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				address2TextField.selectAll();
			}
		});
		address2TextField.setColumns(10);
		address2TextField.setText(null);
		
		//here the user enters the city
		cityTextField = new JTextField();
		cityTextField.setBounds(10, 280, 108, 20);
		cityTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cityTextField.selectAll();
			}
		});
		cityTextField.setText(null);
		cityTextField.setColumns(10);
		
		//here the user enters the zipcode 
		zipCodeTextField = new JTextField();
		zipCodeTextField.setBounds(138, 280, 86, 20);
		zipCodeTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				zipCodeTextField.selectAll();
			}
		});
		zipCodeTextField.setText(null);
		zipCodeTextField.setColumns(10);
		
		//here the user enters the allergy #1
		allergy1TextField = new JTextField();
		allergy1TextField.setBounds(110, 92, 86, 20);
		allergy1TextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				allergy1TextField.selectAll();
			}
		});
		allergy1TextField.setText(null);
		allergy1TextField.setColumns(10);
		
		//here the user enters the allergy #2
		allergy2TextField = new JTextField();
		allergy2TextField.setBounds(208, 92, 86, 20);
		allergy2TextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				allergy2TextField.selectAll();
			}
		});
		allergy2TextField.setText(null);
		allergy2TextField.setColumns(10);
		
		//here the user enters the allergy #3
		allergy3TextField = new JTextField();
		allergy3TextField.setBounds(326, 92, 86, 20);
		allergy3TextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				allergy3TextField.selectAll();
			}
		});
		allergy3TextField.setText(null);
		allergy3TextField.setColumns(10);
		
		//here the user inputs a photo
		photoLabel = new JLabel();
		photoLabel.setBounds(308, 240, 204, 200);
		photoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		//Add all the components to the frame.
		contentPane.setLayout(null);
		contentPane.add(ssnLabel);
		contentPane.add(ssnTextField);
		contentPane.add(phoneNumberLabel);
		contentPane.add(address1Label);
		contentPane.add(address2Label);
		contentPane.add(allergy1Label);
		contentPane.add(zipCodeTextField);
		contentPane.add(allergy3TextField);
		contentPane.add(address2TextField);
		contentPane.add(firstNameTextField);
		contentPane.add(allergy2Label);
		contentPane.add(address1TextField);
		contentPane.add(cityLabel);
		contentPane.add(cityTextField);
		contentPane.add(phoneNumberTextField);
		contentPane.add(allergy1TextField);
		contentPane.add(allergy3Label);
		contentPane.add(lastNameTextField);
		contentPane.add(firstNameLabel);
		contentPane.add(zipCodeLabel);
		contentPane.add(lastNameLabel);
		contentPane.add(dateOfBirthLabel);
		contentPane.add(allergy2TextField);
		contentPane.add(photoLabel);
		
		//Button to add the medical record.
		JButton addPhotoButton = new JButton("Add Photo");
		addPhotoButton.setBounds(10, 328, 108, 34);
		addPhotoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//here we make a file chooser for the location of the photo
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPGE", "jpg","jpeg","pgn");//here looks what type of file we are searching
				fileChooser.setFileFilter(filter);
				
				//here is when you choose the right file and the photo gets stored
				int response = fileChooser.showOpenDialog(null);
				if(response == JFileChooser.APPROVE_OPTION) {
					Image patientImage = new ImageIcon(fileChooser.getSelectedFile().toString()).getImage();
					Image patientResizedPhoto = patientImage.getScaledInstance(200, 204, Image.SCALE_SMOOTH);
					photoLabel.setIcon(new ImageIcon(patientResizedPhoto));
					
					
				}
			}
		});
		contentPane.add(addPhotoButton);
		
		//here we use a method for the calendar so the user can choose the date,month and year easier.
		dobChooser = new JDateChooser();
		dobChooser.setBounds(220, 36, 87, 20);
		dobChooser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(dobChooser.getDate().toString().length() == 0) {//here if none are chosen we made an exception
					JOptionPane.showMessageDialog(contentPane, "You must enter a date of birth","Error", JOptionPane.ERROR_MESSAGE);
					firstNameTextField.requestFocus();
				}
			}
			
		});
		JTextFieldDateEditor dateEditor = (JTextFieldDateEditor) dobChooser.getDateEditor();
		dateEditor.setEditable(false);
		contentPane.add(dobChooser);
		
		//When the user press this button, the record will be added to the database.
		JButton addRecordButton = new JButton("Add Record");
		addRecordButton.setBounds(138, 328, 108, 34);
		addRecordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					/*here it obliges to enter the required text
					for the following textfields*/
					if(firstNameTextField.getText().length()==0) {
						throw new RequiredFieldException();
					}
					if(lastNameTextField.getText().length()==0) {
						throw new RequiredFieldException();
					}
					
					if(address1TextField.getText().length()==0) {
						throw new RequiredFieldException();
					}
					if(address2TextField.getText().length()==0) {
						throw new RequiredFieldException();
					}
					if(cityTextField.getText().length()==0) {
						throw new RequiredFieldException();
					}
					if(zipCodeTextField.getText().length()==0) {
						throw new RequiredFieldException();
					}
					else {
						//Here we validate if the zipcode contains only numbers.
						Double.parseDouble(zipCodeTextField.getText());
					}
					
					//here we make sure that the social security number is corrected inserted and inputs the ssn.
					ssnTextField.setText(ssnValidation(ssnTextField.getText()));
					
					//here we insert the image in a file.
					if(photoLabel.getIcon() != null) {
						ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get(ssnTextField.getText()+".img")));
						output.writeObject(photoLabel.getIcon());
						if(output !=null)
							output.close();
					}
					
					//here we make sure that the phone number is corrected inserted
					phoneNumberTextField.setText(validatePhoneNumer(phoneNumberTextField.getText()));
					
					PatientSQL patient = new PatientSQL();
					SimpleDateFormat dobFormat = new SimpleDateFormat("yyyy-MM-dd");//here it formats the date in a certain way 
					if(photoLabel.getIcon() != null)//If the user inputs the photo this will be added
						patient.add(firstNameTextField.getText(), lastNameTextField.getText(), ssnTextField.getText(),java.sql.Date.valueOf(dobFormat.format(dobChooser.getDate())) ,phoneNumberTextField.getText(), address1TextField.getText(), address2TextField.getText(), cityTextField.getText(), zipCodeTextField.getText(), allergy1TextField.getText(), allergy2TextField.getText(), allergy3TextField.getText(),ssnTextField.getText()+".img" );
					else
						//if not this will be added
						patient.add(firstNameTextField.getText(), lastNameTextField.getText(), ssnTextField.getText(),java.sql.Date.valueOf(dobFormat.format(dobChooser.getDate())) ,phoneNumberTextField.getText(), address1TextField.getText(), address2TextField.getText(), cityTextField.getText(), zipCodeTextField.getText(), allergy1TextField.getText(), allergy2TextField.getText(), allergy3TextField.getText(),photoLabel.getText());
					
					JOptionPane.showMessageDialog(null, "ALL FILES HAVE BEEN RECORDED");//messages for successfully been entered
					
					/*exceptions for every type of error including documents that need to be required to input*/
				}catch (IOException iOException) {
					JOptionPane.showMessageDialog(contentPane, "You choose an invalid photo file","Error", JOptionPane.ERROR_MESSAGE);
					
				//here is if you entered a letter or a sign 
				}catch (InputMismatchException inputMismatchException) {
					JOptionPane.showMessageDialog(contentPane, "You enter an invalid social security number, phone number or zip code","Error", JOptionPane.ERROR_MESSAGE);
					
					//here if you pass the limit or you integrated the "-" incorrectly
				}catch(NumberFormatException numberFormatException) {
					JOptionPane.showMessageDialog(contentPane, "You enter an invalid social security number, phone number or zip code","Error", JOptionPane.ERROR_MESSAGE);
					
					//here if the required documents are not filled
				}catch(NullPointerException nullPointerException) {
					JOptionPane.showMessageDialog(contentPane, "Fill the files","Error", JOptionPane.ERROR_MESSAGE);
					
					//here if the required documents are not filled
				} catch (RequiredFieldException requiredFieldException) {
					JOptionPane.showMessageDialog(contentPane, "Fill the files","Error", JOptionPane.ERROR_MESSAGE);
					
					//here if the required documents are filled in the database.
				} catch(ConstraintViolationException constraintViolationException) {
					JOptionPane.showMessageDialog(contentPane, "The files can't be recorded.","Error", JOptionPane.ERROR_MESSAGE);
					
					//here if the required documents are  filled in the database.
				}catch(PersistenceException persistenceException) {
					JOptionPane.showMessageDialog(contentPane, "The files can't be recorded.","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(addRecordButton);
		
		JLabel allFilesLabel = new JLabel("* ALL FILES NEED TO BE FILLED!!!");
		allFilesLabel.setBounds(10, 426, 209, 14);
		contentPane.add(allFilesLabel);
		
		//here makes a button to delete the photo's.
		JButton deletePhotoButton = new JButton("Delete Photo");
		deletePhotoButton.setBounds(10, 373, 108, 34);
		deletePhotoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				photoLabel.setIcon(null);
			}
		});
		contentPane.add(deletePhotoButton);

	}
	
	/**
	 * here we validate the phone number that the user has entered
	 * 
	 * @param phone number
	 * @return - validated phone number
	 */
	private String validatePhoneNumer(String phoneNumber) {
		if(phoneNumber.length() != 0)
			if(phoneNumber.length() == 12) {
						if(phoneNumber.indexOf("-") != 3 && phoneNumber.indexOf('-', 4) != 7) 
						throw new InputMismatchException(); //Verify if the user use the corresponding "-".
						
						else {
							phoneNumber = phoneNumber.substring(0,3) + phoneNumber.substring(4,7) + phoneNumber.substring(8);
							Double.parseDouble(phoneNumber); //Verify if the user enter only numbers with the corresponding "-".
						}
				}
		
		    //Verify if the phone number has an incorrect length.
			else if(phoneNumber.length() != 10) 
				throw new InputMismatchException();
		
			else 
				Double.parseDouble(phoneNumber); //Verify if the user enter only numbers.
	
		return phoneNumber;
	}
	
	/**
	 * here it validates the social security number.
	 * 
	 * @param ssn
	 * @return - validated ssn.
	 */
	private String ssnValidation(String ssn) {
			if(ssn.length() != 0)
				if(ssn.length() == 11) {
					if(ssn.indexOf("-") != 3 && ssn.indexOf('-', 4) != 6)
					throw new InputMismatchException(); //Verify if the user use the corresponding "-".
					
					else {
						ssn = ssn.substring(0,3) + ssn.substring(4,6) + ssn.substring(7);
						Integer.parseInt(ssn); //Verify if the user enter only numbers with the corresponding "-"..
						}
					}
			
			        //Verify if the ssn has an incorrect length.
					else if(ssn.length() != 9)
						throw new InputMismatchException();
			
					else
						Integer.parseInt(ssn); //Verify if the user enter only numbers.
			else
				throw new InputMismatchException();
		
		return ssn;
	}
}