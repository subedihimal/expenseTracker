import javax.swing.*;
import java.sql.*;

public class Login extends JFrame{
    JLabel nameLabel = new JLabel("Enter Username");
    JLabel passwordLabel = new JLabel("Enter Password");
    JTextField inputUsername = new JTextField();
    JPasswordField inputPassword = new JPasswordField();
    JPanel panel = new JPanel();
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    JLabel resultTv = new JLabel();

    public Login(){
        this.add(panel);
        panel.setLayout(null);
        setTitle("Login");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(400, 90, 800, 700);

        nameLabel.setBounds(300, 200, 200, 30);
        inputUsername.setBounds(300, 240, 230, 30);
        passwordLabel.setBounds(300, 270, 200, 30);
        inputPassword.setBounds(300, 310, 230, 30);
        loginButton.setBounds(300, 360, 100, 30);
        registerButton.setBounds(430, 360, 100, 30);
        resultTv.setBounds(340, 420, 500, 80);

        panel.add(nameLabel);
        panel.add(inputUsername);
        panel.add(passwordLabel);
        panel.add(inputPassword);
        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(resultTv);

        panel.repaint();
        loginButton.addActionListener(v -> {
            authentication();
            this.dispose();
        });
        registerButton.addActionListener(v -> {
            registration();
        });
    }
    public void registration(){
        String username = inputUsername.getText();
        String password = inputPassword.getText();
        String sql = "INSERT INTO users VALUES ('" + username +"','" + password +"');";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectExpenseTracker", "root", "root");
            PreparedStatement ps = conn.prepareStatement(sql);
            int result = ps.executeUpdate();
            if(result == 1){
                resultTv.setText("Registration Successful Please Login!!");
            }else{
                resultTv.setText("Error Registering");
            }
            ps.close();
            conn.close();
        }catch(SQLException e){
                resultTv.setText("Username Already Exists");
        }
        catch (Exception e){
            resultTv.setText("Error:"+ e.getMessage());
        }
    }
    public void authentication(){
        String username = inputUsername.getText();
        String password = inputPassword.getText();
        String sql = "select * from users where username ='" + username +"' and password= '" + password +"';";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/projectExpenseTracker", "root", "root");
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Tab obj = new Tab();
                obj.tab(username);
            }else{
                resultTv.setText("Incorrect Username or Password");
            }
            rs.close();
            ps.close();
            conn.close();
        }catch (Exception e){
            resultTv.setText("Error:"+ e.getMessage());
        }
    }
    public static void main(String[] args){
        Login login = new Login();
    }
}
