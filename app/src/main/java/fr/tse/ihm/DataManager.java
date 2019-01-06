package fr.tse.ihm;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager instance;
    private final List<String> list;

    private DataManager() {
        list = new ArrayList<>();
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    void addString(String string) {
        list.add(string);
    }

    List<String> getStringList() {
        return list;
    }
}
