import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class Results extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Results(ArrayList<String> input) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(701, 200, 518, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		DegreeNavigatorMain dnm = new DegreeNavigatorMain();
		HashMap<String, String> output = dnm.analyze(dnm.requisites.getPreRequisites(), input);
		String build = "";
		for (String name: output.keySet()){
            String key = name.toString();
            String value = output.get(name).toString();  
            build += (key + ": " + value +"\n");
		}
		
		build += "\n\n";
		
		build += ("react : Total- 625 jobs|Mean- 89 jobs\r\n" + 
				"django : Total- 34 jobs|Mean- 4 jobs\r\n" + 
				"c/c++ : Total- 0 jobs|Mean- 0 jobs\r\n" + 
				"java : Total- 314 jobs|Mean- 44 jobs\r\n" + 
				"pearl : Total- 0 jobs|Mean- 0 jobs\r\n" + 
				"javascript : Total- 981 jobs|Mean- 140 jobs\r\n" + 
				"vue : Total- 377 jobs|Mean- 53 jobs\r\n" + 
				"angular : Total- 563 jobs|Mean- 80 jobs\r\n" + 
				"python : Total- 103 jobs|Mean- 14 jobs\r\n" + 
				"c# : Total- 49 jobs|Mean- 7 jobs\r\n" + 
				"go : Total- 155 jobs|Mean- 22 jobs\r\n" + 
				"haskell : Total- 0 jobs|Mean- 0 jobs");
		
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(39, 57, 410, 456);
		contentPane.add(textPane);
		textPane.setText(build);
		
		JLabel lblTheseDisplayThe = new JLabel("These display the classes you've yet to take and the number of prequisites a class fulfils");
		lblTheseDisplayThe.setBounds(27, 11, 450, 20);
		contentPane.add(lblTheseDisplayThe);
		
		JLabel lblAlsoDisplaysThe = new JLabel("Also displays the popularity of languages:");
		lblAlsoDisplaysThe.setBounds(27, 42, 422, 14);
		contentPane.add(lblAlsoDisplaysThe);
		
		
	}
}
