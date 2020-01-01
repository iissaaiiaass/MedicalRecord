import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

/**  
 * Program: AboutFrame.java <br>  
 * Date   : 01/18/2019 <br>  
 * Description: <br>  
 * 				GUI that present the author's information. <br>  
 * <br>  
 * History:<br>  
 * 				01/22/2019 - File created. IDLM, JRO, GMR<br>  
 * 				02/01/2019 - Project completed. IDLM, JRO, GMR <br>  
 * 
 * @author Isaías De León  Millán de_91747@stundents.pupr.edu <br>  
 * @author Julio G. Rivera Oriz rivara_95136@students.pupr.edu <br>
 * @author Gustavo A. Maldonado Rosado maldonado_9130@students.pupr.edu <br>
 */ 
public class AboutFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AboutFrame() {
		
		//Set the content pane's attributes.
		setIconImage(new ImageIcon(getClass().getResource("AboutFrameIcon.png")).getImage());
		setTitle("About");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 645, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 0));
		contentPane.setForeground(new Color(127, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Initialize Julio's name label.
		JLabel julioNameLabel = new JLabel("Julio G. Rivera Ortiz");
		julioNameLabel.setBounds(21, 48, 129, 17);
		julioNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		//Initialize Isaias's name label.
		JLabel isaiasNameLabel = new JLabel("Isa\u00EDas De Le\u00F3n Mill\u00E1n");
		isaiasNameLabel.setBounds(21, 71, 135, 22);
		isaiasNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		//Initialize Gustavo's name label.
		JLabel gustavoNameLabel = new JLabel("Gustavo A. Maldonado Rosado");
		gustavoNameLabel.setBounds(21, 99, 196, 22);
		gustavoNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		//Initialize Julio's student number label.
		JLabel julioStudentNumber = new JLabel("#95136");
		julioStudentNumber.setBounds(223, 46, 48, 19);
		julioStudentNumber.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		//Initialize Isaias's student number label.
		JLabel isaiasStudentNumber = new JLabel("#91747");
		isaiasStudentNumber.setBounds(223, 72, 48, 19);
		isaiasStudentNumber.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		//Initialize Gustavo student number label.
		JLabel gustavoStudentNumber = new JLabel("#91390");
		gustavoStudentNumber.setBounds(223, 100, 48, 19);
		gustavoStudentNumber.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		//Initialize name header.
		JLabel nameHeader = new JLabel("Name");
		nameHeader.setBounds(21, 16, 35, 17);
		nameHeader.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		//Initialize student number header.
		JLabel studentNumberHeader = new JLabel("Students #");
		studentNumberHeader.setBounds(223, 16, 68, 17);
		studentNumberHeader.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		//Initialize concentration header.
		JLabel concentrationHeader = new JLabel("Concentration");
		concentrationHeader.setBounds(297, 16, 88, 17);
		concentrationHeader.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		//Initialize Julio's Concentration.
		JLabel julioConsentration = new JLabel("COE");
		julioConsentration.setBounds(327, 48, 29, 17);
		julioConsentration.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		//Initialize Isaias's Concentration.
		JLabel isaiasConsentration = new JLabel("COE");
		isaiasConsentration.setBounds(327, 74, 29, 17);
		isaiasConsentration.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		////Initialize Gustavo's Concentration.
		JLabel gustavoConsentration = new JLabel("CS");
		gustavoConsentration.setBounds(327, 102, 18, 17);
		gustavoConsentration.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		//Initialize email header.
		JLabel emailHeader = new JLabel("Email");
		emailHeader.setBounds(391, 16, 88, 17);
		emailHeader.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		//Initialize Julio's email.
		JLabel julioEmail = new JLabel("rivera_95136@students.pupr.edu");
		julioEmail.setBounds(391, 48, 231, 17);
		julioEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		//Initialize Isaias's email.
		JLabel isaiasEmail = new JLabel("de_91747@students.pupr.edu");
		isaiasEmail.setBounds(391, 74, 202, 17);
		isaiasEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		//Initialize Gustavo's email.
		JLabel gustavoEmail = new JLabel("maldonado_91390@students.pupr.edu");
		gustavoEmail.setBounds(391, 102, 231, 17);
		gustavoEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		//Add all the components to the frame.
		contentPane.setLayout(null);
		contentPane.add(julioNameLabel);
		contentPane.add(isaiasNameLabel);
		contentPane.add(gustavoNameLabel);
		contentPane.add(nameHeader);
		contentPane.add(studentNumberHeader);
		contentPane.add(gustavoStudentNumber);
		contentPane.add(isaiasStudentNumber);
		contentPane.add(julioStudentNumber);
		contentPane.add(concentrationHeader);
		contentPane.add(isaiasConsentration);
		contentPane.add(julioConsentration);
		contentPane.add(gustavoConsentration);
		contentPane.add(emailHeader);
		contentPane.add(julioEmail);
		contentPane.add(isaiasEmail);
		contentPane.add(gustavoEmail);
	}

}
