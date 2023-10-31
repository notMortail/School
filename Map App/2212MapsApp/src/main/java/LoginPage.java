import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * LoginPage that takes in username and password and attempts to login user
 * Opens homepage on successful login
 * @author Richard
 */
public class LoginPage extends JFrame implements ActionListener {

    /**
     * Java swing components
     */
    Container container = getContentPane();
    JLabel lblUser = new JLabel("User Name");
    JLabel lblPassword = new JLabel("Password");
    JTextField txtUser = new JTextField();
    JPasswordField pwdPassword = new JPasswordField();
    JButton btnLogin = new JButton("Login");
    JButton btnSignUp = new JButton("Sign up");

    /**
     * Constructor
     * Creates the JFrame and components
     */
    LoginPage() {
        container.setLayout(null);
        this.setTitle("Log in");
        this.setBounds(0, 0, 370, 280);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setComponents();
        addComponents();
        addEvents();

    }

    /**
     * Sets the component sizes
     */
    public void setComponents() {
        lblUser.setBounds(50, 50, 100, 30);
        lblPassword.setBounds(50, 120, 100, 30);
        txtUser.setBounds(150, 50, 150, 30);
        pwdPassword.setBounds(150, 120, 150, 30);
        btnLogin.setBounds(50, 180, 100, 30);
        btnSignUp.setBounds(200, 180, 100, 30);
    }

    /**
     * Adds components to content pane
     */
    public void addComponents() {
        container.add(lblUser);
        container.add(lblPassword);
        container.add(txtUser);
        container.add(pwdPassword);
        container.add(btnLogin);
        container.add(btnSignUp);
    }

    /**
     * Adds listeners for buttons
     */
    public void addEvents() {
        btnLogin.addActionListener(this);
        btnSignUp.addActionListener(this);
    }

    /**
     * Listener for events
     * @param e Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String userName = txtUser.getText();
            String password = pwdPassword.getText();
            if (AccountManager.LogIn(userName, password)) {
                try {
                    new HomeWindow();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }
        if (e.getSource() == btnSignUp) {
            new SignupPage();
            this.dispose();
        }
    }

}
