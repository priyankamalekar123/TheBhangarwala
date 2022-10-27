package com.sweeka.thebhangarwala.api


import com.sweeka.thebhangarwala.api.api_models.Bottles
import retrofit2.Call
import retrofit2.http.*


interface RetrofitService {

    @FormUrlEncoded
    @POST("get_products.php")
    fun getSecondlevelCategory(@FieldMap params: Map<String, String>): Call<Bottles>


}