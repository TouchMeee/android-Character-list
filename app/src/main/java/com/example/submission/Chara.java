package com.example.submission;

import android.os.Parcel;
import android.os.Parcelable;

public class Chara implements Parcelable {
    private String name;
    private String detail;
    private int photo;
    private String chara_kelebihan;
    private String chara_kekurangan;
    private String role_speciality;
    private String chara_ulti;

    protected Chara(Parcel in) {
        name = in.readString();
        detail = in.readString();
        photo = in.readInt();
        chara_kelebihan = in.readString();
        chara_kekurangan = in.readString();
        role_speciality = in.readString();
        chara_ulti = in.readString();
    }

    public static final Creator<Chara> CREATOR = new Creator<Chara>() {
        @Override
        public Chara createFromParcel(Parcel in) {
            return new Chara(in);
        }

        @Override
        public Chara[] newArray(int size) {
            return new Chara[size];
        }
    };

    public Chara() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getChara_kelebihan() {
        return chara_kelebihan;
    }

    public void setChara_kelebihan(String chara_kelebihan) {
        this.chara_kelebihan = chara_kelebihan;
    }

    public String getChara_kekurangan() {
        return chara_kekurangan;
    }

    public void setChara_kekurangan(String chara_kekurangan) {
        this.chara_kekurangan = chara_kekurangan;
    }

    public String getRole() {
        return role_speciality;
    }

    public void setRole(String role) {
        this.role_speciality = role;
    }

    public String getChara_ulti() {
        return chara_ulti;
    }

    public void setChara_ulti(String chara_ulti) {
        this.chara_ulti = chara_ulti;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(detail);
        dest.writeInt(photo);
        dest.writeString(chara_kelebihan);
        dest.writeString(chara_kekurangan);
        dest.writeString(role_speciality);
        dest.writeString(chara_ulti);
    }
}

