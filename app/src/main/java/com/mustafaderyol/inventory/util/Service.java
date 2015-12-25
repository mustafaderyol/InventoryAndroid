package com.mustafaderyol.inventory.util;

import com.mustafaderyol.inventory.entity.Inventory;
import com.mustafaderyol.inventory.entity.InventoryRelationship;
import com.mustafaderyol.inventory.entity.Personal;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by MstfDryl on 24.12.2015.
 */
public interface Service {

    @Headers({"Content-type: application/json"})
    @POST("personal/login")
    Call<Personal> getUser(@Body LoginItem loginItem);

    @GET("inventory/{id}")
    Call<Inventory> getInventory(@Path("id") Long id);

    @GET("inventoryrelationship/left/{id}")
    Call<List<InventoryRelationship>> getInventoryRelationship(@Path("id") Long id);
}
