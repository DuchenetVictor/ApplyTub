package com.example.iem.projecttub.JsonReader;


import android.provider.Telephony;
import android.util.Log;

import com.example.iem.projecttub.MainActivity;
import com.example.iem.projecttub.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by iem on 02/11/2016.
 */

public class JsonReader {




    public /*List<Integer>*/ void horaireLigne(int numLigne,String sens, InputStream inputstream ) {
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
            String direction = jObjectResult.getString("trajet");

            //

            JSONArray jArray = jObjectResult.getJSONArray("arret");

            HashMap<String,List<String>> arrets = new HashMap<>();

            for (int i =0; i> jArray.length();i++)
            {
                String nomArret = jArray.getJSONObject(i).getString("-name");
                String[] horaires = jArray.getJSONObject(i).getString("-name").split(" ");
                arrets.put(nomArret, Arrays.asList(horaires));
            }

            String test;



//            JSONArray jArray = jObjectResult.getJSONArray("Category");
//            String cat_Id = "";
//            String cat_name = "";
//            ArrayList<String[]> data = new ArrayList<String[]>();
//            for (int i = 0; i < jArray.length(); i++) {
//                cat_Id = jArray.getJSONObject(i).getString("cat_id");
//                cat_name = jArray.getJSONObject(i).getString("cat_name");
//                Log.v("Cat ID", cat_Id);
//                Log.v("Cat Name", cat_name);
//                data.add(new String[]{cat_Id, cat_name});
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
