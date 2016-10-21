package com.example.iem.projecttub;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
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


//        Intent myIntent = new Intent(getApplicationContext(), MapsActivity.class);
//        myIntent.putExtra("keyA", messageA);
//        startActivity(myIntent);
    }


//    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
//
//
//        public void onItemSelected(AdapterView<?> parent, View view,
//                                   int pos, long id) {
//            // An item was selected. You can retrieve the selected item using
//            // parent.getItemAtPosition(pos)
//        }
//
//        public void onNothingSelected(AdapterView<?> parent) {
//            // Another interface callback
//        }
//    }
}
