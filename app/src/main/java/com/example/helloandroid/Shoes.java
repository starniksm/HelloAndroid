package com.example.helloandroid;

import androidx.annotation.NonNull;

public class Shoes {
    private final String name;

    public Shoes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
