import javax.swing.*;
import java.awt.*;

public class BookIssueForm extends JFrame {
    private JTextField bookNameField;
    private JTextField authorField;

    public BookIssueForm(UserPanel userPanel) {
        setTitle("Issue Book");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2));

        bookNameField = new JTextField();
        authorField = new JTextField();
        authorField.setEditable(false); // Non-editable

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> issueBook());

        add(new JLabel("Book Name:"));
        add(bookNameField);
        add(new JLabel("Author Name:"));
        add(authorField);
        add(submitButton);
    }

    private void issueBook() {
        String bookName = bookNameField.getText();
        // Implement validations
        if (bookName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Book Name is required!");
        } else {
            // Process issue
            JOptionPane.showMessageDialog(this, "Book issued successfully!");
        }
    }
}
