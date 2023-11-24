package register_form;

import java.awt.EventQueue;


import javax.swing.border.EmptyBorder;

import java.sql.*;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register_form {

	private JFrame frame;
	private JTextField rname;
	private JTextField uname;
	private JTextField password;
	private JTextField cpassword;
	private JTextField email;
	private JTextField phoneno;
	private JTextField address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_form window = new Register_form();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register_form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 489, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(35, 11, 115, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(89, 45, 36, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setBounds(67, 70, 58, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm Password:");
		lblNewLabel_3.setBounds(35, 120, 90, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email:");
		lblNewLabel_4.setBounds(96, 148, 36, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Phone:");
		lblNewLabel_5.setBounds(89, 173, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Password:");
		lblNewLabel_6.setBounds(70, 95, 55, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address:");
		lblNewLabel_7.setBounds(79, 198, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		rname = new JTextField();
		rname.setBounds(152, 42, 299, 20);
		frame.getContentPane().add(rname);
		rname.setColumns(10);
		
		uname = new JTextField();
		uname.setBounds(152, 67, 299, 20);
		frame.getContentPane().add(uname);
		uname.setColumns(10);
		
		password = new JTextField();
		password.setBounds(152, 95, 299, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		cpassword = new JTextField();
		cpassword.setBounds(152, 120, 299, 20);
		frame.getContentPane().add(cpassword);
		cpassword.setColumns(10);
		
		email = new JTextField();
		email.setBounds(152, 145, 299, 20);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		phoneno = new JTextField();
		phoneno.setBounds(152, 170, 299, 20);
		frame.getContentPane().add(phoneno);
		phoneno.setColumns(10);
		
		address = new JTextField();
		address.setBounds(152, 195, 299, 20);
		frame.getContentPane().add(address);
		address.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name=rname.getText();
				String Username=uname.getText();
				String Password=password.getText();
				String Email=email.getText();
				String PhoneNumb=phoneno.getText();
				String Address=address.getText();
				String ConfirmPassword=cpassword.getText();
				
				
				
				 try {
	                    
	                    Class.forName("com.mysql.cj.jdbc.Driver");

	                    // Replace the placeholder values with your actual database credentials and connection details
	                    //Class.forName("com.mysql.cj.jdbc.Driver");
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Registration","root","0928");
	    				String sql="select * from login where name=? AND Username=? AND Password=? AND Email=? AND PhoneNumb=? AND Address=?";
	    				PreparedStatement pst=con.prepareStatement(sql);
	    				pst.setString(1,Name);
	    				pst.setString(2,Username);
	    				pst.setString(3,Password);
	    				pst.setString(4,Email);
	    				pst.setString(5,PhoneNumb);
	    				pst.setString(6,Address);
	    				
	    				ResultSet rs=pst.executeQuery();
	                 
	                    

	                  

	                } catch(Exception e1){
						System.out.println(e1);
						}
			}
		});
		btnNewButton.setBounds(152, 230, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rname.setText("");
				uname.setText("");
				password.setText("");
				cpassword.setText("");
				email.setText("");
				phoneno.setText("");
				address.setText("");
		
			}
		});
		btnNewButton_1.setBounds(263, 230, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {System.exit(0);
			}
		});
		btnNewButton_2.setBounds(362, 230, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
