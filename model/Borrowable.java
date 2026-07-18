package model;

public interface Borrowable {
    boolean borrow(String userId);
    boolean returnItem();
    boolean isOverdue();
}
