package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class LibraryDatabase implements Serializable {
    private List<LibraryItem> items;
    private List<UserAccount> users;
    private Map<String, Queue<String>> reservations;

    public LibraryDatabase() {
        items = new ArrayList<>();
        users = new ArrayList<>();
        reservations = new HashMap<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addUser(UserAccount user) {
        users.add(user);
    }

    public List<LibraryItem> getItems() { return items; }
    public List<UserAccount> getUsers() { return users; }

    public LibraryItem findItemById(String id) {
        for (LibraryItem item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public UserAccount findUserById(String userId) {
        for (UserAccount user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public void addReservation(String itemId, String userId) {
        reservations.computeIfAbsent(itemId, k -> new LinkedList<>()).add(userId);
    }

    public Queue<String> getReservations(String itemId) {
        return reservations.getOrDefault(itemId, new LinkedList<>());
    }
}
