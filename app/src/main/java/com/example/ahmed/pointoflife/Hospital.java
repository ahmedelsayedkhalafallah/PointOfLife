package com.example.ahmed.pointoflife;

import android.os.Parcel;
import android.os.Parcelable;

public class Hospital implements Parcelable {
    private String name,id;
    Long bags,password;
    public Hospital(Long bags,String id,String name,Long password)
    {
        this.bags = bags;
        this.id = id;
        this.name = name;
        this.password = password;
    }
    Hospital(){

    }

    protected Hospital(Parcel in) {
        name = in.readString();
        id = in.readString();
        if (in.readByte() == 0) {
            bags = null;
        } else {
            bags = in.readLong();
        }
        if (in.readByte() == 0) {
            password = null;
        } else {
            password = in.readLong();
        }
    }

    public static final Creator<Hospital> CREATOR = new Creator<Hospital>() {
        @Override
        public Hospital createFromParcel(Parcel in) {
            return new Hospital(in);
        }

        @Override
        public Hospital[] newArray(int size) {
            return new Hospital[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getBags() {
        return bags;
    }

    public void setBags(Long bags) {
        this.bags = bags;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(id);
        if (bags == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(bags);
        }
        if (password == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(password);
        }
    }
}
