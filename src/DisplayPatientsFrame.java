
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**  
 * Program: DisplayAllPatientFrame.java <br>  
 * Date   : 01/23/2019 <br>  
 * Description: <br>  
 * 				Frame to display all medical records. <br>  
 * <br>  
 * History:<br>  
 * 				01/23/2019 - File created. IDLM, JRO, GMR<br>  
 * 				02/01/2019 - Project completed. IDLM, JRO, GMR <br>  
 * 
 * @author Isaías De León  Millán de_91747@stundents.pupr.edu <br>  
 * @author Julio G. Rivera Oriz rivara_95136@students.pupr.edu <br>
 * @author Gustavo A. Maldonado Rosado maldonado_9130@students.pupr.edu <br>
 */ 
public class DisplayPatientsFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton RefreshTableButton;

	/**
	 * Create the frame.
	 */
	public DisplayPatientsFrame() {
		
		//Set the content pane's attributes.
		setIconImage(new ImageIcon(getClass().getResource("DisplayFrameIcon.png")).getImage());
		setTitle("Patients");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 797, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Create the scroll pane for the table.
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 16, 761, 382);
		
		//Uses to access the database and update the table.
		RefreshTableButton = new JButton("Refresh");
		RefreshTableButton.setBounds(75, 422, 610, 23);
		RefreshTableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initializeTable();
				}
		});
		
		//Initialize the table's attributes.
		table = new JTable();
		table.setGridColor(new Color(255, 255, 255));
		table.setBackground(new Color(127, 255, 0));
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"First Name", "Last Name", "Date of Birth", "SSN", "Phone Number", "Address 1", "Address 2", "City", "Zip Code", "Allergy 1", "Allergy 2", "Allergy3 "
			}
		));
		
		//Change the text fields to be not editable but, you can copy its data.
		JTextField cellTextField = new JTextField();
		cellTextField.setEditable(false);
		DefaultCellEditor editor = new DefaultCellEditor(cellTextField);
		table.setDefaultEditor(Object.class, editor);
		table.setCellSelectionEnabled(true);
		
		//Initialize table's header.
		JTableHeader  tableHeader = table.getTableHeader();
		tableHeader.setReorderingAllowed(false);
		
		//Change the size of some columns.
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(4).setPreferredWidth(100);
		columnModel.getColumn(5).setPreferredWidth(150);
		columnModel.getColumn(6).setPreferredWidth(150);
		
		//Connect the table with the database and initialize its information.
		initializeTable();
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		contentPane.add(RefreshTableButton);
		contentPane.add(scrollPane);
	}
	
	/**
	 * Connect the table with the database and initialize its information.
	 */
	public void initializeTable() {
		//Connect to the database and retrieve its information.
		PatientSQL patientSQL = new PatientSQL();
		List<Patient> patientList = patientSQL.list();
		
		//Initialize table's rows.
		DefaultTableModel TableModel = (DefaultTableModel)table.getModel();
		TableModel.setRowCount(0);
		
		//Array that will contain each patient's information and add it to the database.
		Object[] rows = new Object[12];
		for(int i=0; i<patientList.size(); i++) {
			rows[0] = patientList.get(i).getFirstName();
			rows[1] = patientList.get(i).getLastName();
			rows[2] = patientList.get(i).getDob();
			rows[3] = patientList.get(i).getSsn();
			rows[4] = patientList.get(i).getPhoneNo();
			rows[5] = patientList.get(i).getAddress1();
			rows[6] = patientList.get(i).getAddress2();
			rows[7] = patientList.get(i).getCity();
			rows[8] = patientList.get(i).getZipcode();
			rows[9] = patientList.get(i).getAllergy1();
			rows[10] = patientList.get(i).getAllergy2();
			rows[11] = patientList.get(i).getAllergy3();
			TableModel.addRow(rows);
		}
	}
}
