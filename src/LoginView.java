import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LoginView {

	private JFrame frame;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void LaunchView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Client client = new Client();
		frame = new JFrame();
		frame.setBounds(100, 100, 543, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblScrabble = new JLabel("Scrabble");
		lblScrabble.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		lblScrabble.setBounds(181, 6, 182, 120);
		frame.getContentPane().add(lblScrabble);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblUserName.setBounds(375, 131, 121, 16);
		frame.getContentPane().add(lblUserName);
		
		username = new JTextField();
		username.setBounds(375, 163, 130, 26);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] action = new String[1];
				action[0] = username.getText();
				client.loginRequest(action);
			}
		});
		btnLogin.setBounds(375, 201, 117, 29);
		frame.getContentPane().add(btnLogin);
	}
}
