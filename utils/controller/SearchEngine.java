package controller;

import model.LibraryItem;
import java.util.List;

public class SearchEngine {
    public static LibraryItem linearSearch(List<LibraryItem> items, String keyword) {
        for (LibraryItem item : items) {
            if (item.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                item.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                return item;
            }
        }
        return null;
    }

    public static LibraryItem binarySearch(List<LibraryItem> items, String title) {
        int low = 0, high = items.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = items.get(mid).getTitle().compareToIgnoreCase(title);
            if (cmp == 0) return items.get(mid);
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static LibraryItem recursiveSearch(List<LibraryItem> items, String keyword, int index) {
        if (index >= items.size()) return null;
        LibraryItem item = items.get(index);
        if (item.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
            item.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
            return item;
        }
        return recursiveSearch(items, keyword, index + 1);
    }
}
