package com.example.app_ky.model;

import android.net.Uri;

public class MVData {
//    Uri clipUrl;
//
//    public MVData(Uri clipUrl) {
//        this.clipUrl = clipUrl;
//    }
//
//    public Uri getClipUrl() {
//        return clipUrl;
//    }
//
//    public void setClipUrl(Uri clipUrl) {
//        this.clipUrl = clipUrl;
//    }

    int Hinh;
    String name;
    String content;

    public MVData(int hinh, String name, String content) {
        Hinh = hinh;
        this.name = name;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
