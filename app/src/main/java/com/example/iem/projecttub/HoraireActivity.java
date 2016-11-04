package com.example.iem.projecttub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iem.projecttub.JsonReader.JsonReader;
import com.example.iem.projecttub.POJO.Arret;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class    HoraireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horaire);
        TableLayout tablelayout = (TableLayout) findViewById(R.id.idTable);

        String ParamFromMain = getIntent().getStringExtra("FromMain");

        InputStream inputStream = getResources().openRawResource(R.raw.horaireligne);

        JsonReader js = new JsonReader();
        try{
            List<Arret> horaireArret = new ArrayList<>();
            horaireArret.addAll(js.horaireLigne(1, "MN", inputStream));

//todo finir.
            //construction du tableau
            TableRow row;
            TextView tv1;

            for(Arret arret : horaireArret){
                Log.d("arret",arret.getNom());
                row = new TableRow(this);
                tv1 = new TextView(this); // création cellule
                tv1.setText(arret.getNom());
                row.addView(tv1);
                tablelayout.addView(row);
            }

        }catch (NullPointerException e){
            Toast.makeText(this,"une erreur c'est produit dans la lecture du js "
                    +e.getMessage(),Toast.LENGTH_LONG);
            }
    }
}
