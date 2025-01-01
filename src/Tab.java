import javax.swing.*;

public class Tab extends JFrame {
    public void tab(String username){
        JFrame tab = new JFrame("Expense Tracker");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        tab.add(panel);
        tab.setBounds(400, 80, 800, 700);
        tab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JTabbedPane tabbedPane = new JTabbedPane();

        // Create panels for each tab
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.add(new JLabel("Welcome to the Dashboard"));

        JPanel incomePanel = new JPanel();
        Income incomeObj = new Income();
        incomeObj.income(incomePanel, username);


        JPanel expensesPanel = new JPanel();
        expensesPanel.add(new JLabel("Expense Tracking"));

        JPanel settingsPanel = new JPanel();
        settingsPanel.add(new JLabel("Settings Configuration"));

        // Add the panels to the tabbed pane with names
        tabbedPane.addTab("Dashboard", dashboardPanel);
        tabbedPane.addTab("Income", incomePanel);
        tabbedPane.addTab("Expenses", expensesPanel);
        tabbedPane.addTab("Settings", settingsPanel);

        panel.add(tabbedPane);
        tabbedPane.setBounds(0, 50, 800, 650); // Adjust the tabbed pane's position and size

        // Set the frame visible after all components are added
        tab.setVisible(true);



    }
}
