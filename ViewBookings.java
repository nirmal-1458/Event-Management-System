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

public class ViewBookings {

	private JFrame frame;
	private JTable table;
Connection cn;
static String pname,ppass;
	public ViewBookings() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(234, 100, 1000, 600);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try
		{
			PreparedStatement ps=cn.prepareStatement("select * from booking ");
			
			ResultSet rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		JLabel lblNewLabel = new JLabel("View Bookings");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(567, 11, 327, 52);
		frame.getContentPane().add(lblNewLabel);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(screenSize.width, screenSize.height);
		
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
		
		
		JButton back = new JButton("Back");
    	back.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			frame.dispose();
    			new ManagerLogin();
    		}
    	});
    back.setFont(new Font("Tahoma", Font.BOLD, 13));
    	back.setBounds(1248, 0, 102, 30);
    	frame.getContentPane().add(back);
	    
	    
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

}
	public static void main(String[] args) {
	new ViewBookings();
	}
}