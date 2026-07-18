package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
import utils.*;

public class AdminPanel extends JPanel {
    private LibraryDatabase db;
    private Stack<LibraryItem> undoStack = new Stack<>();

    public AdminPanel(LibraryDatabase db) {
        this.db = db;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JTextField titleField = new JTextField(20);
        JTextField authorField = new JTextField(20);
        JTextField yearField = new JTextField(20);
        JComboBox<String> typeCombo = new JComboBox<>(new String[]{"Book", "Magazine", "Journal"});

        JButton addBtn = new JButton("Add New Item");
        JButton deleteBtn = new JButton("Delete Last Item");
        JButton undoBtn = new JButton("Undo Last Action");

        // Layout components...
        gbc.gridx = 0; gbc.gridy = 0; add(new JLabel("Type:"), gbc);
        gbc.gridx = 1; add(typeCombo, gbc);

        gbc.gridx = 0; gbc.gridy = 1; add(new JLabel("Title:"), gbc);
        gbc.gridx = 1; add(titleField, gbc);

        // Add more fields...

        addBtn.addActionListener(e -> {
            String type = (String) typeCombo.getSelectedItem();
            String title = titleField.getText();
            // Create item based on type using IDGenerator
            LibraryItem newItem = null;
            String id = IDGenerator.generateId("LIB");
            if ("Book".equals(type)) {
                newItem = new Book(id, title, "Author", 2023, "ISBN123");
            } // similar for others
            if (newItem != null) {
                db.addItem(newItem);
                undoStack.push(newItem);
                JOptionPane.showMessageDialog(this, "Item added!");
            }
        });

        undoBtn.addActionListener(e -> {
            if (!undoStack.isEmpty()) {
                LibraryItem last = undoStack.pop();
                db.getItems().remove(last);
                JOptionPane.showMessageDialog(this, "Action undone.");
            }
        });
    }
}
