package com.firyalf.sub1made;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String judul;
    private String waktu;
    private String desc;
    private int gambar;

    public Movie() {

    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public static Creator<Movie> getCREATOR() {
        return CREATOR;
    }

    //
//    public String getJudul() {
//        this.judul = judul;
//    }
//
//    public String getWaktu() {
//        this.waktu = waktu;
//    }
//
//    public String getDesc() {
//        this.desc = desc;
//    }
//
//    public String getGambar() {
//        this.gambar = gambar;
//    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString( this.judul );
        dest.writeString( this.waktu );
        dest.writeString( this.desc );
        dest.writeInt( this.gambar );
    }

    protected Movie(Parcel in) {
        this.judul = in.readString();
        this.waktu = in.readString();
        this.desc = in.readString();
        this.gambar = in.readInt();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie( source );
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
