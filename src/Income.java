import javax.swing.*;

public class Income {
    public void income(JPanel incomePanel, String username){
        incomePanel.setLayout(null);

        JLabel title = new JLabel("Income");


        title.setBounds(400,20,100,20);

        incomePanel.add(title);

        incomePanel.setVisible(true);

    }
}
