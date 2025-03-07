import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class SwingConcept {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee Details");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Employee Name:");
        JTextField nameField = new JTextField(20);
        JLabel idLabel = new JLabel("Employee ID:");
        JTextField idField = new JTextField(20);

        JButton submitButton = new JButton("Submit");
        JButton searchButton = new JButton("Search");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        HashMap<String, String> employeeData = new HashMap<>();

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String id = idField.getText();
            if (!id.isEmpty() && !name.isEmpty()) {
                employeeData.put(id, name);
                JOptionPane.showMessageDialog(frame, "Employee Added:\nName: " + name + "\nID: " + id);
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill all fields");
            }
        });

        searchButton.addActionListener(e -> {
            String id = idField.getText();
            if (employeeData.containsKey(id)) {
                JOptionPane.showMessageDialog(frame, "Employee Found:\nName: " + employeeData.get(id) + "\nID: " + id);
            } else {
                JOptionPane.showMessageDialog(frame, "Employee Not Found");
            }
        });

        updateButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            if (employeeData.containsKey(id)) {
                employeeData.put(id, name);
                JOptionPane.showMessageDialog(frame, "Employee Updated:\nName: " + name + "\nID: " + id);
            } else {
                JOptionPane.showMessageDialog(frame, "Employee Not Found");
            }
        });

        deleteButton.addActionListener(e -> {
            String id = idField.getText();
            if (employeeData.remove(id) != null) {
                JOptionPane.showMessageDialog(frame, "Employee Deleted: " + id);
            } else {
                JOptionPane.showMessageDialog(frame, "Employee Not Found");
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(idLabel);
        frame.add(idField);
        frame.add(submitButton);
        frame.add(searchButton);
        frame.add(updateButton);
        frame.add(deleteButton);

        frame.setVisible(true);
    }
}
