package com.example.iem.projecttub;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity implements OnItemSelectedListener {
    Spinner spinnerHoraireLigne;
    Spinner spinnerVisuLigne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerHoraireLigne = (Spinner) findViewById(R.id.sprHoraireLigne);
        spinnerVisuLigne = (Spinner) findViewById(R.id.sprVisualisationLigne);

//        spinnerHoraireLigne.setOnClickListener(this);

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
}


//   @Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    // On selecting a spinner item
    String item = parent.getItemAtPosition(position).toString();

    // Showing selected spinner item
    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
}
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}

