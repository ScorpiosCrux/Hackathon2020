import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class DegreeNavigatorParentWindow {

	String[] majors = {"", "Accounting", "Actuarial Science", "Ancient and Medieval History", "Anthropology", "Archaeology", "Architecture", "Art History", 
			"Astrophysics", "Biochemistry", "Bioinformatics", "Biological Sciences", "Biomechanics", "Biomedical sciences", "Business Analytics", 
			"Business Technology Management", "Canadian Studies", "Cellular, Molecular and Microbial Biology", "Chemical Engineering", 
			"Chemistry", "Civil Engineering", "Communication and Media Studies", "Community Rehabilitation", "Computer Science", "Dance",
			"Devlopment Studies", "Drama", "Earth Science", "East Asian Language Studies", "East Asian Studies", "Ecology", 
			"Economics", "Education", "Electrical Engineering", "Energy and Profession Land Management", "Energy Engineering", "English",
			"Entrepreneurship and Innovation", "Environmental Design", "Environmental Science", "Exercise and Health Physiology", "Film Studies",
			"Finance", "French", "General Commerce", "General Mathematics", "Geography", "Geology", "Geomatics Engineering", "Geophysics", "German", "Greek and Roman Studies",
			"Health and Society", "History", "International Business Strategy", "International Indigenous Studies", "international Relations", "Italian Studies", "Kinesiology",
			"Landscape Architecture", "Latin American Studies", "Law", "Law and Society", "Leadership in Pedagogy and Coaching", "Linguistics", "Linguistics and Language",
			"Marketing", "Mathematics", "Mechanical Engineering", "Medicine", "Mind Sciences in Kinesiology"};
	private JFrame frame;
	private JTextField concentrationInputField;
	private String concentrationInput;
	private String majorInput;
	private JButton btnClassRecommend;
	private JComboBox majorInputField;
	
	private ClassSelectorWindow frame2 = new ClassSelectorWindow();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DegreeNavigatorParentWindow window = new DegreeNavigatorParentWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DegreeNavigatorParentWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ImageIcon img = new ImageIcon("res/icon.jpg");
		
		frame = new JFrame("Degree Navigator");
		frame.setBounds(200, 100, 1520, 880);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(img.getImage());

	
		JLabel lblEnterYourMajor = new JLabel("Enter Your Major:");
		lblEnterYourMajor.setForeground(Color.BLACK);
		lblEnterYourMajor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterYourMajor.setBackground(Color.WHITE);
		lblEnterYourMajor.setBounds(383, 226, 200, 15);
		lblEnterYourMajor.setOpaque(true);
		frame.getContentPane().add(lblEnterYourMajor);
		
		JLabel lblConcentrationblankFor = new JLabel("Concentration: (blank for none)");
		lblConcentrationblankFor.setBackground(Color.WHITE);
		lblConcentrationblankFor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConcentrationblankFor.setBounds(824, 226, 200, 15);
		lblConcentrationblankFor.setOpaque(true);
		frame.getContentPane().add(lblConcentrationblankFor);
		
		concentrationInputField = new JTextField();
		concentrationInputField.setBounds(824, 254, 200, 20);
		frame.getContentPane().add(concentrationInputField);
		concentrationInputField.setColumns(10);
		
		
		majorInputField = new JComboBox(majors);
		majorInputField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("test");
			}
		});
		majorInputField.setBounds(383, 252, 200, 20);
		frame.getContentPane().add(majorInputField);
		
		btnClassRecommend = new JButton("Next");
		btnClassRecommend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				concentrationInput = concentrationInputField.getText();
				majorInput = majorInputField.getSelectedItem().toString();
				frame2.setVisible(true);
			}
		});
		btnClassRecommend.setBounds(595, 379, 228, 61);
		frame.getContentPane().add(btnClassRecommend);
		
		
		
		
		
		
		JLabel imgLabel = new JLabel(new ImageIcon("res/tfdl1.png"));
		imgLabel.setBounds(0, 0, 1520, 880);
		frame.getContentPane().add(imgLabel);
		
		
	}
}



