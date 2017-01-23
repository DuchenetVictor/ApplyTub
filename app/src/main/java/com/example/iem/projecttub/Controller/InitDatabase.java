package com.example.iem.projecttub.Controller;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by David_tepoche on 16/01/2017.
 */

public class InitDatabase extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // This instantiates DBFlow
        FlowManager.init(new FlowConfig.Builder(this).build());
        
        
        
        //// TODO: 18/01/2017 faire le check si la database(mobile) est la même que la database(WS) 
    }
}
