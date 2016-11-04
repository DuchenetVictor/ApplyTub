package com.example.iem.projecttub.JsonReader;


import android.util.Log;

import com.example.iem.projecttub.POJO.Arret;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by iem on 02/11/2016.
 */

public class JsonReader {

    public List<Arret> horaireLigne(int numLigne,String sens, InputStream inputstream ) {
        List<Arret> arrets = new ArrayList<>();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int ctr;
        try {
            ctr = inputstream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputstream.read();
            }
            inputstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            // Parse the data into jsonobject to get original data in form of json.
            JSONObject jObject = new JSONObject(byteArrayOutputStream.toString());

            JSONObject jObjectResult = jObject.getJSONObject("ligne");
            int ligne = jObjectResult.getInt("-name");

            //cherche le bon numero de ligne
            if(ligne == numLigne ){
                JSONArray jArrayTrajet = jObjectResult.getJSONArray("trajet");

                String nomTrajet, nomArret;
                String[] horaires;

                //recupere le nombre de trajet different ( aller / retour )
                for (int i =0; i<jArrayTrajet.length();i++ ){
                    nomTrajet = jArrayTrajet.getJSONObject(i).getString("-name");

                    //todo ne rentre pas dans le if
                    //on recupere seulement le sens du trajet voulu
                    if (nomTrajet == sens){
                        JSONArray  jArrayArret = jArrayTrajet.getJSONObject(i).getJSONArray("arret");

                        for (int j = 0; j < jArrayArret.length();j++)
                        {
                            nomArret = jArrayArret.getJSONObject(j).getString("-name");

                            horaires = jArrayArret.getJSONObject(j).getString("horaire").split(" ");
                            Arret arret = new Arret(nomArret,Arrays.asList(horaires));

                            arrets.add(arret);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrets;
    }
}
