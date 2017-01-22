package com.example.iem.projecttub.Controller;

/**
 * Created by David_tepoche on 21/01/2017.
 */
import com.example.iem.projecttub.pojo.Line;
import com.example.iem.projecttub.pojo.Passage;
import com.example.iem.projecttub.pojo.Stop;
import com.example.iem.projecttub.pojo.StopsLine;


public class CRUDDatabase {


    public static void insertLine(Line line){
        line.save();
    }

    public static void deleteLine(Line line){
        line.delete();
    }

    public static void insertPassage(Passage passage){
        passage.save();
    }
    public static void insertStop(Stop stop){
        stop.save();
    }
    public static void insertStopsLine(StopsLine stopsLine){
        stopsLine.save();
    }


}
