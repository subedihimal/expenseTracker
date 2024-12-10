import javax.swing.*;

public class Login extends JFrame{
    JLabel nameLabel = new JLabel("Enter Username");
    JLabel passwordLabel = new JLabel("Enter Password");
    JTextField inputUsername = new JTextField();
    JPasswordField inputPassword = new JPasswordField();
    JPanel panel = new JPanel();
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");

    public Login(){
        this.add(panel);
        panel.setLayout(null);
        setVisible(true);
        setBounds(400, 90, 800, 700);

        nameLabel.setBounds(300, 200, 200, 30);
        inputUsername.setBounds(300, 240, 230, 30);
        passwordLabel.setBounds(300, 270, 200, 30);
        inputPassword.setBounds(300, 310, 230, 30);
        loginButton.setBounds(300, 360, 100, 30);
        registerButton.setBounds(430, 360, 100, 30);

        panel.add(nameLabel);
        panel.add(inputUsername);
        panel.add(passwordLabel);
        panel.add(inputPassword);
        panel.add(loginButton);
        panel.add(registerButton);

        panel.repaint();
    }
    public static void main(String[] args){
        Login obj = new Login();
    }
}
