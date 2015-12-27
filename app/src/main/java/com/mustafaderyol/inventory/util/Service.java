package com.mustafaderyol.inventory.util;

import com.mustafaderyol.inventory.entity.Inventory;
import com.mustafaderyol.inventory.entity.InventoryRelationship;
import com.mustafaderyol.inventory.entity.Personal;
import com.mustafaderyol.inventory.entity.Services;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by MstfDryl on 24.12.2015.
 */
public interface Service {

    @Headers({"Content-type: application/json"})
    @POST("personal/login")
    Call<Personal> getUser(@Body LoginItem loginItem);

    @GET("inventory/{id}")
    Call<Inventory> getInventory(@Path("id") Long id, @Header("Authorization") String authorization);

    @GET("inventoryrelationship/left/{id}")
    Call<List<InventoryRelationship>> getInventoryRelationship(@Path("id") Long id,@Header("Authorization") String authorization);

    @GET("services/all/{id}")
    Call<List<Services>> getInventoryServices(@Path("id") Long id, @Header("Authorization") String authorization);

    @Headers({"Content-type: application/json"})
    @PUT("personal/update")
    Call<Personal> updatePersonal(@Body Personal Personal, @Header("Authorization") String authorization);
}
