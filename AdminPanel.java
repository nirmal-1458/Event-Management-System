import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel {

	private JFrame frame;
    public AdminPanel() {


    	frame = new JFrame();
    	frame.getContentPane().setBackground(new Color(176, 224, 230));
    	frame.getContentPane().setForeground(new Color(255, 153, 255));
    	frame.getContentPane().setLayout(null);
    	
    	JButton btnNewButton = new JButton("Venue Management");
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		frame.dispose();
    		new VenueManagement();
    		
    		}
    	});
    	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    	btnNewButton.setBounds(224, 237, 271, 51);
    	frame.getContentPane().add(btnNewButton);
    	
    	JButton btnNewButton_1 = new JButton("Food Management");
    	btnNewButton_1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		frame.dispose();
    		new FoodManagement();
    		
    		}
    	});
    	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
    	btnNewButton_1.setBounds(619, 237, 271, 51);
    	frame.getContentPane().add(btnNewButton_1);
    	
    	JButton btnNewButton_2 = new JButton("Equipment Management");
    	btnNewButton_2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		frame.dispose();
    		new Eqipment();
    		
    		}
    	});
    	btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
    	btnNewButton_2.setBounds(1024, 237, 279, 51);
    	frame.getContentPane().add(btnNewButton_2);
    	
    	JButton btnNewButton_3 = new JButton("View Bookings");
    	btnNewButton_3.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			frame.dispose();
    			new ViewBookings();
    		}
    	});
    	btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
    	btnNewButton_3.setBounds(453, 372, 271, 51);
    	frame.getContentPane().add(btnNewButton_3);
    	
    	JButton btnNewButton_4 = new JButton("Manage Notifications");
    	btnNewButton_4.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			frame.dispose();
    			new Adminnoti();
    		}
    	});
    	btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
    	btnNewButton_4.setBounds(874, 372, 271, 51);
    	frame.getContentPane().add(btnNewButton_4);
    	
    	JLabel lblWelcomeAdmin = new JLabel("Welcome Admin");
    	lblWelcomeAdmin.setFont(new Font("Tahoma", Font.BOLD, 35));
    	lblWelcomeAdmin.setBounds(76, 82, 298, 51);
    	frame.getContentPane().add(lblWelcomeAdmin);
    	
    	JButton back = new JButton("Back");
    	back.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			frame.dispose();
    			new AdminLogin();
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
		new AdminPanel();
	}
	}


