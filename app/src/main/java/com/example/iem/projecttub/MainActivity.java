package com.example.iem.projecttub;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {
    Spinner spinnerHoraireLigne;
    Spinner spinnerVisuLigne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerHoraireLigne = (Spinner) findViewById(R.id.sprHoraireLigne);
        spinnerVisuLigne = (Spinner) findViewById(R.id.sprVisualisationLigne);


// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Lignes_array, android.R.layout.simple_spinner_item);

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner

        spinnerHoraireLigne.setAdapter(adapter);
        spinnerVisuLigne.setAdapter(adapter);


        spinnerVisuLigne.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String item = parentView.getItemAtPosition(position).toString();
                Toast.makeText(parentView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spinnerHoraireLigne.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String item = parentView.getItemAtPosition(position).toString();
                Toast.makeText(parentView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
//        Intent myIntent = new Intent(getApplicationContext(), MapsActivity.class);
//        myIntent.putExtra("keyA", messageA);
//        startActivity(myIntent);


    }


}

