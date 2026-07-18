package gui;

import javax.swing.*;
import java.awt.*;
import model.LibraryDatabase;

public class ViewItemsPanel extends JPanel {
    public ViewItemsPanel(LibraryDatabase db) {
        setLayout(new BorderLayout());
        JTextArea area = new JTextArea();
        area.setEditable(false);
        for (model.LibraryItem item : db.getItems()) {
            area.append(item.toString() + "\n");
        }
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(new JLabel("Library Catalogue", SwingConstants.CENTER), BorderLayout.NORTH);
    }
}
