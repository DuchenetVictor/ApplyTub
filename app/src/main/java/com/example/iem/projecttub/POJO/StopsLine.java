package com.example.iem.projecttub.pojo;

import com.example.iem.projecttub.Controller.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by David_tepoche on 16/01/2017.
 */

@Table(database = MyDatabase.class)
public class StopsLine extends BaseModel{

    @PrimaryKey
    @Column
    private int Id_Line;
    @PrimaryKey
    @Column
    private int Id_Stop;

    public StopsLine() {
    }

    public StopsLine(int id_Line, int id_Stop) {
        Id_Line = id_Line;
        Id_Stop = id_Stop;
    }

    public int getId_Line() {
        return Id_Line;
    }

    public void setId_Line(int id_Line) {
        Id_Line = id_Line;
    }

    public int getId_Stop() {
        return Id_Stop;
    }

    public void setId_Stop(int id_Stop) {
        Id_Stop = id_Stop;
    }
}
