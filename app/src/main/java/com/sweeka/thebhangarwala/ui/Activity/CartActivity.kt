package com.sweeka.thebhangarwala.ui.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sweeka.thebhangarwala.R
import com.sweeka.thebhangarwala.databinding.ActivityCartBinding
import com.sweeka.thebhangarwala.db.DataModels.Product
import com.sweeka.thebhangarwala.db.DataModels.SelectedProduct
import com.sweeka.thebhangarwala.ui.adapter.AddedProductItemAdapter
import com.sweeka.thebhangarwala.ui.interfaces.recycleViewCallback
import com.sweeka.thebhangarwala.ui.viewmodels.CartActivityViewModel

class CartActivity : BaseActivity(),recycleViewCallback {

    lateinit var binding:ActivityCartBinding
    lateinit var CartActivityVM:CartActivityViewModel
    var addedItem = arrayListOf<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_cart)
        CartActivityVM = ViewModelProviders.of(this).get(CartActivityViewModel::class.java)
        Observable()
    }
    private fun Observable(){
        CartActivityVM.getAllAddedItem().observe(this, Observer {

            if (it.size > 0 ){
                addedItem.clear()
                addedItem.addAll(it)
                binding.addedItemRecycler.layoutManager = LinearLayoutManager(this)
                var addedProductItemAdapter = AddedProductItemAdapter(this,this)
                addedProductItemAdapter.setSelectedProductList(addedItem)
                binding.addedItemRecycler.adapter = addedProductItemAdapter
            }
            else{

            }
        })
    }
    override fun onClick(position: Int){
        Toast.makeText(this,"position is $position",Toast.LENGTH_SHORT).show()
        var intent = Intent(this,GoToCartActivity::class.java)
        startActivity(intent)
    }
}