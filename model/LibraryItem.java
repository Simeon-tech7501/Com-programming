package model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class LibraryItem implements Serializable, Borrowable {
    protected String id;
    protected String title;
    protected String author;
    protected int year;
    protected boolean isBorrowed;
    protected LocalDate dueDate;

    public LibraryItem(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isBorrowed = false;
        this.dueDate = null;
    }

    public abstract String getType();

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public boolean isBorrowed() { return isBorrowed; }
    public LocalDate getDueDate() { return dueDate; }

    public void setBorrowed(boolean borrowed, LocalDate dueDate) {
        this.isBorrowed = borrowed;
        this.dueDate = dueDate;
    }

    @Override
    public boolean borrow(String userId) {
        if (!isBorrowed) {
            isBorrowed = true;
            dueDate = LocalDate.now().plusDays(14);
            return true;
        }
        return false;
    }

    @Override
    public boolean returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            dueDate = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean isOverdue() {
        return isBorrowed && dueDate != null && LocalDate.now().isAfter(dueDate);
    }

    @Override
    public String toString() {
        return getType() + " - " + title + " by " + author + " (" + year + ")";
    }
}
