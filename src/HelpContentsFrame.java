import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

/**  
 * Program: HelpContentsFrame.java <br>  
 * Date   : 01/19/2019 <br>  
 * Description: <br>  
 * 				Frame to learn how to use the program. <br>  
 * <br>  
 * History:<br>  
 * 				01/19/2019 - File created. IDLM, JRO, GMR<br>  
 * 				02/01/2019 - Project completed. IDLM, JRO, GMR <br>  
 * 
 * @author Isaías De León  Millán de_91747@stundents.pupr.edu <br>  
 * @author Julio G. Rivera Oriz rivara_95136@students.pupr.edu <br>
 * @author Gustavo A. Maldonado Rosado maldonado_9130@students.pupr.edu <br>
 */ 
public class HelpContentsFrame extends JFrame {

	private JPanel contentPane;
	private JLabel addLabel;
	private JLabel modifyLabel;
	private JLabel searchLabel;
	private JLabel displayLabel;
	private JPanel answer2Panel;
	private JLabel answer2Label;
	private JLabel photoAnswer1;
	private JLabel photoAnswer2;
	private JLabel answer1Label2;

	/**
	 * Create the frame.
	 */
	public HelpContentsFrame() {
		
		//Set the content pane's attributes.
		setIconImage(new ImageIcon(getClass().getResource("HelpContentsFrameIcon.png")).getImage());
		setTitle("Help Contents");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 791, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Initialize the panel that will have the first answer to the user.
		JPanel answer1Panel = new JPanel();
		answer1Panel.setBounds(326, 16, 434, 194);
		answer1Panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		//Initialize the panel that will have the second answer to the user.
		answer2Panel = new JPanel();
		answer2Panel.setBounds(326, 240, 434, 194);
		answer2Panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		//Initialize the label that will have the second answer to the user.
		answer2Label = new JLabel("Then, add the information in the next window.");
		answer2Label.setHorizontalAlignment(SwingConstants.CENTER);
		answer2Label.setBounds(10, 9, 414, 14);
		
		//Initialize the photo that will have the second answer to the user.
		photoAnswer2 = new JLabel("");
		photoAnswer2.setBounds(20, 34, 404, 149);
		photoAnswer2.setHorizontalTextPosition(SwingConstants.CENTER);
		photoAnswer2.setHorizontalAlignment(SwingConstants.CENTER);
		photoAnswer2.setIcon(new ImageIcon(getClass().getResource("AddFramePhoto.jpg")));
		
		//Initialize the label that will have the first question to the user.
		addLabel = new JLabel("How can I add a medical record?");
		addLabel.setBounds(15, 43, 203, 19);
		addLabel.addMouseListener(new MouseAdapter() {
			
			//If the user moves the mouse over the label, it will turn to black.
			@Override
			public void mouseEntered(MouseEvent e) {
				addLabel.setForeground(Color.BLACK);
			}
			
			//If the user moves the mouse outside the label, it will turn to blue again.
			@Override
			public void mouseExited(MouseEvent e) {
				addLabel.setForeground(Color.BLUE);
			}
			
			//If the user clicked the label, it will show the corresponding answers.
			@Override
			public void mouseClicked(MouseEvent e) {
				addLabel.setForeground(Color.BLACK);
				answer1Label2.setText("");
				answer2Label.setText("Then, add the information in the next window.");
				photoAnswer1.setIcon(new ImageIcon(getClass().getResource("AddPrincipalFramePhoto.jpg")));
				photoAnswer2.setIcon(new ImageIcon(getClass().getResource("AddFramePhoto.jpg")));
			}
		});
		addLabel.setForeground(Color.BLUE);
		addLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		//Initialize the label that will have the second question to the user.
		modifyLabel = new JLabel("How can I change a medical record?");
		modifyLabel.setBounds(15, 97, 222, 19);
		modifyLabel.addMouseListener(new MouseAdapter() {
			
			//If the user moves the mouse over the label, it will turn to black.
			@Override
			public void mouseEntered(MouseEvent e) {
				modifyLabel.setForeground(Color.BLACK);
			}
			
			//If the user moves the mouse outside the label, it will turn to blue again.
			@Override
			public void mouseExited(MouseEvent e) {
				modifyLabel.setForeground(Color.BLUE);
			}
			
			//If the user clicked the label, it will show the corresponding answers.
			@Override
			public void mouseClicked(MouseEvent e) {
				answer2Label.setText("Then, modify the information in the next window.");
				photoAnswer1.setIcon(new ImageIcon(getClass().getResource("ModifyPrincipalFramePhoto.jpg")));
				photoAnswer2.setIcon(new ImageIcon(getClass().getResource("ModifyFramePhoto.jpg")));
				answer1Label2.setText("Then, write the patient's SSN in the window that will appear.");
			}
		});
		modifyLabel.setForeground(Color.BLUE);
		modifyLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		//Initialize the label that will have the third question to the user.
		searchLabel = new JLabel("How can I find a medical record?");
		searchLabel.setBounds(15, 153, 202, 19);
		searchLabel.addMouseListener(new MouseAdapter() {
			
			//If the user moves the mouse over the label, it will turn to black.
			@Override
			public void mouseEntered(MouseEvent e) {
				searchLabel.setForeground(Color.BLACK);
			}
			
			//If the user moves the mouse outside the label, it will turn to blue again.
			@Override
			public void mouseExited(MouseEvent e) {
				searchLabel.setForeground(Color.BLUE);
			}
			
			//If the user clicked the label, it will show the corresponding answers.
			@Override
			public void mouseClicked(MouseEvent e) {
				answer2Label.setText("Then, find the information in the next window.");
				photoAnswer1.setIcon(new ImageIcon(getClass().getResource("SearchPrincipalFramePhoto.jpg")));
				photoAnswer2.setIcon(new ImageIcon(getClass().getResource("SearchFramePhoto.jpg")));
				answer1Label2.setText("Then, write the patient's SSN in the window that will appear.");
			}
		});
		searchLabel.setForeground(Color.BLUE);
		searchLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		//Initialize the label that will have the four question to the user.
		displayLabel = new JLabel("How can I see all the medical records?");
		displayLabel.setBounds(15, 210, 234, 19);
		displayLabel.addMouseListener(new MouseAdapter() {
			
			//If the user moves the mouse over the label, it will turn to black.
			@Override
			public void mouseEntered(MouseEvent e) {
				displayLabel.setForeground(Color.BLACK);
			}
			
			//If the user moves the mouse outside the label, it will turn to blue again.
			@Override
			public void mouseExited(MouseEvent e) {
				displayLabel.setForeground(Color.BLUE);
			}
			
			//If the user clicked the label, it will show the corresponding answers.
			@Override
			public void mouseClicked(MouseEvent e) {
				answer2Label.setText("Then, see all the medical record in the next window.");
				answer1Label2.setText("");
				photoAnswer1.setIcon(new ImageIcon(getClass().getResource("DisplayPrincipalFramePhoto.jpg")));
				photoAnswer2.setIcon(new ImageIcon(getClass().getResource("DisplayPatientsFramePhoto.jpg")));
			}
		});
		displayLabel.setForeground(Color.BLUE);
		displayLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		//Initialize the label that will have the first answer to the user.
		JLabel answer1Label = new JLabel("First, you must click on file  in the menu bar and click on the next item.");
		answer1Label.setHorizontalAlignment(SwingConstants.CENTER);
		answer1Label.setBounds(10, 11, 414, 14);
		answer1Panel.setLayout(null);
		
		//Initialize the photo that will have the first answer to the user.
		photoAnswer1 = new JLabel("");
		photoAnswer1.setBounds(72, 36, 295, 120);
		photoAnswer1.setHorizontalAlignment(SwingConstants.CENTER);
		photoAnswer1.setHorizontalTextPosition(SwingConstants.CENTER);
		photoAnswer1.setIcon(new ImageIcon(getClass().getResource("AddPrincipalFramePhoto.jpg")));
		answer1Panel.add(photoAnswer1);
		answer1Panel.add(answer1Label);
		
		//Initialize the label that will have the next step in the first answer to the user.
		answer1Label2 = new JLabel("\r\n");
		answer1Label2.setHorizontalAlignment(SwingConstants.CENTER);
		answer1Label2.setBounds(10, 167, 414, 14);
		
		answer1Panel.add(answer1Label2);
		
		//Add all the components to the frame.
		contentPane.setLayout(null);
		contentPane.add(addLabel);
		contentPane.add(modifyLabel);
		contentPane.add(searchLabel);
		contentPane.add(displayLabel);
		contentPane.add(answer2Panel);
		answer2Panel.setLayout(null);
		answer2Panel.add(answer2Label);
		answer2Panel.add(photoAnswer2);
		contentPane.add(answer1Panel);
	}
}
