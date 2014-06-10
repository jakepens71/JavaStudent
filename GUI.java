import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;



public class GUI extends JFrame {

	public static JTextArea textArea;
	private JLabel studentName;
	private JLabel studentNumber;
	private JTextField studentField;
	private JTextField studentNumberField;
	private JLabel studentMajor;
	private JLabel studentQPA;
	private JTextField major;
	private JTextField qpa;
	
	private JPanel centerpanel;
	private JPanel northPanel;
	private JButton add;
	private JButton retrieve;
	private JButton update;
	private JButton delete;
	private JScrollPane scrollPane;
	
	private JPanel southpanel;
	
	final int AREA_ROWS = 30;
	final int AREA_COLUMNS = 50;
	
	School newSchool = new School();

	private JScrollPane scrollPane2;

    public GUI()
    {
		createTextField();
		addButton();
		updateButton();
		retrieveButton();
		deleteButton();
		createPanel();
		
		setSize(600,600);
    }

    public void createTextField()
    {
    	studentName = new JLabel("Student Name: ");
    	studentNumber = new JLabel("Student Number: ");
    	studentMajor = new JLabel("Major: ");
    	studentQPA = new JLabel("QPA: ");
    	
    
    	
    	textArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
    	textArea.setEditable(false);
    	scrollPane2 = new JScrollPane(textArea);

    	final int FIELD_WIdTH = 5;
    	studentField = new JTextField(FIELD_WIdTH);
    	studentNumberField = new JTextField(FIELD_WIdTH);
    	major = new JTextField(FIELD_WIdTH);
    	qpa = new JTextField(FIELD_WIdTH);
    	studentField.setText("");
    	studentNumberField.setText("");
    }

    public void addButton()
    {

    	add = new JButton("Add Student");

    	class addListener implements ActionListener
   		{
   			public void actionPerformed(ActionEvent event)
   			{
   				
   				try
   				{
   				String name = studentField.getText();
   				String newMajor = major.getText();
   				int number = Integer.parseInt(studentNumberField.getText());
   				double newQPA = Double.parseDouble(qpa.getText());
   				
   				newSchool.addStudents(name, number, newMajor, newQPA);
   				}
   				catch(NumberFormatException e)
   				{
   					JOptionPane.showMessageDialog(null, "Please enter a String for Student name and major. and a number for student number and QPA");
   				}
   				
   			}
   		}
    	
    	ActionListener listener = new addListener();
    	add.addActionListener(listener);
   	}
    
    public void updateButton()
    {
    	update = new JButton("Update");
    	
    	class update implements ActionListener
   		{
   			public void actionPerformed(ActionEvent event)
   			{
   				textArea.removeAll();
   				textArea.append("Students in the school as of right now: \n" + newSchool.listStudents() + "\n");
   				textArea.append("");
   				
   			}
   		}
    	
    	ActionListener listener2 = new update();
    	update.addActionListener(listener2);
   	}
    
    
    public void retrieveButton()
    {
    	retrieve = new JButton("Retrieve Student");
    	
    	class retrieve implements ActionListener
   		{
   			public void actionPerformed(ActionEvent event)
   			{
   				try
   				{
   				String name = studentField.getText();
   				
   				textArea.removeAll();
   				textArea.append("Student you were looking for: \n" + newSchool.getExactStudent(name) + "\n");
   				textArea.append("");
   				}
   				catch(NumberFormatException a)
   				{
   					JOptionPane.showMessageDialog(null, "Please enter a String for Student name");
   				}
   			}
   		}
    	
    	ActionListener listener3 = new retrieve();
    	retrieve.addActionListener(listener3);
   	}
    	
    
    public void deleteButton()
    {
    	
    	delete = new JButton("Delete Student");
    	
    	class delete implements ActionListener
   		{
   			public void actionPerformed(ActionEvent event)
   			{
   				
   				String name = studentField.getText();
   				int number = Integer.parseInt(studentNumberField.getText());
   				
   				newSchool.removestudent(number);
   				
   			}
   		}
    	
    	ActionListener listener4 = new delete();
    	delete.addActionListener(listener4);
   	}
    	
    	
    

    public void createPanel()
    {
		northPanel = new JPanel();
		northPanel.add(studentName);
		northPanel.add(studentField);
		northPanel.add(studentNumber);
		northPanel.add(studentNumberField);
		northPanel.add(studentMajor);
		northPanel.add(major);
		northPanel.add(studentQPA);
		northPanel.add(qpa);
		
	
		
		add(northPanel, BorderLayout.NORTH);

		centerpanel = new JPanel();
		centerpanel.add(add);
		centerpanel.add(update);
		centerpanel.add(retrieve);
		centerpanel.add(delete);
		add(centerpanel, BorderLayout.CENTER);
		
		southpanel = new JPanel();
		southpanel.add(scrollPane2);
		add(southpanel, BorderLayout.SOUTH);

    }


}