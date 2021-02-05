package com.example.peretztest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("products")
    Call<List<Dish>> getDishes(
            @Query("category") String categoryId,
            @Query("key") String key
    );
}
