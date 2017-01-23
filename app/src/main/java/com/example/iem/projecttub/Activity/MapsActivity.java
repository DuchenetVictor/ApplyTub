package com.example.iem.projecttub.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.iem.projecttub.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap map) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(46.200000, 5.216667), 14.0f));

        String paramFromMain = getIntent().getStringExtra("FromMain");
        try {
            switch(paramFromMain){
                case "ligne 1" :
                    KmlLayer layerligne1 = new KmlLayer(map, R.raw.ligne_1, getApplicationContext());
                    layerligne1.addLayerToMap();
                    break;
                case "ligne 2" :
                    KmlLayer layerligne2 = new KmlLayer(map, R.raw.ligne_2, getApplicationContext());
                    layerligne2.addLayerToMap();
                    break;
                case "ligne 3" :
                    KmlLayer layerligne3 = new KmlLayer(map, R.raw.ligne_3, getApplicationContext());
                    layerligne3.addLayerToMap();
                    break;
                case "ligne 21" :
                    KmlLayer layerligne21 = new KmlLayer(map, R.raw.ligne_21, getApplicationContext());
                    layerligne21.addLayerToMap();
                    break;
                case "ligne 4" :
                    KmlLayer layerligne4 = new KmlLayer(map, R.raw.ligne_4, getApplicationContext());
                    layerligne4.addLayerToMap();
                    break;
                case "ligne 5" :
                    KmlLayer layerligne5 = new KmlLayer(map, R.raw.ligne_5, getApplicationContext());
                    layerligne5.addLayerToMap();
                    break;
                case "ligne 6" :
                    KmlLayer layerligne6 = new KmlLayer(map, R.raw.ligne_6, getApplicationContext());
                    layerligne6.addLayerToMap();
                    break;
                case "ligne 7" :
                    KmlLayer layerligne7 = new KmlLayer(map, R.raw.ligne_7, getApplicationContext());
                    layerligne7.addLayerToMap();
                    break;
                case "ligne 8" :
                    KmlLayer layerligne8 = new KmlLayer(map, R.raw.ligne_4, getApplicationContext());
                    layerligne8.addLayerToMap();
                    break;
                default :
                    //todo afficher toutes les lignes d'un coup
                    break;
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



