package gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import model.LibraryDatabase;
import controller.*;

public class SearchSortPanel extends JPanel {
    private LibraryDatabase db;
    private JTable resultTable;

    public SearchSortPanel(LibraryDatabase db) {
        this.db = db;
        setLayout(new BorderLayout());

        JTextField searchField = new JTextField(20);
        JComboBox<String> searchAlgo = new JComboBox<>(new String[]{"Linear", "Binary", "Recursive"});
        JComboBox<String> sortBy = new JComboBox<>(new String[]{"Title", "Author", "Year"});
        JButton searchBtn = new JButton("Search");
        JButton sortBtn = new JButton("Sort");

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Search:")); topPanel.add(searchField);
        topPanel.add(searchAlgo);
        topPanel.add(sortBy);
        topPanel.add(searchBtn);
        topPanel.add(sortBtn);

        add(topPanel, BorderLayout.NORTH);

        // Result table
        resultTable = new JTable();
        add(new JScrollPane(resultTable), BorderLayout.CENTER);

        searchBtn.addActionListener(e -> {
            // Use SearchEngine
            String keyword = searchField.getText();
            // Call appropriate search method
        });

        sortBtn.addActionListener(e -> {
            String criterion = (String) sortBy.getSelectedItem();
            List<model.LibraryItem> items = db.getItems();
            SortingAlgorithms.selectionSort(items, criterion);
            // Refresh table
        });
    }
}
