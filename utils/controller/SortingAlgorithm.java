package controller;

import model.LibraryItem;
import java.util.List;

public class SortingAlgorithms {
    public static void selectionSort(List<LibraryItem> items, String criterion) {
        int n = items.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (compare(items.get(j), items.get(minIdx), criterion) < 0) {
                    minIdx = j;
                }
            }
            LibraryItem temp = items.get(minIdx);
            items.set(minIdx, items.get(i));
            items.set(i, temp);
        }
    }

    public static void insertionSort(List<LibraryItem> items, String criterion) {
        for (int i = 1; i < items.size(); i++) {
            LibraryItem key = items.get(i);
            int j = i - 1;
            while (j >= 0 && compare(key, items.get(j), criterion) < 0) {
                items.set(j + 1, items.get(j));
                j--;
            }
            items.set(j + 1, key);
        }
    }

    private static int compare(LibraryItem a, LibraryItem b, String criterion) {
        switch (criterion.toLowerCase()) {
            case "title": return a.getTitle().compareToIgnoreCase(b.getTitle());
            case "author": return a.getAuthor().compareToIgnoreCase(b.getAuthor());
            case "year": return Integer.compare(a.getYear(), b.getYear());
            default: return 0;
        }
    }
}
