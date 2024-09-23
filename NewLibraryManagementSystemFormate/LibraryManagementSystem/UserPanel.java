import javax.swing.*;
import java.awt.*;

public class UserPanel extends JFrame {
    private MainLogin mainLogin;

    public UserPanel(MainLogin mainLogin) {
        this.mainLogin = mainLogin;
        setTitle("User Panel");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton issueBookButton = new JButton("Issue Book");
        issueBookButton.addActionListener(e -> new BookIssueForm(this).setVisible(true));

        JButton returnBookButton = new JButton("Return Book");
        returnBookButton.addActionListener(e -> new ReturnBookForm(this).setVisible(true));

        panel.add(issueBookButton);
        panel.add(returnBookButton);

        add(panel);
    }
}
