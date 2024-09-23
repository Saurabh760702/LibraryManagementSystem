import javax.swing.*;
import java.awt.*;

public class ReturnBookForm extends JFrame {
    private JTextField bookNameField;

    public ReturnBookForm(UserPanel userPanel) {
        setTitle("Return Book");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2));

        bookNameField = new JTextField();

        JButton returnButton = new JButton("Return Book");
        returnButton.addActionListener(e -> returnBook());

        add(new JLabel("Book Name:"));
        add(bookNameField);
        add(returnButton);
    }

    private void returnBook() {
        String bookName = bookNameField.getText();
        if (bookName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Book Name is required!");
        } else {
            // Process return
            JOptionPane.showMessageDialog(this, "Book returned successfully!");
        }
    }
}
