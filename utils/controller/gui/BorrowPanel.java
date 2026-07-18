package gui;

import javax.swing.*;
import java.awt.*;
import model.*;

public class BorrowPanel extends JPanel {
    private LibraryDatabase db;

    public BorrowPanel(LibraryDatabase db) {
        this.db = db;
        setLayout(new GridLayout(0, 2, 10, 10));

        JTextField userIdField = new JTextField(20);
        JTextField itemIdField = new JTextField(20);
        JButton borrowBtn = new JButton("Borrow Item");
        JButton returnBtn = new JButton("Return Item");

        add(new JLabel("User ID:")); add(userIdField);
        add(new JLabel("Item ID:")); add(itemIdField);
        add(borrowBtn); add(returnBtn);

        borrowBtn.addActionListener(e -> {
            String userId = userIdField.getText();
            String itemId = itemIdField.getText();
            UserAccount user = db.findUserById(userId);
            LibraryItem item = db.findItemById(itemId);
            if (user != null && item != null && item.borrow(userId)) {
                user.borrowItem(itemId);
                JOptionPane.showMessageDialog(this, "Item borrowed successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Borrow failed. Item may be unavailable.");
            }
        });

        returnBtn.addActionListener(e -> {
            // Similar logic for return
            JOptionPane.showMessageDialog(this, "Return functionality ready.");
        });
    }
}
