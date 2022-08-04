package com.sweeka.thebhangarwala.api

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClientObj(context: Context) {

    private val BASE_URL = "http://gravityclasses.co.in/bhangarwala/"

    var gson = GsonBuilder()
              .setLenient()
              .create()

     private val okHttpClient = OkHttpClient.Builder()
     .connectTimeout(60, TimeUnit.SECONDS)
     .readTimeout(60, TimeUnit.SECONDS)
     .writeTimeout(60, TimeUnit.SECONDS)
     .addInterceptor(addHttpLoggingInterceptor())
         .addInterceptor{ chain ->
             val original = chain.request()
             val requestBuilder = original.newBuilder()
                 .addHeader("Content-Type", "application/x-www-form-urlencoded")
                 .addHeader("charset", "utf-8")
             val request = requestBuilder.build()
             chain.proceed(request)

         }
     .build()


    val instance : RetrofitService by lazy {



        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
        retrofit.create(RetrofitService::class.java)


    }

    private fun addHttpLoggingInterceptor(): Interceptor {
        val logRequestResponseInterceptor = HttpLoggingInterceptor()
        logRequestResponseInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return logRequestResponseInterceptor

    }
}