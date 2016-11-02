package com.example.iem.projecttub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.iem.projecttub.JsonReader.JsonReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class HoraireActivity extends AppCompatActivity {

    private static StringBuilder  _JsonStocke = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horaire);

        String ParamFromMain = getIntent().getStringExtra("FromMain");
        InputStream inputStream = getResources().openRawResource(R.raw.horaireligne);
        JsonReader js = new JsonReader();
        js.horaireLigne(1,"MN",inputStream);




    }

//    public StringBuilder getRawRessource()
//    {
//        StringBuilder sbuilder = new StringBuilder();
//        try
//        {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(R.raw.horaireligne), Charset.forName("utf-8")));
//
//            for(String line = reader.readLine(); line != null; line = reader.readLine()) {
//                sbuilder.append(line);
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        return sbuilder;
//    }
}
