package model;

public class Book extends LibraryItem {
    private String isbn;

    public Book(String id, String title, String author, int year, String isbn) {
        super(id, title, author, year);
        this.isbn = isbn;
    }

    public String getIsbn() { return isbn; }

    @Override
    public String getType() {
        return "Book";
    }
}
