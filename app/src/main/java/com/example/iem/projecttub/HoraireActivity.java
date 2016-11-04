package com.example.iem.projecttub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.example.iem.projecttub.JsonReader.JsonReader;
import com.example.iem.projecttub.POJO.Arret;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HoraireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horaire);
        TableLayout tablelayout = (TableLayout) findViewById(R.id.idTable);

        String ParamFromMain = getIntent().getStringExtra("FromMain");

        InputStream inputStream = getResources().openRawResource(R.raw.horaireligne);

        JsonReader js = new JsonReader();
        try{
            List<Arret> horaireArret = new ArrayList<>(js.horaireLigne(1, "MN", inputStream));


            //construction du tableau
            TableRow row;

            for(Arret arret : horaireArret){
                row = new TableRow(this);

            }

        }catch (NullPointerException e){
            Toast.makeText(this,"une erreur c'est produit dans la lecture du js "
                    +e.getMessage(),Toast.LENGTH_LONG);
            }



    }
}
