import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.table.DefaultTableModel;

public class FoodManagement {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	ImageIcon icon;
	ImageIcon image1;
	String filename;
	File f;
	String n1;
	private JTable table;
	Connection cn;
FoodManagement()
{
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
	
	JLabel lblNewLabel = new JLabel("Food Management");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
	lblNewLabel.setBounds(499, 11, 409, 87);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblVenueId = new JLabel("FoodItem ID:");
	lblVenueId.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblVenueId.setBounds(81, 154, 112, 19);
	frame.getContentPane().add(lblVenueId);
	
	JLabel lblNewLabel_1 = new JLabel("FoodItem Name:");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_1.setBounds(81, 232, 135, 25);
	frame.getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_3 = new JLabel("FoodItem Cost:");
	lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_3.setBounds(81, 312, 135, 19);
	frame.getContentPane().add(lblNewLabel_3);
	
	JLabel lblNewLabel_5 = new JLabel("Venue Image:");
	lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_5.setBounds(81, 411, 102, 19);
	frame.getContentPane().add(lblNewLabel_5);
	
	JPanel panel = new JPanel();
	panel.setBounds(259, 420, 255, 150);
	frame.getContentPane().add(panel);
	panel.setLayout(null);
	
	JLabel label = new JLabel("");
	label.setBounds(0, 0, 255, 150);
	panel.add(label);
	
	JButton btnNewButton = new JButton("Select Image");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser=new JFileChooser();
			chooser.showOpenDialog(null);
			f=chooser.getSelectedFile();
			filename=f.getAbsolutePath();
		//	Image getAbsolutePath=null;
			icon=new ImageIcon(filename);
			Image image=icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
			 image1=new ImageIcon(image);
			label.setIcon(image1);
			
		}
	});
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnNewButton.setBounds(326, 591, 132, 30);
	frame.getContentPane().add(btnNewButton);
	
	
	textField = new JTextField();
	textField.setBounds(259, 145, 255, 30);
	//textField.setEnabled(false);
	textField.setEditable(false);
	frame.getContentPane().add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setBounds(259, 231, 255, 30);
	frame.getContentPane().add(textField_1);
	textField_1.setColumns(10);
	
	textField_3 = new JTextField();
	textField_3.setBounds(259, 313, 255, 30);
	frame.getContentPane().add(textField_3);
	textField_3.setColumns(10);

	
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(641, 145, 700, 400);
	frame.getContentPane().add(scrollPane);
	
	table = new JTable();
	scrollPane.setViewportView(table);
	
	try
	{
	PreparedStatement ps=cn.prepareStatement("select * from food ");
	ResultSet rs=ps.executeQuery();
	table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	
	table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			int a=table.getSelectedRow();
			String s1=(table.getModel().getValueAt(a, 0).toString());
			String s2=(table.getModel().getValueAt(a, 1).toString());
			String s3=(table.getModel().getValueAt(a, 2).toString());
			
			
			int i=Integer.parseInt(s1);
			textField.setText(s1);
			textField_1.setText(s2);
			
			textField_3.setText(s3);
						try
			{
			PreparedStatement ps=cn.prepareStatement("select fooditemimage from food where fooditemid=?");
			ps.setInt(1, i);
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
			
			System.out.println(s1);
		}
	});
	
	
	JButton btnNewButton_1 = new JButton("INSERT");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String s1=textField_1.getText();
		
			String s3=textField_3.getText();
			
			
			try
			{
				
				InputStream in=new FileInputStream(f);
			PreparedStatement ps=cn.prepareStatement("insert into Food(FoodItemName,FoodItemCost,FoodItemImage) values(?,?,?)");
		    ps.setString(1, s1);
		  
		    ps.setString(2, s3);
		   
		    ps.setBinaryStream(3, in);
		    ps.executeUpdate();
		    JOptionPane.showMessageDialog(frame, "Inserted");

		    
		    System.out.println("ok");
		    String name=textField_1.getText();
			PreparedStatement pss=cn.prepareStatement("select fooditemid from Food where fooditemname=?");
			pss.setString(1, name);
			ResultSet rs=pss.executeQuery();
			while(rs.next())
			{
				 n1= rs.getString(1);
			}
			System.out.println(n1);
			textField.setText(n1);
			System.out.println("okk");
            
			}
			catch(Exception e)
			{
			    JOptionPane.showMessageDialog(frame, "Something went wrong");

				System.out.println(e);
			}

			try
			{
			PreparedStatement ps=cn.prepareStatement("select * from Food");
			ResultSet rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		}
	});
	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnNewButton_1.setBounds(94, 658, 122, 30);
	frame.getContentPane().add(btnNewButton_1);
	
	JButton btnNewButton_2 = new JButton("UPDATE");
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String id=textField.getText();
			int i=Integer.parseInt(id);
			String s2=textField_1.getText();
			
			String s3=textField_3.getText();
			
			if(filename==null)
			{
				try{
					
					PreparedStatement ps=cn.prepareStatement("update food set fooditemname=?,fooditemcost=? where fooditemid=?");
					ps.setString(1, s2);
				
					ps.setString(2, s3);
					
					ps.setInt(3, i);
				
					ps.executeUpdate();
				    JOptionPane.showMessageDialog(frame, "Updated");

					PreparedStatement pss=cn.prepareStatement("select * from food");
					ResultSet rs=pss.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					System.out.println("ok");
					
					}
					catch(Exception e)
					{
					    JOptionPane.showMessageDialog(frame, "Something went wrong");

					System.out.println(e);
					}
			}
			if(filename!=null)
			{
				try
				{
					InputStream in=new FileInputStream(f);
					PreparedStatement ps=cn.prepareStatement("update food set fooditemname=?,fooditemcost=?,fooditemimage=? where fooditemid=?");
					ps.setString(1, s2);
					
					ps.setString(2, s3);
					
					ps.setBinaryStream(3, in);
					ps.setInt(4, i);
				    ps.executeUpdate();
				    JOptionPane.showMessageDialog(frame, "Updated");

				    PreparedStatement pss=cn.prepareStatement("select * from food");
					ResultSet rs=pss.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e)
				{
				    JOptionPane.showMessageDialog(frame, "Something went wrong");

					System.out.println(e);
				}
			}
		}
	});
	btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnNewButton_2.setBounds(244, 658, 122, 30);
	frame.getContentPane().add(btnNewButton_2);
	
	JButton btnNewButton_3 = new JButton("DELETE");
	btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try
			{
				String id=textField.getText();
				int i=Integer.parseInt(id);
				PreparedStatement ps=cn.prepareStatement("delete from food where fooditemid=?");
				ps.setInt(1,i);
				ps.executeUpdate();
			    JOptionPane.showMessageDialog(frame, "Deleted");

				PreparedStatement pss=cn.prepareStatement("select * from food");
					ResultSet rs=pss.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

			}
			catch(Exception e)
			{
			    JOptionPane.showMessageDialog(frame, "Something went wrong");

				System.out.println(e);
			}
		}
	});
	btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnNewButton_3.setBounds(392, 658, 122, 30);
	frame.getContentPane().add(btnNewButton_3);
	
	
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
    frame.setVisible(true);
   	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		
}

	public static void main(String[] args) {
		new FoodManagement();
	}
}

