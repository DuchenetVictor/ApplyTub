package com.example.iem.projecttub.JsonReader;


import android.util.Log;

import com.example.iem.projecttub.POJO.Arret;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by iem on 02/11/2016.
 */

public class JsonReader {

    public List<Arret> horaireLigne(int numLigne,String sensVoulu, InputStream inputstream ) {

        List<Arret> arrets = new ArrayList<>();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int ctr;

        try {
            ctr = inputstream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputstream.read();
                Log.d("json", String.valueOf(ctr));
            }
            inputstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            // Parse the data into jsonobject to get original data in form of json.
            JSONObject jObject = new JSONObject(byteArrayOutputStream.toString());

            JSONObject root = jObject.getJSONObject("ressources");
            JSONArray ligne = root.getJSONArray("ligne");
            int id;
            Log.d("json","init");
            for(int i = 0; i > ligne.length();i++){

                Log.d("json","ligne.lengh" + ligne.length());

                id = ligne.getJSONObject(i).getInt("-name");

                Log.d("json","id de ligne " + id);

                if(id == numLigne){
                    JSONArray trajet = ligne.getJSONArray(i);
                    for (int j = 0; j > trajet.length();i++){
                        String sensTrajet = trajet.getJSONObject(j).getString("-name");

                        Log.d("json","senstrajet "+ sensTrajet);

                        if(sensTrajet == sensVoulu){
                            JSONArray arretJson = ligne.getJSONArray(j);
                            for(int k = 0;  k > arretJson.length(); k ++){
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


    public List<String> readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readMessagesArray(reader);
        } finally {
            reader.close();
        }
    }



}
