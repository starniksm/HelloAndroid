package com.example.helloandroid;

public class Clothes {
    private final String name;

    public Clothes(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
