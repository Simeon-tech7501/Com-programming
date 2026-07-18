package utils;

import model.LibraryDatabase;
import java.io.*;

public class FileHandler {
    public static void saveDatabase(LibraryDatabase db, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(db);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LibraryDatabase loadDatabase(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (LibraryDatabase) ois.readObject();
        } catch (Exception e) {
            return new LibraryDatabase();
        }
    }
}
