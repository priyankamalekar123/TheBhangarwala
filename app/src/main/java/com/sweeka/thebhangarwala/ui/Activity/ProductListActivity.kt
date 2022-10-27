package com.sweeka.thebhangarwala.ui.Activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sweeka.thebhangarwala.ProductItemAdapter
import com.sweeka.thebhangarwala.R
import com.sweeka.thebhangarwala.api.RetrofitClientObj
import com.sweeka.thebhangarwala.api.api_models.Bottles
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductListActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var list: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        recyclerView = findViewById(R.id.recyclerview)

        list = arrayListOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m")

        recyclerView.layoutManager = LinearLayoutManager(this)
        var productItemAdapter = ProductItemAdapter()
        productItemAdapter.setProductList(list)
        recyclerView.adapter = productItemAdapter

        //creating request parameters
        val params = HashMap<String, String>()


            RetrofitClientObj(this).instance.getSecondlevelCategory(params).enqueue(object :Callback<Bottles>{
                override fun onResponse(call: Call<Bottles>, response: Response<Bottles>) {
                    if (response.isSuccessful){
                        Log.e("priyanka",response.body()?.size.toString())
                    }
                }
                override fun onFailure(call: Call<Bottles>, t: Throwable) {
                    Log.e("priyanka","api data failed")
                }

            })
    }
}