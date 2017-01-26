package com.example.iem.projecttub.pojo;

import com.example.iem.projecttub.Controller.Database.MyDatabase;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;



//// TODO: 15/01/2017 https://guides.codepath.com/android/DBFlow-Guide
// TODO: 15/01/2017 faire schema sqlite

@Table(database = MyDatabase.class)
public class Stop extends BaseModel {

    @PrimaryKey
    @Column
    @SerializedName("ID")
    private int Id;
    @Column
    private String Name;
    @Column
    private String Longitude;
    @Column
    private String Latitude;


    public Stop() {
    }

    public Stop(int id, String name, String longitude, String latitude) {
        Id = id;
        Name = name;
        Longitude = longitude;
        Latitude = latitude;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }
}