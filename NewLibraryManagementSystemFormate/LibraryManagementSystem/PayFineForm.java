import javax.swing.*;
import java.awt.*;

public class PayFineForm extends JFrame {
    private JTextField fineAmountField;
    private JCheckBox finePaidCheckbox;
    private JTextField remarksField;

    public PayFineForm(UserPanel userPanel) {
        setTitle("Pay Fine");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2));

        fineAmountField = new JTextField();
        fineAmountField.setEditable(false); // Simulate auto-filled value
        finePaidCheckbox = new JCheckBox("Fine Paid");
        remarksField = new JTextField();

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> confirmPayment());

        add(new JLabel("Fine Amount:"));
        add(fineAmountField);
        add(finePaidCheckbox);
        add(new JLabel("Remarks (optional):"));
        add(remarksField);
        add(confirmButton);
    }

    private void confirmPayment() {
        if (finePaidCheckbox.isSelected()) {
            // Logic for processing payment
            JOptionPane.showMessageDialog(this, "Fine payment confirmed!");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Please confirm that the fine is paid.");
        }
    }
}
