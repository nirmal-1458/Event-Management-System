import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

import datechooser.beans.DateChooserCombo;
import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

public class BookEvent {

	private JFrame frame;
	private JTextField textField;
Connection cn;
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_4;
ArrayList<String> values,values1;
int fcost=0;
int ecost=0;
String y5="",y6="";
static String mname,mpass;
	public BookEvent() {
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	     cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.getContentPane().setForeground(new Color(255, 153, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(885, 191, 400, 300);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Book An Event");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(550, 11, 327, 73);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Event Type:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(55, 114, 95, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblVenue = new JLabel("Venue:");
		lblVenue.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVenue.setBounds(55, 191, 71, 14);
		frame.getContentPane().add(lblVenue);
		
		JLabel lblVenueType = new JLabel("Venue Type:");
		lblVenueType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVenueType.setBounds(55, 255, 95, 25);
		frame.getContentPane().add(lblVenueType);
		
		JLabel lblNewLabel_2 = new JLabel("Event Date:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(55, 325, 96, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Food Items:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(55, 389, 95, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Equipments:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(54, 511, 110, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("No of Guests");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(55, 627, 101, 25);
		frame.getContentPane().add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BirthdayParty", "Conference", "FamilyEvent", "ProductLaunch", "Seminar", "ThemeParty", "Wedding"}));
		comboBox.setBounds(240, 112, 178, 33);
		frame.getContentPane().add(comboBox);
	

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Outdoor", "Indoor"}));
		comboBox_2.setBounds(240, 253, 178, 33);
		frame.getContentPane().add(comboBox_2);
		
		

		try
		{
			values = new ArrayList<String>();

		PreparedStatement ps=cn.prepareStatement("select fooditemname from food");
		ResultSet rs=ps.executeQuery();
	

		while(rs.next())
			{
			String s1=rs.getString(1);
			values.add(s1);
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		

		JList list = new JList(values.toArray());
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object[] s1=list.getSelectedValues();
				fcost=0;
				for(int i=0;i<s1.length;i++)
				{
					
					System.out.println(i);
					System.out.println("hi");
					String name=(String)s1[i];
					try
					{
						

					PreparedStatement ps=cn.prepareStatement("select fooditemcost from food where fooditemname=?");
					ps.setString(1, name);
					ResultSet rs=ps.executeQuery();
				

					while(rs.next())
						{
						String s2=rs.getString(1);
						int r=Integer.parseInt(s2);
						fcost=fcost+r;
							}
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					
				}
				System.out.println(fcost);
	 		    String c=String.valueOf(fcost);
				textField_2.setText(c);
				
			}
		});

		list.setBounds(241, 388, 178, 88);
		frame.getContentPane().add(list);
		
		
	
		
		try
		{
			values1 = new ArrayList<String>();

		PreparedStatement ps=cn.prepareStatement("select equipmentname from equipment");
		ResultSet rs=ps.executeQuery();
	

		while(rs.next())
			{
			String s1=rs.getString(1);
			values1.add(s1);
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		JList list_1 = new JList(values1.toArray());
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object[] s1=list_1.getSelectedValues();
				ecost=0;
				for(int i=0;i<s1.length;i++)
				{
					
					System.out.println(i);
					System.out.println("hi");
					String name=(String)s1[i];
					try
					{
						

					PreparedStatement ps=cn.prepareStatement("select equipmentcost from equipment where EQUIPMENTNAME=?");
					ps.setString(1, name);
					ResultSet rs=ps.executeQuery();
				

					while(rs.next())
						{
						String s2=rs.getString(1);
						
						int r=Integer.parseInt(s2);
						ecost=ecost+r;
							}
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					
				}
				System.out.println(ecost);
	 		    String c=String.valueOf(ecost);
				textField_3.setText(c);
				
			
			}
		});
		list_1.setBounds(239, 510, 178, 88);
		frame.getContentPane().add(list_1);
		
		
		
		DateChooserCombo dateChooserCombo = new DateChooserCombo();
		dateChooserCombo.setBounds(240, 320, 178, 33);
		frame.getContentPane().add(dateChooserCombo);
		
	
		
		JLabel lblNewLabel_7 = new JLabel("Venue Cost:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(753, 541, 101, 19);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Food Items Cost:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(755, 584, 135, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Equipments Cost:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(753, 634, 137, 18);
		frame.getContentPane().add(lblNewLabel_9);
		
		textField_1 = new JTextField("0");
		textField_1.setBounds(946, 542, 166, 33);
		textField_1.setEditable(false);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField("0");
		textField_2.setColumns(10);
		textField_2.setBounds(946, 583, 166, 33);
		textField_2.setEditable(false);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField("0");
		textField_3.setColumns(10);
		textField_3.setBounds(946, 631, 166, 33);
		textField_3.setEditable(false);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField("0");
		textField_4.setColumns(10);
		textField_4.setBounds(946, 678, 166, 33);
		textField_4.setEditable(false);
		frame.getContentPane().add(textField_4);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(screenSize.width, screenSize.height);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s1=(String) comboBox_1.getSelectedItem();
				System.out.println(s1);
				try
				{
				PreparedStatement ps=cn.prepareStatement("select vimage from venue where vname=?");
				ps.setString(1, s1);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					byte[] ph=rs.getBytes(1);
					ImageIcon photo=new ImageIcon(ph);
					Image ph1=photo.getImage().getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
					ImageIcon ph2=new ImageIcon(ph1);
					label.setIcon(ph2);
				}
				
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				try
				{
					PreparedStatement pss=cn.prepareStatement("select vcost from venue where vname=?");
					pss.setString(1, s1);
					ResultSet rss=pss.executeQuery();
					while(rss.next())
					{
						String s2=rss.getString(1);
						textField_1.setText(s2);
						
					}
				}
				catch(Exception e) 
				{
					System.out.println(e);
				}
			}
		});
		comboBox_1.setBounds(240, 184, 178, 33);
		frame.getContentPane().add(comboBox_1);
		
		try
		{
		PreparedStatement ps=cn.prepareStatement("select vname from venue");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			{
			String s1=rs.getString(1);
			comboBox_1.addItem(s1);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		
		

		textField = new JTextField("0");
		
		textField.setBounds(236, 629, 181, 33);
		
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String e1=textField_1.getText();
				String e2=textField_2.getText();
				String e3=textField_3.getText();
				String e4=textField.getText();
				if(e4.equals("")||e4.equals("0"))
				{
					e4="1";
				}
				int u1=Integer.parseInt(e1);
				int u2=Integer.parseInt(e2);
				int u3=Integer.parseInt(e3);
				int u4=Integer.parseInt(e4);
				int u9=u2*u4;
				int u10=u1+u9+u3;
				String v4=String.valueOf(u10);
				textField_4.setText(v4);
				
				String s1=(String)comboBox.getSelectedItem();
			    String s2=(String)comboBox_1.getSelectedItem();
			    String s3=(String)comboBox_2.getSelectedItem();
			    String s4=dateChooserCombo.getText();
				Object[] l1=list.getSelectedValues();
				y5="";
				for(int i=0;i<l1.length;i++)
				{
					
					String l2=(String) l1[i];
					
					y5=y5.concat(l2);
					
					y5=y5.concat(",");
				}
				String s5=y5;

			
			



Object[] l2=list_1.getSelectedValues();
y6="";
for(int i=0;i<l2.length;i++)
{
	
	String d2=(String) l2[i];
	
	y6=y6.concat(d2);
	
	y6=y6.concat(",");
}
String s6=y6;

String s7=textField.getText();
String tcost=textField_4.getText();
try
{
	PreparedStatement ps=cn.prepareStatement("insert into booking(manager_name,manager_password,event_type,venue_name,venue_type,event_date,food_items,equipments,guests,event_cost) values(?,?,?,?,?,?,?,?,?,?)");
	ps.setString(1, mname);
	ps.setString(2, mpass);
	ps.setString(3, s1);
	ps.setString(4, s2);
	ps.setString(5, s3);
	ps.setString(6, s4);
	ps.setString(7, s5);
	ps.setString(8, s6);
	ps.setString(9, s7);
	ps.setInt(10, u10);
	ps.executeUpdate();
	JOptionPane.showMessageDialog(frame, "Booked");

}
catch(Exception e)
{
	JOptionPane.showMessageDialog(frame, "Something went wrong");

	System.out.println(e);
}
}


		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(258, 678, 116, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("TotalCost");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String e1=textField_1.getText();
				String e2=textField_2.getText();
				String e3=textField_3.getText();
				String e4=textField.getText();
				if(e4.equals("")||e4.equals("0"))
				{
					e4="1";
				}
				int u1=Integer.parseInt(e1);
				int u2=Integer.parseInt(e2);
				int u3=Integer.parseInt(e3);
				int u4=Integer.parseInt(e4);
				int u9=u2*u4;
				int u10=u1+u9+u3;
				String v4=String.valueOf(u10);
				textField_4.setText(v4);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(831, 682, 101, 23);
		frame.getContentPane().add(btnNewButton_1);
		


    	JButton back = new JButton("Back");
    	back.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			frame.dispose();
    			new ManagerPanel();
    		}
    	});
    back.setFont(new Font("Tahoma", Font.BOLD, 13));
    	back.setBounds(1248, 0, 102, 30);
    	frame.getContentPane().add(back);
    	
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
			}
	public static void main(String[] args) {
		new BookEvent();
	}
}
