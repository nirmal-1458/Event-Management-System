import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ManagerLogin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;
	Connection cn;
	ManagerLogin()
	{

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.getContentPane().setForeground(new Color(255, 153, 255));
		frame.getContentPane().setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(screenSize.width, screenSize.height);
	
	    try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e+"conn");
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
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			new Register();
			
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(175, 238, 238));
	    btnNewButton_1.setBounds(449, 168, 145, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Login");
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
		
		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(907, 363, 96, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(906, 442, 97, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(1080, 363, 109, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(1080, 441, 109, 29);
		
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Submit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=textField.getText();
				String password=textField_1.getText();
				
				try
				{

				PreparedStatement ps=cn.prepareStatement("select * from register where name=? and password=?");
			    ps.setString(1, name);
			    ps.setString(2, password);
			   // boolean rs=ps.execute();
			  //  boolean c=ps.executeQuery();
			    ResultSet rs=ps.executeQuery();
			  // System.out.println(rs);
			   if(rs.next())
			   {
				   BookEvent.mname=name;
					BookEvent.mpass=password;
					ManagerPanel.mmname=name;
					ManagerPanel.mmpass=password;
					BookingHistory.mmmname=name;
					BookingHistory.mmmpass=password;
					Notifications.kname=name;
					Notifications.kpass=password;
					ViewBookings.pname=name;
					ViewBookings.ppass=password;
					JOptionPane.showMessageDialog(frame, "Login Successful");
					frame.dispose();
				new ManagerPanel();
			   }
			   else
			   {
					JOptionPane.showMessageDialog(frame, "Something went wrong");

				   System.out.println("wrong");
			   }
			
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBackground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		btnNewButton_4.setBounds(918, 549, 115, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Cancel");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new homepage();
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_5.setBackground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		btnNewButton_5.setBounds(1080, 549, 125, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		
		
	
		
		
		JLabel img1 = new JLabel("New label");
		img1.setBounds(0, 279, 337, 450);
		frame.getContentPane().add(img1);
		Image img=new ImageIcon(this.getClass().getResource("/pic7.jpg")).getImage();
		ImageIcon im=new ImageIcon(img);
     	Image scale = im.getImage().getScaledInstance(340,450,Image.SCALE_DEFAULT);
		ImageIcon im2=new ImageIcon(scale);
		img1.setIcon(im);
		
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(338, 279, 340, 450);
		frame.getContentPane().add(lblNewLabel_3);
		Image img2=new ImageIcon(this.getClass().getResource("/pic8.jpg")).getImage();
		ImageIcon im3=new ImageIcon(img2);
     	Image scale1 = im3.getImage().getScaledInstance(340,450,Image.SCALE_DEFAULT);
		ImageIcon im4=new ImageIcon(scale1);
		lblNewLabel_3.setIcon(im4);
		
	/*	passwordField = new JPasswordField();
		passwordField.setBounds(997, 297, 6, 20);
		frame.getContentPane().add(passwordField);*/
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ManagerLogin();
	}
}
