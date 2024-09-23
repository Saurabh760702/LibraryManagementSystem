import javax.swing.*;
import java.awt.*;

public class MembershipForm extends JFrame {
    private JTextField nameField;
    private JTextField membershipNumberField;
    private JRadioButton sixMonthsRadio;
    private JRadioButton oneYearRadio;
    private JRadioButton twoYearsRadio;

    public MembershipForm(UserPanel userPanel, boolean isUpdate) {
        setTitle(isUpdate ? "Update Membership" : "Add Membership");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        nameField = new JTextField();
        membershipNumberField = new JTextField();
        sixMonthsRadio = new JRadioButton("6 Months", true);
        oneYearRadio = new JRadioButton("1 Year");
        twoYearsRadio = new JRadioButton("2 Years");

        ButtonGroup membershipDurationGroup = new ButtonGroup();
        membershipDurationGroup.add(sixMonthsRadio);
        membershipDurationGroup.add(oneYearRadio);
        membershipDurationGroup.add(twoYearsRadio);

        JButton submitButton = new JButton(isUpdate ? "Update" : "Add");
        submitButton.addActionListener(e -> submitMembership(isUpdate));

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Membership Number (if updating):"));
        add(membershipNumberField);
        add(new JLabel("Select Duration:"));
        add(sixMonthsRadio);
        add(new JLabel(""));
        add(oneYearRadio);
        add(new JLabel(""));
        add(twoYearsRadio);
        add(submitButton);
    }

    private void submitMembership(boolean isUpdate) {
        String name = nameField.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name is required!");
            return;
        }

        String message = isUpdate ? "Membership updated successfully!" : "Membership added successfully!";
        JOptionPane.showMessageDialog(this, message);
        this.dispose();
    }
}
