package com.example.iem.projecttub.JsonReader;


import android.util.Log;

import com.example.iem.projecttub.POJO.Arret;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iem on 02/11/2016.
 */



public class JsonReader {


    public List<Arret> horaireLigne(int numLigne,String sensVoulu, InputStream inputstream ) {


        //TODO mettre en place un singleton
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
        StringBuffer sb=new StringBuffer();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Arret> arrets = new ArrayList<>();

        try {
            // Parse the data into jsonobject to get original data in form of json.
            JSONObject jObject = new JSONObject(sb.toString());
            JSONObject root = jObject.getJSONObject("ressources");
            JSONArray ligne = root.getJSONArray("ligne");

            int id;
            Log.d("json","init");
            for(int i = 0; i < ligne.length();i++){
                id = ligne.getJSONObject(i).getInt("-name");
                if(id == numLigne){
                    Log.d("json","id :"+id+"numLigne :"+numLigne);
                    JSONArray trajet = ligne.getJSONObject(i).getJSONArray("trajet");

                    for (int j = 0; j < trajet.length();i++){
                        String sensTrajet = trajet.getJSONObject(j).getString("-name");

                        if(sensTrajet.equals(sensVoulu)){
                            JSONArray arretJson = trajet.getJSONObject(i).getJSONArray("arret");
                            for(int k = 0;  k < arretJson.length(); k ++){
                                String nomArret = arretJson.getJSONObject(k).getString("-name");
                                String[] horaires = arretJson.getJSONObject(k).getString("horaire").split(" ");

                                Log.d("json"," nomArret "+ nomArret);
                                arrets.add(new Arret(nomArret,Arrays.asList(horaires)));
                            }
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
