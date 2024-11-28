package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Ordner> ordner;

    public User(String name) {
        this.name = name;
        this.ordner = new ArrayList<>();
    }

    public void addOrdner(Ordner ordner) {
        this.ordner.add(ordner);
    }

    public List<Ordner> getAllOrdner() {
        return ordner;
    }
}
