package fr.tse.ihm;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final List<String> list = new ArrayList<>();
    private static DataManager instance;

    private DataManager() {
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
