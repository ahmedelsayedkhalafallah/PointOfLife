package com.example.ahmed.pointoflife;

import android.os.Parcel;
import android.os.Parcelable;

public class Admin  implements Parcelable{
    private String name,password;

    public Admin(String name,String password){
        this.name = name;
        this.password = password;
    }
    Admin(){

    }

    protected Admin(Parcel in) {
        name = in.readString();
        password = in.readString();
    }

    public static final Creator<Admin> CREATOR = new Creator<Admin>() {
        @Override
        public Admin createFromParcel(Parcel in) {
            return new Admin(in);
        }

        @Override
        public Admin[] newArray(int size) {
            return new Admin[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(password);
    }
}
