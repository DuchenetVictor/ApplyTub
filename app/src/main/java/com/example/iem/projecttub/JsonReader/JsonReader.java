package com.example.iem.projecttub.JsonReader;

import android.content.Context;
import android.util.Log;

import com.example.iem.projecttub.POJO.Arret;
import com.example.iem.projecttub.R;

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

    private static JsonReader mInstance;
    private InputStream inputStream;
    private StringBuffer stringBuffer;
    private boolean init=false;

    //singleton
    public static JsonReader getInstance() {
        if (mInstance == null) {
            mInstance = new JsonReader();
        }

        return mInstance;
    }

    
    //constructeur
     public JsonReader(){
     }

    private void initJson(Context context) {
        if(!init) {
            inputStream = context.getResources().openRawResource(R.raw.horaireligne);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sb = new StringBuffer();
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.stringBuffer = sb;
            init = true;
        }

    }

    public List<Arret> horaireLigne(int numLigne,String sensVoulu, Context context) {

        initJson(context);
        List<Arret> arrets = new ArrayList<>();
        try {
            // Parse the data into jsonobject to get original data in form of json.
            JSONObject jObject = new JSONObject(stringBuffer.toString());
            JSONObject root = jObject.getJSONObject("ressources");
            JSONArray ligne = root.getJSONArray("ligne");

            int id;
            for(int i = 0; i < ligne.length();i++){
                id = ligne.getJSONObject(i).getInt("-name");
                if(id == numLigne){
                    JSONArray trajet = ligne.getJSONObject(i).getJSONArray("trajet");

                    for (int j = 0; j < trajet.length();j++){
                        String sensTrajet = trajet.getJSONObject(j).getString("-name");

                        if(sensTrajet.equals(sensVoulu)){
                            JSONArray arretJson = trajet.getJSONObject(j).getJSONArray("arret");
                            for(int k = 0;  k < arretJson.length(); k ++){
                                String nomArret = arretJson.getJSONObject(k).getString("-name");
                                String[] horaires = arretJson.getJSONObject(k).getString("horaire").split(" ");

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
