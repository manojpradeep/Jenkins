import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        new EmployeeManagementSystem();
    }
}

class EmployeeManagementSystem {
    private JFrame frame;
    private JTextField idField, nameField, positionField;
    private JTextArea displayArea;
    private HashMap<String, Employee> employees;

    public EmployeeManagementSystem() {
        employees = new HashMap<>();
        frame = new JFrame("Employee Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        idField = new JTextField(10);
        nameField = new JTextField(10);
        positionField = new JTextField(10);
        displayArea = new JTextArea(5, 30);
        displayArea.setEditable(false);

        frame.add(new JLabel("ID:")); frame.add(idField);
        frame.add(new JLabel("Name:")); frame.add(nameField);
        frame.add(new JLabel("Position:")); frame.add(positionField);

        addButton("Add", e -> addEmployee());
        addButton("Search", e -> searchEmployee());
        addButton("Update", e -> updateEmployee());
        addButton("Delete", e -> deleteEmployee());

        frame.add(new JScrollPane(displayArea));
        frame.setVisible(true);
    }

    private void addButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        frame.add(button);
    }

    private void addEmployee() {
        String id = idField.getText(), name = nameField.getText(), position = positionField.getText();
        if (!id.isEmpty() && !name.isEmpty() && !position.isEmpty()) {
            employees.put(id, new Employee(id, name, position));
            displayArea.setText("Employee Added");
        } else {
            displayArea.setText("Please fill all fields");
        }
        clearFields();
    }
    
    private void searchEmployee() {
        Employee emp = employees.get(idField.getText());
        displayArea.setText(emp != null ? emp.toString() : "Employee Not Found");
    }

    private void updateEmployee() {
        String id = idField.getText(), name = nameField.getText(), position = positionField.getText();
        if (employees.containsKey(id)) {
            employees.put(id, new Employee(id, name, position));
            displayArea.setText("Employee Updated");
        } else {
            displayArea.setText("Employee Not Found");
        }
        clearFields();
    }

    private void deleteEmployee() {
        if (employees.remove(idField.getText()) != null) {
            displayArea.setText("Employee Deleted");
        } else {
            displayArea.setText("Employee Not Found");
        }
    }

    private void clearFields() {
        idField.setText(""); nameField.setText(""); positionField.setText("");
    }
}

class Employee {
    String id, name, position;
    Employee(String id, String name, String position) { this.id = id; this.name = name; this.position = position; }
    public String toString() { return "ID: " + id + "\nName: " + name + "\nPosition: " + position; }
}
