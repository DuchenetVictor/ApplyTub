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

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
            StringBuilder sb = new StringBuilder();

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
                    JSONArray trajet = ligne.getJSONArray(i);
                    for (int j = 0; j < trajet.length();i++){
                        String sensTrajet = trajet.getJSONObject(j).getString("-name");

                        Log.d("json","senstrajet "+ sensTrajet);

                        if(sensTrajet == sensVoulu){
                            JSONArray arretJson = ligne.getJSONArray(j);
                            for(int k = 0;  k < arretJson.length(); k ++){
                                String nomArret = arretJson.getJSONObject(k).getString("-name");
                                String[] horaires = arretJson.getJSONObject(k).getString("horaire").split(" ");

                                Log.d("json"," nomArret "+ nomArret);
                                Arret arret = new Arret(nomArret,Arrays.asList(horaires));
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
