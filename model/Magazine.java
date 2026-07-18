package model;

public class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String id, String title, String author, int year, int issueNumber) {
        super(id, title, author, year);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() { return issueNumber; }

    @Override
    public String getType() {
        return "Magazine";
    }
}
