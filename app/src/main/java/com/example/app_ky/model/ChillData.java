package com.example.app_ky.model;

public class ChillData {
    int Hinh;
    String name;

    public ChillData(int hinh, String name) {
        Hinh = hinh;
        this.name = name;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
