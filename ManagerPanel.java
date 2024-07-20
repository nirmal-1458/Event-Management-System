import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ManagerPanel {

	private JFrame frame;
	static String mmname,mmpass;
	Connection cn;

    public ManagerPanel() {
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
    	
    	JButton btnNewButton = new JButton("View Venues");
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			frame.dispose();
    			new ViewVenues();
    		}
    	});
    	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    	btnNewButton.setBounds(265, 237, 271, 51);
    	frame.getContentPane().add(btnNewButton);
    	
    	JButton btnNewButton_1 = new JButton("View Food Items");
    	btnNewButton_1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			frame.dispose();
    			new ViewFood();
    		}
    	});
    	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
    	btnNewButton_1.setBounds(619, 237, 271, 51);
    	frame.getContentPane().add(btnNewButton_1);
    	
    	JButton btnNewButton_2 = new JButton("View Equipments");
    	btnNewButton_2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			frame.dispose();
    			new ViewEquipment();
    		}
    	});
    	btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
    	btnNewButton_2.setBounds(975, 237, 279, 51);
    	frame.getContentPane().add(btnNewButton_2);
    	
    	JButton btnNewButton_3 = new JButton("Book Event");
    	btnNewButton_3.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		frame.dispose();
    		new BookEvent();
    		
    		}
    	});
    	btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
    	btnNewButton_3.setBounds(265, 405, 271, 51);
    	frame.getContentPane().add(btnNewButton_3);
    	
    	JButton btnNewButton_4 = new JButton("Booking History");
    	btnNewButton_4.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			frame.dispose();
    			
    			new BookingHistory();
    		}
    	});
    	btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
    	btnNewButton_4.setBounds(635, 405, 271, 51);
    	frame.getContentPane().add(btnNewButton_4);
    	
    	JLabel lblWelcomeAdmin = new JLabel("Welcome");
    	lblWelcomeAdmin.setFont(new Font("Tahoma", Font.BOLD, 35));
    	lblWelcomeAdmin.setBounds(76, 82, 298, 51);
    	frame.getContentPane().add(lblWelcomeAdmin);
    	
    	JButton btnNewButton_5 = new JButton("View Notifications");
    	btnNewButton_5.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			frame.dispose();
    			new Notifications();
    		}
    	});
    	btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 20));
    	btnNewButton_5.setBounds(975, 407, 289, 49);
    	frame.getContentPane().add(btnNewButton_5);
    	
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
    	
    	
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new ManagerPanel();
	}
	}


