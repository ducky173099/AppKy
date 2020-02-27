package com.example.app_ky.model;

import android.net.Uri;

import java.io.Serializable;

public class MusicData implements Serializable{
    int Hinh;
    String NameMusic;
    String NameSingle;
    int urlMp3;
    String lyric;

    public MusicData(int hinh, String nameMusic, String nameSingle, int urlMp3, String lyric) {
        Hinh = hinh;
        NameMusic = nameMusic;
        NameSingle = nameSingle;
        this.urlMp3 = urlMp3;
        this.lyric = lyric;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getNameMusic() {
        return NameMusic;
    }

    public void setNameMusic(String nameMusic) {
        NameMusic = nameMusic;
    }

    public String getNameSingle() {
        return NameSingle;
    }

    public void setNameSingle(String nameSingle) {
        NameSingle = nameSingle;
    }

    public int getUrlMp3() {
        return urlMp3;
    }

    public void setUrlMp3(int urlMp3) {
        this.urlMp3 = urlMp3;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }
}
