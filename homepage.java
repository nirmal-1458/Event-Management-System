import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class homepage {

	private JFrame frame;

homepage()
{
	frame = new JFrame();
	frame.getContentPane().setBackground(new Color(245, 255, 250));
	frame.getContentPane().setForeground(new Color(255, 153, 255));
	frame.getContentPane().setLayout(null);
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setSize(screenSize.width, screenSize.height);
	
	JLabel lblEventManagementSystem = new JLabel("Event Management System");
	lblEventManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 40));
	lblEventManagementSystem.setForeground(new Color(0, 0, 0));
	lblEventManagementSystem.setBounds(405, 11, 563, 65);
	frame.getContentPane().add(lblEventManagementSystem);
	
	JButton btnNewButton = new JButton("Home");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
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
		public void actionPerformed(ActionEvent e) {
		frame.dispose();
		new Register();
		
		}
	});
	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnNewButton_1.setBackground(new Color(175, 238, 238));
    btnNewButton_1.setBounds(449, 168, 145, 37);
	frame.getContentPane().add(btnNewButton_1);
	
	JButton btnNewButton_2 = new JButton("Login");
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
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
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new AdminLogin();
		}
	});
	btnNewButton_3.setBackground(new Color(175, 238, 238));
	btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnNewButton_3.setBounds(1027, 168, 145, 37);
	frame.getContentPane().add(btnNewButton_3);
	
	JLabel img1 = new JLabel("");
	//ImageIcon icon = new ImageIcon("C:\\Users\\tanuj\\Documents\\pic1.jpg");
	Image pic=new ImageIcon(this.getClass().getResource("/pic1.jpg")).getImage();
	ImageIcon icon=new ImageIcon(pic);

	Image scale = icon.getImage().getScaledInstance(340,450,Image.SCALE_DEFAULT);
	ImageIcon i=new ImageIcon(scale);
	img1.setBounds(0, 279, 337, 450);
	img1.setIcon(i);
	frame.getContentPane().add(img1);
	
	JLabel img2 = new JLabel("");
	//ImageIcon icon2 = new ImageIcon("C:\\Users\\tanuj\\Documents\\pic3.jpg");
	Image pic1=new ImageIcon(this.getClass().getResource("/pic3.jpg")).getImage();
	ImageIcon icon2=new ImageIcon(pic1);

	Image scale2 = icon2.getImage().getScaledInstance(340, 450,Image.SCALE_DEFAULT);
	ImageIcon i2=new ImageIcon(scale2);
	img2.setBounds(330, 279, 343, 450);
	img2.setIcon(i2);
	frame.getContentPane().add(img2);
	
	JLabel img3 = new JLabel("");
//	ImageIcon icon3 = new ImageIcon("C:\\Users\\tanuj\\Documents\\pic4.jpg");
	Image pic2=new ImageIcon(this.getClass().getResource("/pic4.jpg")).getImage();
	ImageIcon icon3=new ImageIcon(pic2);

	Image scale3 = icon3.getImage().getScaledInstance(350, 450,Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(scale3);
	img3.setBounds(666, 279, 350, 450);
	img3.setIcon(i3);

	frame.getContentPane().add(img3);
	
	JLabel img4 = new JLabel("");
//	ImageIcon icon4 = new ImageIcon("C:\\Users\\tanuj\\Documents\\pic6.jpg");
	Image pic3=new ImageIcon(this.getClass().getResource("/pic6.jpg")).getImage();
	ImageIcon icon4=new ImageIcon(pic3);

	Image scale4 = icon4.getImage().getScaledInstance(347, 450,Image.SCALE_DEFAULT);
	ImageIcon i4=new ImageIcon(scale4);
	img4.setIcon(i4);
	img4.setBounds(1003, 279, 347, 450);
	frame.getContentPane().add(img4);
	frame.setForeground(new Color(255, 153, 255));
	frame.setBackground(new Color(255, 153, 255));
	//frame.setBounds(100, 100, 450, 300);

	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
}
	public static void main(String[] args) {
		new homepage();
	}
}
