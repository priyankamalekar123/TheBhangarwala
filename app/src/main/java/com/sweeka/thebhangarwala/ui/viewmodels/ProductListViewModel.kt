package com.sweeka.thebhangarwala.ui.viewmodels

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sweeka.thebhangarwala.api.RetrofitClientObj
import com.sweeka.thebhangarwala.api.api_models.Bottles
import com.sweeka.thebhangarwala.db.AppDatabase
import com.sweeka.thebhangarwala.db.AsyncDbCrud
import com.sweeka.thebhangarwala.db.DataModels.Product
import com.sweeka.thebhangarwala.ui.interfaces.RetrofitCallback
import com.sweeka.thebhangarwala.viewBinder.ProductListBinder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import kotlin.collections.HashMap


class ProductListViewModel(application: Application):BaseViewModel(application) {

       var asyncDbCrud = AsyncDbCrud(application)
       var isDataAvailable = MutableLiveData<Boolean>(false)
       var check_db_data = MutableLiveData<String>("")
       var productData = MutableLiveData<List<Product>>(null)

       var db: AppDatabase = AppDatabase.getDatabase(application)

       fun getProd(category: String){
              AsyncTask.execute {
              var data =  db.productDao().getProduct(category)
                     productData.postValue(data)
              }
       }

       fun getSecondlevelCategory(category: String,callback: RetrofitCallback){
              val params: MutableMap<String, String> = HashMap<String,String>()
              params["categories"] = category

              RetrofitClientObj(context).instance.getSecondlevelCategory(params).enqueue(object :Callback<Bottles>{
                     override fun onResponse(call: Call<Bottles>, response: Response<Bottles>) {
                            if (response.isSuccessful) {
                                   var data:Bottles = response.body()!!
                                   if(!isDataAvailable.value!!){
                                          asyncDbCrud.insertProduct(data)

                                          callback.onSuccess()
                                   }

                            }
                     }

                     override fun onFailure(call: Call<Bottles>, t: Throwable) {

                            Log.e("priyanka","onFailure :"+t.message)
                            callback.onApiFail(t)
                     }

              })



       }






}