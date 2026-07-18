package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
import controller.*;
import utils.*;

public class MainWindow extends JFrame {
    private LibraryDatabase db;
    private JTabbedPane tabbedPane;

    public MainWindow() {
        db = FileHandler.loadDatabase("library.ser");
        setTitle("Smart Library Circulation & Automation System (SLCAS)");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("View Items", new ViewItemsPanel(db));
        tabbedPane.addTab("Borrow/Return", new BorrowPanel(db));
        tabbedPane.addTab("Admin", new AdminPanel(db));
        tabbedPane.addTab("Search & Sort", new SearchSortPanel(db));

        add(tabbedPane);

        // Overdue timer
        Timer timer = new Timer(60000, e -> checkOverdues());
        timer.start();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                FileHandler.saveDatabase(db, "library.ser");
            }
        });
    }

    private void checkOverdues() {
        // Implementation as before
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainWindow().setVisible(true));
    }
}
