package com.example.iem.projecttub.pojo;

import com.example.iem.projecttub.Controller.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.ArrayList;

/**
 * Created by David_tepoche on 16/01/2017.
 */
@Table(database = MyDatabase.class)
public class Line extends BaseModel{

    @PrimaryKey
    @Column
    private int Id;
    @Column
    private String Name;
    @Column
    private String Sens;
    @Column
    private ArrayList<Stop> Stops;


    public Line() {
    }

    public Line(int id, String name, String sens, ArrayList<Stop> stops) {
        Id = id;
        Name = name;
        Sens = sens;
        Stops = stops;
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

    public String getSens() {
        return Sens;
    }

    public void setSens(String sens) {
        Sens = sens;
    }

    public ArrayList<Stop> getStops() {
        return Stops;
    }

    public void setStops(ArrayList<Stop> stops) {
        Stops = stops;
    }
}
