package com.example.app_ky.model;

import android.net.Uri;

public class MvMainData {
    Uri clipUrl;
    int Hinh;
    String song;
    String single;

    public MvMainData(Uri clipUrl, int hinh, String song, String single) {
        this.clipUrl = clipUrl;
        Hinh = hinh;
        this.song = song;
        this.single = single;
    }

    public Uri getClipUrl() {
        return clipUrl;
    }

    public void setClipUrl(Uri clipUrl) {
        this.clipUrl = clipUrl;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }
}
