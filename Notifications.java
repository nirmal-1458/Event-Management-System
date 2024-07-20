import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;

public class Notifications {

	private JFrame frame;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	Connection cn;
	static String kname,kpass;
	String s1;
Notifications()
{

	frame = new JFrame();
	frame.getContentPane().setBackground(new Color(176, 224, 230));
	frame.getContentPane().setForeground(new Color(255, 153, 255));
	frame.getContentPane().setLayout(null);
	
	
	lblNewLabel_1 = new JLabel("");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblNewLabel_1.setBounds(310, 73, 528, 23);
	frame.getContentPane().add(lblNewLabel_1);
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
     cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	}catch(Exception e)
	{
		System.out.println(e);
	}
	
	try
	{
		
	PreparedStatement ps=cn.prepareStatement("select notification from register  where name=? and password=? ");
	ps.setString(1,kname);
	ps.setString(2, kpass);
	ResultSet rs=ps.executeQuery();
	//table.setModel(DbUtils.resultSetToTableModel(rs));
	while(rs.next())
	{
s1=rs.getString(1);
	}
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(310, 107, 1000, 400);
	frame.getContentPane().add(scrollPane);
	
	table = new JTable();
	scrollPane.setViewportView(table);
	
	if(s1.equals("Yes"))
	{
		try
		{
			
		PreparedStatement ps=cn.prepareStatement("select * from notification ");
	
		ResultSet rs=ps.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		while(rs.next())
		{
	s1=rs.getString(1);
		}
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	if(s1.equals("No"))
	{
		lblNewLabel_1.setText("You did not subscribe to notifications");
	}
	
	lblNewLabel = new JLabel("Notifications");
	lblNewLabel.setBounds(593, 0, 245, 48);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
	frame.getContentPane().add(lblNewLabel);
	

	JButton btnNewButton_4 = new JButton("Back");
	btnNewButton_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new AdminPanel();
		}
	});
	btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnNewButton_4.setBounds(1248, 0, 102, 30);
	frame.getContentPane().add(btnNewButton_4);
	
	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setSize(screenSize.width, screenSize.height);
	
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);	
}
	public static void main(String[] args) {
		new Notifications();
	}
	}

