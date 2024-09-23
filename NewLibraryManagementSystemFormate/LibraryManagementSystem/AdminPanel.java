import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JFrame {
    private MainLogin mainLogin;

    public AdminPanel(MainLogin mainLogin) {
        this.mainLogin = mainLogin;
        setTitle("Admin Panel");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createMenu("Maintenance"));
        menuBar.add(createMenu("Reports"));
        menuBar.add(createMenu("Transactions"));
        setJMenuBar(menuBar);

        JPanel actionPanel = new JPanel();
        actionPanel.add(createButton("Log Out"));
        add(actionPanel, BorderLayout.SOUTH);
    }

    private JMenu createMenu(String title) {
        JMenu menu = new JMenu(title);
        menu.add(createMenuItem("Add Book"));
        menu.add(createMenuItem("Update Book"));
        menu.add(createMenuItem("View Reports"));
        return menu;
    }

    private JMenuItem createMenuItem(String text) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.addActionListener(e -> {
            if (text.equals("Add Book")) {
                new BookManagementForm(this).setVisible(true);
            } else if (text.equals("Update Book")) {
                // Call update book form
                new BookManagementForm(this, true).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, text + " selected!");
            }
        });
        return menuItem;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(e -> {
            mainLogin.setVisible(true);
            this.dispose();
        });
        return button;
    }
}
