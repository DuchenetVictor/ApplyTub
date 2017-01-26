package com.example.iem.projecttub.pojo;

import com.example.iem.projecttub.Controller.Database.MyDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by David_tepoche on 16/01/2017.
 */
@Table(database = MyDatabase.class)
public class Passage extends BaseModel {
    @PrimaryKey
    @Column
    private int Id;
    @Column
    private int IdPassageBefore;
    @Column
    private int IdPassageAfter;
    @Column
    private int Id_Line;
    @Column
    private int Id_Stop;
    @Column
    private String TimePassage;


    public Passage() {
    }

    public Passage(int id, int idPassageBefore, int idPassageAfter, int id_Line, int id_Stop) {
        Id = id;
        IdPassageBefore = idPassageBefore;
        IdPassageAfter = idPassageAfter;
        Id_Line = id_Line;
        Id_Stop = id_Stop;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdPassageBefore() {
        return IdPassageBefore;
    }

    public void setIdPassageBefore(int idPassageBefore) {
        IdPassageBefore = idPassageBefore;
    }

    public int getIdPassageAfter() {
        return IdPassageAfter;
    }

    public void setIdPassageAfter(int idPassageAfter) {
        IdPassageAfter = idPassageAfter;
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

    public String getTimePassage() {
        return TimePassage;
    }

    public void setTimePassage(String timePassage) {
        TimePassage = timePassage;
    }
}
