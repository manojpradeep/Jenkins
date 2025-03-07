import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class EmployeeManagementSystem {
    private JFrame frame;
    private JTextField idField, nameField;
    private JTextArea displayArea;
    private HashMap<String, Employee> employees;

    public EmployeeManagementSystem() {
        employees = new HashMap<>();
        frame = new JFrame("Employee Management System");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        idField = new JTextField(10);
        nameField = new JTextField(10);
        displayArea = new JTextArea(5, 20);
        displayArea.setEditable(false);

        frame.add(new JLabel("ID:"));
        frame.add(idField);
        frame.add(new JLabel("Name:"));
        frame.add(nameField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addEmployee());
        frame.add(addButton);
        frame.add(new JScrollPane(displayArea));
        frame.setVisible(true);
    }

    private void addEmployee() {
        String id = idField.getText();
        String name = nameField.getText();
        employees.put(id, new Employee(id, name));
        displayArea.setText("Employee Added");
    }

    class Employee {
        String id, name;

        Employee(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        new EmployeeManagementSystem();
    }
}
