package com.mustafaderyol.inventory.util;

import com.mustafaderyol.inventory.entity.Inventory;
import com.mustafaderyol.inventory.entity.InventoryRelationship;
import com.mustafaderyol.inventory.entity.Personal;
import com.squareup.okhttp.OkHttpClient;

import java.util.List;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by MstfDryl on 24.12.2015.
 */
public class Global {
    public static String BASE_URL = "http://192.168.1.15:8080/Inventory/rest/";


    public static String BASIC_AUTH;

    public static Personal PERSONAL;
    public static String EMAIL;
    public static String PASSWORD;


    public static Inventory INVENTORY;

    public static List<InventoryRelationship> INVENTORTYRELATIONSHIPLIST;



    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Service service = retrofit.create(Service.class);


}
