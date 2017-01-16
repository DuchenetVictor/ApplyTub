package com.example.iem.projecttub.Controller;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by David_tepoche on 15/01/2017.
 */
@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)
public class MyDatabase {
    public static final String NAME = "MyDatabase";
    public static final int VERSION = 3;
}
