package com.example.iem.projecttub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.InputStream;
//import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {
    Spinner spinnerHoraireLigne;
    Spinner spinnerVisuLigne;
    int check = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerHoraireLigne = (Spinner) findViewById(R.id.sprHoraireLigne);
        spinnerVisuLigne = (Spinner) findViewById(R.id.sprVisualisationLigne);
        final InputStream inputStream = getResources().openRawResource(R.raw.horaireligne);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Lignes_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinnerHoraireLigne.setAdapter(adapter);
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


        spinnerHoraireLigne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //evite de prendre en compte le clic lors du lancement de l'activité
                check = check +1;
                if(check >2)
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

