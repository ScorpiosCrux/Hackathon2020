import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ClassSelectorWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static ClassSelectorWindow dialog;
	public ArrayList<String> selectedCourse = new ArrayList<String>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new ClassSelectorWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ClassSelectorWindow() {
		setBounds(660, 110, 600, 870);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JCheckBox box_231 = new JCheckBox("CPSC 231");
		box_231.setBounds(92, 121, 97, 23);
		contentPanel.add(box_231);
		
		JCheckBox box_233 = new JCheckBox("CPSC 233");
		box_233.setBounds(92, 147, 97, 23);
		contentPanel.add(box_233);
		
		JCheckBox box_211 = new JCheckBox("MATH 211");
		box_211.setBounds(92, 173, 97, 23);
		contentPanel.add(box_211);
		
		JCheckBox box_271 = new JCheckBox("MATH 271");
		box_271.setBounds(92, 199, 97, 23);
		contentPanel.add(box_271);
		
		JCheckBox box_355 = new JCheckBox("CPSC 355");
		box_355.setBounds(92, 251, 97, 23);
		contentPanel.add(box_355);
		
		JCheckBox box_359 = new JCheckBox("CPSC 359");
		box_359.setBounds(92, 277, 97, 23);
		contentPanel.add(box_359);
		
		JCheckBox box_265 = new JCheckBox("MATH 265");
		box_265.setBounds(92, 225, 97, 23);
		contentPanel.add(box_265);
		
		JLabel lblPleaseSelectThe = new JLabel("Please Select The Classes You've Already Taken:");
		lblPleaseSelectThe.setBounds(35, 86, 293, 14);
		contentPanel.add(lblPleaseSelectThe);
		
		JCheckBox box_331 = new JCheckBox("CPSC 331");
		box_331.setBounds(92, 303, 97, 23);
		contentPanel.add(box_331);
		
		JCheckBox box_313 = new JCheckBox("CPSC 313");
		box_313.setBounds(92, 329, 97, 23);
		contentPanel.add(box_313);
		
		JCheckBox box_300 = new JCheckBox("SENG 300");
		box_300.setBounds(92, 358, 97, 23);
		contentPanel.add(box_300);
		
		JCheckBox box_449 = new JCheckBox("CPSC 449");
		box_449.setBounds(92, 384, 97, 23);
		contentPanel.add(box_449);
		
		JCheckBox box_457 = new JCheckBox("CPSC 457");
		box_457.setBounds(92, 410, 97, 23);
		contentPanel.add(box_457);
		
		JCheckBox box_413 = new JCheckBox("CPSC 413");
		box_413.setBounds(92, 436, 97, 23);
		contentPanel.add(box_413);
		{
			JButton okButton = new JButton("OK");
			okButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					if (box_413.isSelected())
						selectedCourse.add("CPSC413");
					if (box_457.isSelected())
						selectedCourse.add("CPSC457");
					if (box_449.isSelected())
						selectedCourse.add("CPSC449");
					if (box_300.isSelected())
						selectedCourse.add("SENG300");
					if (box_313.isSelected())
						selectedCourse.add("CPSC313");
					if (box_331.isSelected())
						selectedCourse.add("CPSC331");
					if (box_359.isSelected())
						selectedCourse.add("CPSC359");
					if (box_355.isSelected())
						selectedCourse.add("CPSC355");
					if (box_265.isSelected())
						selectedCourse.add("MATH265");
					if (box_271.isSelected())
						selectedCourse.add("MATH271");
					if (box_211.isSelected())
						selectedCourse.add("MATH211");
					if (box_233.isSelected())
						selectedCourse.add("CPSC233");
					if (box_231.isSelected())
						selectedCourse.add("CPSC231");
					
					
					System.out.println(selectedCourse);
					
					dispose();
					Results resultsWindow = new Results(selectedCourse);
					resultsWindow.show();
					
	

			
					
					
					
					
				}
			});
			okButton.setBounds(241, 721, 119, 32);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
	}
}
