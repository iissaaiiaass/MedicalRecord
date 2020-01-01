import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.InputMismatchException;
import java.awt.event.ItemEvent;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**  
 * Program: ModifyPatientFrame.java <br>  
 * Date   : 01/18/2019 <br>  
 * Description: <br>  
 * 				Frame to modify all medical records. <br>  
 * <br>  
 * History:<br>  
 * 				01/18/2019 - File created. IDLM, JRO, GMR<br>  
 * 				02/01/2019 - Project completed. IDLM, JRO, GMR <br>  
 * 
 * @author Isaías De León  Millán de_91747@stundents.pupr.edu <br>  
 * @author Julio G. Rivera Oriz rivara_95136@students.pupr.edu <br>
 * @author Gustavo A. Maldonado Rosado maldonado_9130@students.pupr.edu <br>
 */ 
public class ModifyPatientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField modifyTextField;
	private JComboBox modifyComboBox;
	private JLabel modifyLabel;
	private String patientSsn;
	private JLabel photoLabel;
	private Patient patient;
	private String [] patientStringAtributes = {"Patient name", "Patient last name", "Phone number", "Address 1", "Address 2", "City", "Zipcode", "Allergy1", "Allergy2", "Allergy3"};
	private JButton changePhotoButton;
	private JTextFieldDateEditor dateEditor;
	private JButton deletePhotoButton;
	private JButton updateRecordButton;
	private JButton changePatientButton;
	private JDateChooser dobChooser;

	/**
	 * Create the frame.
	 * 
	 * @param ssn - patients' social security number.
	 */
	public ModifyPatientFrame(String ssn) {
		
		//Initialize the modify text field and the gained focus listener.
		//This text field will change the patient's attribute selected in the combo box.
		modifyTextField = new JTextField();
		modifyTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				modifyTextField.selectAll();
			}
		});
		modifyTextField.setBounds(179, 87, 153, 22);
		modifyTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		modifyTextField.setColumns(10);
		
		//Initialize the label that will contain the patient's photo.
		photoLabel = new JLabel("");
		photoLabel.setBounds(348, 162, 200, 204);
	
		//Set the content pane's attributes.
		setTitle("Modify Patient");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 431);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Initialize the mdify combo box and the required listener.
		modifyComboBox = new JComboBox();
		modifyComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				//When the user select an option, the modify label will change its name to the selected item.
				if(e.getStateChange() == ItemEvent.SELECTED)
					modifyLabel.setText(patientStringAtributes[modifyComboBox.getSelectedIndex()]+":");	
			}
		});
		modifyComboBox.setBounds(279, 13, 214, 22);
		modifyComboBox.setModel(new DefaultComboBoxModel(new String[] {"Patient name", "Patient last name", "Phone number", "Address 1", "Address 2", "City", "Zip code", "Allergy1", "Allergy2", "Allergy3"}));
		
		//Initialize the label that explain what the user will do with the combo box.
		JLabel pleaseSelectWhatLabel = new JLabel("Please select what you choose to change: ");
		pleaseSelectWhatLabel.setBounds(12, 16, 255, 16);
		
		//Initialize the label  that explain to the user which patient's attribute the program will change.
		modifyLabel = new JLabel("Patient Name: ");
		modifyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		modifyLabel.setBounds(12, 90, 157, 16);
		
		//Button that update the selected medical record.
		updateRecordButton = new JButton("Update Record");
		updateRecordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//Update the selected attribute in the Combo Box
					if(modifyComboBox.getSelectedIndex() == 0) {
						if(modifyTextField.getText().length() != 0)
							patient.setFirstName(modifyTextField.getText());
						else
							throw new RequiredFieldException("You must enter the first name.");
					}

					else if(modifyComboBox.getSelectedIndex() == 1) {
						if(modifyTextField.getText().length() != 0) 
							patient.setLastName(modifyTextField.getText());
						else
							throw new RequiredFieldException("You must enter the last name.");
					}
					
					else if(modifyComboBox.getSelectedIndex() == 2) {
						patient.setPhoneNo(validatePhoneNumer(modifyTextField.getText()));
					}
						
					else if(modifyComboBox.getSelectedIndex() == 3) {
						if(modifyTextField.getText().length() != 0)
							patient.setAddress1(modifyTextField.getText());
						else
							throw new RequiredFieldException("You must enter an address.");
						
					}
					else if(modifyComboBox.getSelectedIndex() == 4) {
						if(modifyTextField.getText().length() != 0)
							patient.setAddress2(modifyTextField.getText());
						else
							throw new RequiredFieldException("You must enter an address.");
					}
					
					else if(modifyComboBox.getSelectedIndex() == 5) {
						if(modifyTextField.getText().length() != 0)
							patient.setCity(modifyTextField.getText());
						else
							throw new RequiredFieldException("You must enter a city.");
					}
					
					else if(modifyComboBox.getSelectedIndex() == 6) {
						if(modifyTextField.getText().length() != 0) {
							Double.parseDouble(modifyTextField.getText()); //Validate a letter.
							patient.setZipcode(modifyTextField.getText());
						}
						else
							throw new RequiredFieldException("You must enter a zipCode.");
					}
					
					else if(modifyComboBox.getSelectedIndex() == 7) {
						patient.setAllergy1(modifyTextField.getText());
					}
					else if(modifyComboBox.getSelectedIndex() == 8) {
						patient.setAllergy2(modifyTextField.getText());
					}
				    else {
				    	patient.setAllergy3(modifyTextField.getText());
				    }
					
					//Update the patient date
					if(dobChooser.getDate() != null) {
						SimpleDateFormat dobFormat = new SimpleDateFormat("yyyy-MM-dd");
						patient.setDob(java.sql.Date.valueOf(dobFormat.format(dobChooser.getDate())));
					}
					
					//Update the photo and add it to a file
					if(photoLabel.getIcon() != null) {
						ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get(patient.getSsn()+".img")));
						output.writeObject(photoLabel.getIcon());
						if(output !=null)
							output.close();
						patient.setPhoto(patient.getSsn()+".img");
					}
					else {
						//If the photo label doesn't has a photo and the program has a photo for this medical record,
						// it will be deleted.
						File fileEliminator = new File(patient.getSsn()+".img");
						if(fileEliminator.exists()) {
							fileEliminator.delete();
						}
					}
					
					//Update the patient in the database
					PatientSQL patientSQL = new PatientSQL();
					patientSQL.update(patient.getFirstName(), patient.getLastName(), patient.getSsn(), patient.getDob(), patient.getPhoneNo(), patient.getAddress1(), patient.getAddress2(), patient.getCity(), patient.getZipcode(), patient.getAllergy1(), patient.getAllergy2(), patient.getAllergy3(), patient.getPhoto());
					
					//Show to the user that the record was added.
					JOptionPane.showMessageDialog(contentPane, "Record Updated successful");
					
					//Catch the exception that was thrown by the previous functions.
					}catch (IOException e1) {
						JOptionPane.showMessageDialog(contentPane, "You choose an invalid file","Error", JOptionPane.ERROR_MESSAGE);
						
					}catch(InputMismatchException inputMismatchException) {
						JOptionPane.showMessageDialog(contentPane, "You must enter a valid phone number","Error", JOptionPane.ERROR_MESSAGE);
						
					}catch(NumberFormatException numberFormatException) {
						JOptionPane.showMessageDialog(contentPane, "You enter a invalid data","Error", JOptionPane.ERROR_MESSAGE);
						
					}catch(RequiredFieldException requiredFieldException) {
						JOptionPane.showMessageDialog(contentPane, requiredFieldException.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
					}
						
				
			}
		});
		updateRecordButton.setBounds(168, 212, 135, 30);
		
		//Add all the components to the frame.
		contentPane.setLayout(null);
		contentPane.add(updateRecordButton);
		contentPane.add(photoLabel);
		contentPane.add(pleaseSelectWhatLabel);
		contentPane.add(modifyComboBox);
		contentPane.add(modifyLabel);
		contentPane.add(modifyTextField);
		
		//Button to change the medical record's photo.
		changePhotoButton = new JButton("Change Photo");
		changePhotoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Open the file chooser to find the location of the photo.
				JFileChooser fileChooser = new JFileChooser();
				
				//Filter to looks only to photo files.
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPGE", "jpg","jpeg","pgn");
				fileChooser.setFileFilter(filter);
				
				//If the user select a photo, the program will change its size and add it to the frame.
				int response = fileChooser.showOpenDialog(null);
				if(response == JFileChooser.APPROVE_OPTION) {
					Image patientImage = new ImageIcon(fileChooser.getSelectedFile().toString()).getImage();
					Image patientResizedPhoto = patientImage.getScaledInstance(200, 204, Image.SCALE_SMOOTH);
					photoLabel.setIcon(new ImageIcon(patientResizedPhoto));
				}
			}
		});
		changePhotoButton.setBounds(12, 164, 135, 30);
		contentPane.add(changePhotoButton);
		
		//Label that show the user where he can change the patient's date of birth.
		JLabel changeDateLabel = new JLabel("Date:");
		changeDateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		changeDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		changeDateLabel.setBounds(10, 123, 159, 14);
		contentPane.add(changeDateLabel);
		
		//Button to delete the photo that was selected.
		deletePhotoButton = new JButton("Delete Photo");
		deletePhotoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				photoLabel.setIcon(null);
				patient.setPhoto(null);
			}
		});
		deletePhotoButton.setBounds(168, 162, 135, 30);
		contentPane.add(deletePhotoButton);
		
		//Button that permits the user to change the patient that was selected.
		changePatientButton = new JButton("Change Patient");
		changePatientButton.addActionListener(new ActionListener() {
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
					    	initializeFrame(ssn);
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
			}
		});
		changePatientButton.setBounds(12, 212, 135, 30);
		contentPane.add(changePatientButton);
		
		//Initialize a date chooser that permit to the user select the patient's date.
		dobChooser = new JDateChooser();
		dateEditor = (JTextFieldDateEditor) dobChooser.getDateEditor();
		dateEditor.setEditable(false);
		dobChooser.setBounds(179, 120, 153, 20);
		contentPane.add(dobChooser);
		
		//Initialize the frame with the corresponding patient.
		initializeFrame(ssn);
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
	 * @param ssn - patients' social security number.
	 */
	public void initializeFrame(String ssn) {
		
		 //Set the combo box to the patient's name item.
		 modifyComboBox.setSelectedIndex(0);
		
		 //Connect to the database and gets the corresponding patient.
		 PatientSQL patientSQL= new PatientSQL();
		 patient = patientSQL.getBySSN(ssn);
		 
		 ////Set the text field to show the patient's name.
		 modifyTextField.setText(patient.getFirstName());
		 
		 //Set the date's format of the date chooser object.
		 dateEditor.setText(patient.getDob().toLocalDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
		 
		 //Read the patient's photo from the local project file and show it to the user.
		 ObjectInputStream input = null;
		 if(patient.getPhoto() != null && patient.getPhoto().toString().length() != 0) {
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
		 }else
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
	
	/**
	 *Validate the phone number that the user has entered
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
}
