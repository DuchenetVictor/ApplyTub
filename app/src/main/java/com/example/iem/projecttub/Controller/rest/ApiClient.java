package com.example.iem.projecttub.Controller.rest;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.iem.projecttub.pojo.Stop;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by David_tepoche on 26/01/2017.
 */

public class ApiClient {

        public static final String BASE_URL = "http://tpwebservice/web/index.php/api/";
        private static Retrofit retrofit = null;

        public static Retrofit getClient() {
            if (retrofit==null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }

        public static ApiInterface getApiInterface(){
            ApiInterface apiService =
                    ApiClient.getClient().create(ApiInterface.class);

            return apiService;
        }


    public static void getStops(final Context context){
        Toast.makeText(context,"test",Toast.LENGTH_SHORT).show();

        Call<List<Stop>> call = getApiInterface().getStops(context);

        call.enqueue(new Callback<List<Stop>>() {
            @Override
            public void onResponse(Call<List<Stop>> call, Response<List<Stop>> response) {
                Toast.makeText(context,"onResponse",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Stop>> call, Throwable t) {
                Toast.makeText(context,"onFailure",Toast.LENGTH_SHORT).show();

            }
        });


    }

}
