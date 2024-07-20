import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adminnoti {

	private JFrame frame;
Connection cn;

	public Adminnoti() {
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
		
		
		
		
		JLabel lblNewLabel = new JLabel("Notification");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(567, 11, 327, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(705, 207, 400, 300);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Send Notification");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
					String s=textArea.getText();
					PreparedStatement ps=cn.prepareStatement("insert into notification values(?) ");
	                ps.setString(1, s);
	                ps.executeUpdate();
	                JOptionPane.showMessageDialog(frame, "Notification Sent");
				}
				catch(Exception e1)
				{
					   JOptionPane.showMessageDialog(frame, "Something Went Wrong");

					System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(385, 207, 170, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AdminPanel();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(1251, 0, 99, 31);
		frame.getContentPane().add(btnNewButton_1);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(screenSize.width, screenSize.height);
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

}
	public static void main(String[] args) {
	new Adminnoti();
	}
}