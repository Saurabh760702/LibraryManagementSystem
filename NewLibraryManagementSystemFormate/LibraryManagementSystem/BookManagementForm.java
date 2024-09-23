import javax.swing.*;
import java.awt.*;

public class BookManagementForm extends JFrame {
    private JTextField bookNameField;
    private JTextField authorField;
    private JTextField isbnField;

    public BookManagementForm(AdminPanel adminPanel) {
        this(adminPanel, false);
    }

    public BookManagementForm(AdminPanel adminPanel, boolean isUpdate) {
        setTitle(isUpdate ? "Update Book" : "Add Book");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        bookNameField = new JTextField();
        authorField = new JTextField();
        isbnField = new JTextField();

        JButton submitButton = new JButton(isUpdate ? "Update" : "Add");
        submitButton.addActionListener(e -> {
            if (bookNameField.getText().isEmpty() || authorField.getText().isEmpty() || isbnField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are mandatory!");
            } else {
                String message = isUpdate ? "Book updated successfully!" : "Book added successfully!";
                JOptionPane.showMessageDialog(this, message);
                this.dispose();
            }
        });

        add(new JLabel("Book Name:"));
        add(bookNameField);
        add(new JLabel("Author:"));
        add(authorField);
        add(new JLabel("ISBN:"));
        add(isbnField);
        add(submitButton);
    }
}
