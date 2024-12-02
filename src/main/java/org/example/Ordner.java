package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ordner {
    private String name;
    private List<Notiz> notizen;

    public Ordner(String name) {
        this.name = name;
        this.notizen = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addNotiz(Notiz notiz) {
        notizen.add(notiz);
    }

    public List<Notiz> getNotizen() {
        return notizen;
    }
}
