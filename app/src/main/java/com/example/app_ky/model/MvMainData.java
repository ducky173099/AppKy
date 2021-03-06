package com.example.app_ky.model;

import android.net.Uri;

public class MvMainData {
    int AvaSong;
    Uri clipUrl;
    int Hinh;
    String song;
    String single;
    private int status;

    public MvMainData(int avaSong, Uri clipUrl, int hinh, String song, String single, int status) {
        AvaSong = avaSong;
        this.clipUrl = clipUrl;
        Hinh = hinh;
        this.song = song;
        this.single = single;
        this.status = status;
    }

    public int getAvaSong() {
        return AvaSong;
    }

    public void setAvaSong(int avaSong) {
        AvaSong = avaSong;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
