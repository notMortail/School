import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Signup page that takes in username, password, confirm password and creates an account
 * in local SQL database
 * @author Richard
 */
public class SignupPage extends JFrame implements ActionListener {
    /**
     * Java swing components
     */
    Container container = getContentPane();
    JLabel lblUser = new JLabel("User Name");
    JLabel lblPassword = new JLabel("Password");
    JLabel lblConfirm = new JLabel("Confirm Password");
    JTextField txtUser = new JTextField();
    JPasswordField pwdPassword = new JPasswordField();
    JPasswordField pwdConfirm = new JPasswordField();
    JButton btnSignup = new JButton("Create Account");
    JButton btnLogin = new JButton("Log In");

    /**
     * Constructor
     * Creates JFrame and components
     */
    SignupPage(){
        container.setLayout(null);
        this.setBounds(0,0,420,400);
        this.setTitle("Sign Up");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setComponents();
        addComponents();
        addEvents();
    }

    /**
     * Sets component sizes
    */
    public void setComponents() {
        lblUser.setBounds(50, 50, 100, 30);
        lblPassword.setBounds(50, 120, 100, 30);
        lblConfirm.setBounds(50, 190, 150,30);
        txtUser.setBounds(200, 50, 150, 30);
        pwdPassword.setBounds(200, 120, 150, 30);
        pwdConfirm.setBounds(200,190,150,30);
        btnSignup.setBounds(130, 250, 150, 30);
        btnLogin.setBounds(155, 310, 100, 30);
    }

    /**
     * Adds components to content pane
     */
    public void addComponents() {
        container.add(lblUser);
        container.add(lblPassword);
        container.add(lblConfirm);
        container.add(txtUser);
        container.add(pwdPassword);
        container.add(pwdConfirm);
        container.add(btnSignup);
        container.add(btnLogin);
    }

    /**
     * Adds listeners
     */
    public void addEvents() {
        btnLogin.addActionListener(this);
        btnSignup.addActionListener(this);
    }

    /**
     * Listener
     * @param e event 
     */
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnSignup && pwdPassword.getText().equals(pwdConfirm.getText())){
            if(AccountManager.SignUp(txtUser.getText(), pwdPassword.getText())){
                //AccountManager.LogIn(txtUser.getText(), pwdPassword.getText());
                try {
                    new HomeWindow();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Account creation unsuccessful");
            }
        }
        else if (e.getSource() == btnSignup){
            JOptionPane.showMessageDialog(this, "Account creation unsuccessful");
        }

        if(e.getSource() == btnLogin){
            new LoginPage();
            this.dispose();
        }
    }
}
