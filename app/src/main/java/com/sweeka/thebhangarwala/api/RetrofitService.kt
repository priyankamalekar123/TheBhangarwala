package com.sweeka.thebhangarwala.api


import com.sweeka.thebhangarwala.api.api_models.Bottles
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface RetrofitService {

    @FormUrlEncoded
    @POST("get_products.php")
    fun getProduct(params:Map<String,String>): Call<Bottles>

    @POST("get_products.php")
    fun getSecondlevelCategory(@Body params: HashMap<String, String>): Call<Bottles>


}