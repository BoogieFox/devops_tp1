package com.example.devops_tp1.model;

public class Servant {
    private String name;
    private String sClass;
    private int rarity;

    public Servant(String name, String sClass, int rarity) {
        this.name = name;
        this.sClass = sClass;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }
}
