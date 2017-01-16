
package com.example.iem.projecttub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iem.projecttub.JsonReader.JsonReader;

import java.io.InputStream;
import java.util.ArrayList;


public class HoraireActivity extends AppCompatActivity {
/*
    InputStream inputStream;
    TextView sensArret;
    Button inverser ;
    TableLayout tablelayout;
    String allerRetour= "aller";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horaire);

        final List<Arret> horairesArrets = new ArrayList<>();
        tablelayout = (TableLayout) findViewById(R.id.idTable);

        final JsonReader js = JsonReader.getInstance();


        String paramFromMain = getIntent().getStringExtra("FromMain");
        String idString = paramFromMain.replace("ligne ", "");
        final int id = Integer.parseInt(idString);

        try {

            horairesArrets.addAll(js.horaireLigne(id,allerRetour,getApplicationContext()));

            //affiche le sens de la ligne
            sensArret = (TextView) findViewById(R.id.txvSensLigne);
            sensArret.setText(horairesArrets.get(0).getNom() + " -> " + horairesArrets.get(horairesArrets.size() - 1).getNom());

            //construction du tableau
            CreationTable(horairesArrets);


        } catch (NullPointerException e) {
            Toast.makeText(this, "une erreur c'est produit dans la lecture du js "
                    + e.getMessage(), Toast.LENGTH_LONG);
        }

        inverser = (Button) findViewById(R.id.btnSensInverse);
        inverser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (allerRetour.equals("aller")){
                    allerRetour = "retour";
                    horairesArrets.clear();
                    horairesArrets.addAll(js.horaireLigne(id,allerRetour,getApplicationContext()));

                    CreationTable(horairesArrets);
                    sensArret.setText(horairesArrets.get(0).getNom() + " -> " + horairesArrets.get(horairesArrets.size() - 1).getNom());
                }else
                {
                    allerRetour = "aller";
                    horairesArrets.clear();
                    horairesArrets.addAll(js.horaireLigne(id,allerRetour,getApplicationContext()));

                    CreationTable(horairesArrets);

                    sensArret.setText(horairesArrets.get(0).getNom() + " -> " + horairesArrets.get(horairesArrets.size() - 1).getNom());
                }
            }});
    }

    public void CreationTable(List<Arret> horairesArrets){
        TableRow row = null;
        TextView tv1 = null;
        tablelayout.removeAllViewsInLayout();
        tablelayout.removeAllViews();

        for (Arret arret : horairesArrets) {
            Log.d("arret", arret.getNom());
            row = new TableRow(this);
            tv1 = new TextView(this);
            // création cellule
            tv1.setText(arret.getNom());
            // creation cellule avec tous les horaires
            for (String horaire : arret.getHoraires()) {
                new TextView(this);
                tv1.setText(tv1.getText() + " " + horaire);
            }
            row.addView(tv1);
            tablelayout.addView(row);
        }
    }*/
}

