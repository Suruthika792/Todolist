package todolist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JPasswordField passwordField;
	protected JLabel lblNewLabel ,lblNewLabel_1,lblNewLabel_4,lblNewLabel_5  ;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	Connection con=null;
	public Login() {
		con =(Connection) DB.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 5, 426, 0);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login Form");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel_1.setBounds(104, 11, 232, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("User Id");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(42, 187, 74, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection con =null;
					String Driver ="com.mysql.cj.jdbc.Driver";
					String url="jdbc:locahost:3306/new_db";
					String username="root";
					String password="1234567";
					String user=textField_2.getText();
					String pwd= String.valueOf(passwordField.getPassword());
					PreparedStatement pst =con. prepareStatement("select *from signup where userid=? and password=?");
					pst.setNString(1, user);
					pst.setNString(2, pwd);
					ResultSet r =pst.executeQuery();
				    if(r.next())
					{
						todo s = new todo();
						s.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "incorrect id or pwd");
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}

			

			
		}
				);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(159, 320, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(39, 220, 89, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(194, 186, 127, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(194, 219, 127, 20);
		contentPane.add(passwordField);
	}

	
}
