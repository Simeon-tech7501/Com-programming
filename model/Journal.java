package model;

public class Journal extends LibraryItem {
    private String volume;

    public Journal(String id, String title, String author, int year, String volume) {
        super(id, title, author, year);
        this.volume = volume;
    }

    public String getVolume() { return volume; }

    @Override
    public String getType() {
        return "Journal";
    }
}
