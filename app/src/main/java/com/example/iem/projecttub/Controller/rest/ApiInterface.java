package com.example.iem.projecttub.Controller.rest;

import android.content.Context;

import com.example.iem.projecttub.pojo.Stop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Query;

/**
 * Created by David_tepoche on 26/01/2017.
 */

public interface ApiInterface {

    @GET("stop/")
    Call<List<Stop>> getStops( Context context);
}
