import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Register {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField textField_3;
	private JPasswordField textField_4;
	Connection cn;
Register()
{

	frame = new JFrame();
	frame.getContentPane().setBackground(new Color(176, 224, 230));
	frame.getContentPane().setForeground(new Color(255, 153, 255));
	frame.getContentPane().setLayout(null);
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setSize(screenSize.width, screenSize.height);
	

	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
     cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	}catch(Exception e)
	{
		System.out.println(e);
	}
    
    
	JLabel lblEventManagementSystem = new JLabel("Event Management System");
	lblEventManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 40));
	lblEventManagementSystem.setForeground(new Color(0, 0, 0));
	lblEventManagementSystem.setBounds(405, 11, 563, 65);
	frame.getContentPane().add(lblEventManagementSystem);
	
	JButton btnNewButton = new JButton("Home");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			new homepage();
		}
	});
	btnNewButton.setForeground(new Color(0, 0, 0));
	btnNewButton.setBackground(new Color(175, 238, 238));
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnNewButton.setBounds(163, 168, 145, 37);
	frame.getContentPane().add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("Register");
	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnNewButton_1.setBackground(new Color(175, 238, 238));
    btnNewButton_1.setBounds(449, 168, 145, 37);
	frame.getContentPane().add(btnNewButton_1);
	
	JButton btnNewButton_2 = new JButton("Login");
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			new ManagerLogin();
			
		}
	});
	btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnNewButton_2.setBackground(new Color(175, 238, 238));
    btnNewButton_2.setBounds(740, 168, 145, 37);
	frame.getContentPane().add(btnNewButton_2);
	
	JButton btnNewButton_3 = new JButton("Admin");
	btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		frame.dispose();
		new AdminLogin();
		
		}
	});
	btnNewButton_3.setBackground(new Color(175, 238, 238));
	btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnNewButton_3.setBounds(1027, 168, 145, 37);
	frame.getContentPane().add(btnNewButton_3);
	
	JLabel lblNewLabel = new JLabel("Name:");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel.setBounds(155, 283, 76, 14);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Gender:");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_1.setBounds(155, 339, 76, 17);
	frame.getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Address:");
	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_2.setBounds(155, 398, 97, 14);
	frame.getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Mobile:");
	lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_3.setBounds(613, 289, 76, 14);
	frame.getContentPane().add(lblNewLabel_3);
	
	textField = new JTextField();
	textField.setFont(new Font("Tahoma", Font.BOLD, 13));
	textField.setBounds(316, 283, 164, 30);
	frame.getContentPane().add(textField);
	textField.setColumns(10);
	
	JComboBox comboBox = new JComboBox();
	comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
	comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
	comboBox.setBounds(316, 340, 164, 30);
	frame.getContentPane().add(comboBox);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(316, 381, 164, 65);
	frame.getContentPane().add(scrollPane);
	
	JTextArea textArea = new JTextArea();
	textArea.setFont(new Font("Tahoma", Font.BOLD, 13));
	scrollPane.setViewportView(textArea);
	
	JCheckBox chckbxNewCheckBox = new JCheckBox("Subscribe to Notifications");
	chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 13));
	chckbxNewCheckBox.setBounds(155, 489, 191, 23);
	frame.getContentPane().add(chckbxNewCheckBox);
	
	JLabel lblNewLabel_4 = new JLabel("Email:");
	lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_4.setBounds(613, 340, 86, 14);
	frame.getContentPane().add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("Password:");
	lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_5.setBounds(613, 398, 97, 14);
	frame.getContentPane().add(lblNewLabel_5);
	
	JLabel lblNewLabel_6 = new JLabel("Confirm Password:");
	lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_6.setBounds(613, 460, 191, 14);
	frame.getContentPane().add(lblNewLabel_6);
	
	textField_1 = new JTextField();
	textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	textField_1.setBounds(850, 283, 164, 30);
	frame.getContentPane().add(textField_1);
	textField_1.setColumns(10);
	
	textField_2 = new JTextField();
	textField_2.setFont(new Font("Tahoma", Font.BOLD, 13));
	textField_2.setBounds(850, 340, 164, 30);
	frame.getContentPane().add(textField_2);
	textField_2.setColumns(10);
	
	textField_3 = new JPasswordField();
	textField_3.setFont(new Font("Tahoma", Font.BOLD, 13));
	textField_3.setBounds(850, 398, 164, 30);
	frame.getContentPane().add(textField_3);
	textField_3.setColumns(10);
	
	textField_4 = new JPasswordField();
	textField_4.setFont(new Font("Tahoma", Font.BOLD, 13));
	textField_4.setBounds(850, 460, 164, 30);
	frame.getContentPane().add(textField_4);
	textField_4.setColumns(10);
	
	JButton btnNewButton_4 = new JButton("Register");
	btnNewButton_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String		notification;
			String name=textField.getText();
			String gender=(String) comboBox.getSelectedItem();
			String address=textArea.getText();
			boolean noti=chckbxNewCheckBox.isSelected();
			if (noti==true)
			{
				notification="Yes";
		
			}else
			{
				notification="No";
			}
			String mobile=textField_1.getText();
			String email=textField_2.getText();
			String pass=textField_3.getText();
			String cpass=textField_4.getText();
			if(!name.equals("")&&!gender.equals("")&&!address.equals("")&&!mobile.equals("")&&!email.equals("")&&!pass.equals("")&&!cpass.equals(""))
			{
				if(!mob(mobile))
				{
					JOptionPane.showMessageDialog(frame, "Please enter correct mobile number");

				}
				else	if(!email(email))
				{
					JOptionPane.showMessageDialog(frame, "Please enter correct email id");

				}
				else if(!cpass(pass,cpass))
				{
					JOptionPane.showMessageDialog(frame, "Password does not match");

					
				}
				else
				{
try
{
	
	PreparedStatement ps=cn.prepareStatement("insert into register(name,gender,address,notification,mobileno,email,password,cpassword) values(?,?,?,?,?,?,?,?)");
ps.setString(1, name);
ps.setString(2, gender);
ps.setString(3,address);
ps.setString(4, notification);
ps.setString(5, mobile);
ps.setString(6, email);
ps.setString(7, pass);
ps.setString(8, cpass);
ps.executeUpdate();
JOptionPane.showMessageDialog(frame, "Manager Registered");
}
catch(Exception e)
{
	JOptionPane.showMessageDialog(frame, "Something went wrong");

	System.out.println(e);
}
				}
				
			
			}
			else
			{
				JOptionPane.showMessageDialog(frame, "Please fill all the fields correctly");
			
			}
			
			
			
		}
	});
	btnNewButton_4.setForeground(new Color(0, 0, 0));
	btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnNewButton_4.setBackground(UIManager.getColor("SplitPaneDivider.draggingColor"));
	btnNewButton_4.setBounds(344, 600, 136, 39);
	frame.getContentPane().add(btnNewButton_4);
	
	JButton btnNewButton_5 = new JButton("Cancel");
	btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnNewButton_5.setForeground(new Color(0, 0, 0));
	btnNewButton_5.setBackground(UIManager.getColor("SplitPaneDivider.draggingColor"));
	btnNewButton_5.setBounds(613, 601, 136, 39);
	frame.getContentPane().add(btnNewButton_5);
	
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
}
	public static void main(String[] args) {
		new Register();
	}
	
	boolean mob(String s)
	{
    String	s1=s;
    int len=s1.length();
		if(len==10)
		{
			return true;
		}
		else
		{
			return false;
			

		}
	}
	 	boolean email(String em)
	{
		  final String regex = "^(.+)@(.+)$";
		  Pattern pattern = Pattern.compile(regex);
		  Matcher matcher = pattern.matcher(em);
		  if(matcher.matches())
		  {
			  return true;
		  }
		  else
		  {
			  return false;
		  }
	}
	 	
	 	boolean cpass(String pass,String cpass)
	 	{
	 	
	 		if(pass.equals(cpass))
	 		{
	 			return true;
	 		}
	 		else
	 		{
	 			return false;
	 		}
	 	}
}
