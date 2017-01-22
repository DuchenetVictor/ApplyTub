package com.example.iem.projecttub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.iem.projecttub.Controller.CRUDDatabase;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

public class MainActivity extends Activity {
    Spinner spinnerHoraireLigne;
    Spinner spinnerVisuLigne;
    int check = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlowManager.init(new FlowConfig.Builder(this).build());

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Lignes_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

/*todo recupere les données en lazy ??
recuperer les lignes une a une lors du clique sur le spinner ?
faire le traitement en base (WS)
recupere seulement dans la sqlite les lignes/ les horaires: 
tout ce qui est des recherche de voyage c'est en webservice....( evite les traitement lourd et de trop emcombrer les sqlitebdd)

*/

        spinnerVisuLigne = (Spinner) findViewById(R.id.sprVisualisationLigne);
        spinnerVisuLigne.setAdapter(adapter);
        spinnerVisuLigne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //evite de prendre en compte le clic lors du lancement de l'activité
                check = check + 1;
                if (check > 2)
                {
                    String item = parentView.getItemAtPosition(position).toString();
                    Intent myIntent = new Intent(getApplicationContext(), MapsActivity.class);
                    myIntent.putExtra("FromMain", item);
                    startActivity(myIntent);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        spinnerHoraireLigne = (Spinner) findViewById(R.id.sprHoraireLigne);
        spinnerHoraireLigne.setAdapter(adapter);
        spinnerHoraireLigne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //evite de prendre en compte le clic lors du lancement de l'activité
                check = check +1;
                if(check > 2)
                {
                    String item = parentView.getItemAtPosition(position).toString();
                    Intent myIntent = new Intent(getApplicationContext(),HoraireActivity.class);
                    myIntent.putExtra("FromMain", item);
                    startActivity(myIntent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}

