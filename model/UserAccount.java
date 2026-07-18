package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserAccount implements Serializable {
    private String userId;
    private String name;
    private List<String> borrowedItems;

    public UserAccount(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public List<String> getBorrowedItems() { return borrowedItems; }

    public void borrowItem(String itemId) {
        borrowedItems.add(itemId);
    }

    public void returnItem(String itemId) {
        borrowedItems.remove(itemId);
    }
}
