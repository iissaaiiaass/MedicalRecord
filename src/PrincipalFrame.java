import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.InputMismatchException;
import javax.swing.SwingConstants;

/**  
 * Program: PrincipalFrame.java <br>  
 * Date   : 01/18/2019 <br>  
 * Description: <br>  
 * 				Principal GUI that make the connection with the oder windows . <br>  
 * <br>  
 * History:<br>  
 * 				01/18/2019 - File created. IDLM, JRO, GMR<br>  
 * 				02/01/2019 - Project completed. IDLM, JRO, GMR <br>  
 * 
 * @author Isaías De León  Millán de_91747@stundents.pupr.edu <br>  
 * @author Julio G. Rivera Oriz rivara_95136@students.pupr.edu <br>
 * @author Gustavo A. Maldonado Rosado maldonado_9130@students.pupr.edu <br>
 */ 
public class PrincipalFrame extends JFrame {

	private JPanel contentPane;
	private AddPatientFrame addPatientFrame;
	private AboutFrame aboutFrame;
	private ModifyPatientFrame modifyPatientFrame;
	private SearchPatientFrame searchPatientFrame;
	private HelpContentsFrame helpContentsFrame;
	DisplayPatientsFrame displayPatientsFrame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalFrame frame = new PrincipalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalFrame() {
		
		//Set the content pane's attributes.
		setTitle("Medical Record Menu");
		setIconImage(new ImageIcon(getClass().getResource("PrincipalFrameIcon.png")).getImage());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 480);
		
		//Initialize the menu bar.
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Initialize the file menu.
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		//Initialize the add patient menu item and required listener to open AddPatientFrame frame.
		JMenuItem addPatientMenuItem = new JMenuItem("Add Patient");
		addPatientMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//If the frame was not created, the program initialized it.
				if(addPatientFrame == null)
					addPatientFrame = new AddPatientFrame();
				
				//If the frame was created, the program show it.
				addPatientFrame.setVisible(true);
			}
		});
		fileMenu.add(addPatientMenuItem);
		
		//Initialize the modify patient menu item and required listener to open ModifyPatientFrame frame.
		JMenuItem modifyMenuItem = new JMenuItem("Modify Patient");
		modifyMenuItem.addActionListener(new ActionListener() {
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
						
						//If the modify frame was not initialize, the program will initialized it with the ssn that the user enters.
						if(modifyPatientFrame == null && ssn != null) {
							modifyPatientFrame = new ModifyPatientFrame(ssn);
						}
						
						//If the modify frame was initialized, the program initialized it again with the new ssn entered by the user.
					    if(modifyPatientFrame != null && ssn != null) {
						    modifyPatientFrame.initializeFrame(ssn);
							modifyPatientFrame.setVisible(true);
						}
					   
					   flag = false;
				
				//Receive the exception thrown by ssnValidation function.
				}catch(InputMismatchException inputMismatchException) {
					JOptionPane.showMessageDialog(contentPane, "You must enter a valid social security number","Error", JOptionPane.ERROR_MESSAGE);
					
				}catch(NumberFormatException numberFormatException) {
					JOptionPane.showMessageDialog(contentPane, "You must enter a valid social security number","Error", JOptionPane.ERROR_MESSAGE);
					
				}catch(NullPointerException nullPointerException) {
					JOptionPane.showMessageDialog(contentPane, "The record you are looking for does not exist.","Error", JOptionPane.ERROR_MESSAGE);
					
				}
					
			}while(flag);
		  }
		});
		fileMenu.add(modifyMenuItem);
		
		//Initialize the search patient menu item and required listener to open SearchPatientFrame frame.
		JMenuItem searchPatientMenuItem = new JMenuItem("Search Patient");
		searchPatientMenuItem.addActionListener(new ActionListener() {
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
						
						//If the search frame was not initialize, the program will initialized it with the ssn that the user enters.
						if(searchPatientFrame == null && ssn != null) {
							searchPatientFrame = new SearchPatientFrame(ssn);
						}
						
						//If the search frame was initialized, the program initialized it again with the new ssn entered by the user.
					    if(searchPatientFrame != null && ssn != null) {
					    	searchPatientFrame.setPatientSsn(ssn);
					    	searchPatientFrame.initializeFrame();
					    	searchPatientFrame.setVisible(true);
						}
					   
					   flag = false;
					
					 //Receive the exception thrown by ssnValidation function.
					}catch(InputMismatchException inputMismatchException) {
						JOptionPane.showMessageDialog(contentPane, "You must enter a valid social security number","Error", JOptionPane.ERROR_MESSAGE);
						
					}catch(NumberFormatException numberFormatException) {
						JOptionPane.showMessageDialog(contentPane, "You must enter a valid social security number","Error", JOptionPane.ERROR_MESSAGE);
						
					}catch(NullPointerException nullPointerException) {
						JOptionPane.showMessageDialog(contentPane, "The record you are looking for does not exist.","Error", JOptionPane.ERROR_MESSAGE);
						
					}
						
				}while(flag);
			}
		});
		fileMenu.add(searchPatientMenuItem);
		
		//Initialize the display all  patient menu item and required listener to open DisplayAllPatientFrame frame.
		JMenuItem displayAllPatientMenuItem = new JMenuItem("Display All Patient");
		displayAllPatientMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//If the frame was not created, the program initialized it.
				if(displayPatientsFrame == null)
					displayPatientsFrame = new DisplayPatientsFrame();
				
				//If the frame was created, the program show it.
				displayPatientsFrame.initializeTable();
				displayPatientsFrame.setVisible(true);
			}
		});
		fileMenu.add(displayAllPatientMenuItem);
		
		//Initialize exit menu item and the required listener to close the program when it was pressed.
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);;
			}
		});
		fileMenu.add(exitMenuItem);
		
		//Initialize help menu.
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		//Initialize the help content menu item and required listener to open HelpContentsFrame frame.
		JMenuItem helpContentsMenuItem = new JMenuItem("Help Contents");
		helpContentsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//If the frame was not created, the program initialized it.
				if(helpContentsFrame == null)
					helpContentsFrame = new HelpContentsFrame();
				
				//If the frame was created, the program show it.
				helpContentsFrame.setVisible(true);
			}
		});
		helpMenu.add(helpContentsMenuItem);
		
		//Initialize the about menu item and required listener to open AboutFrame frame.
		JMenuItem aboutMenuItem = new JMenuItem("About");
		aboutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//If the frame was not created, the program initialized it.
				if(aboutFrame == null)
					aboutFrame = new AboutFrame();
				
				//If the frame was created, the program show it.
				aboutFrame.setVisible(true);
			}
		});
		helpMenu.add(aboutMenuItem);
		
		//Add a image to the frame.
		JLabel logoLabel = new JLabel("");
		logoLabel.setBounds(31, 118, 580, 167);
		logoLabel.setVerticalTextPosition(SwingConstants.TOP);
		logoLabel.setIcon(new ImageIcon(getClass().getResource("Logo.jpeg")));
		
		//Initialize the connection with the Database.
		PatientSQL patientSQL = new PatientSQL();
		contentPane.setLayout(null);
		contentPane.add(logoLabel);
		
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
