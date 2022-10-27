package com.sweeka.thebhangarwala.ui.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.sweeka.thebhangarwala.R
import com.sweeka.thebhangarwala.databinding.ActivitySingleProductBinding
import com.sweeka.thebhangarwala.db.DataModels.Product
import com.sweeka.thebhangarwala.ui.interfaces.gotoNext
import com.sweeka.thebhangarwala.ui.viewmodels.SingleProductViewModel
import com.sweeka.thebhangarwala.viewBinder.SingleProductBinder


class SingleProductActivity : BaseActivity(){
    lateinit var SingleProductVM:SingleProductViewModel
    lateinit var binding: ActivitySingleProductBinding
    lateinit var product:Product
    var single_product1 = SingleProductBinder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_single_product)
        SingleProductVM = ViewModelProvider(this).get(SingleProductViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewmodel1 = SingleProductVM
//        binding.handler = ClickHandler()
        binding.binder = single_product1

        val gson = Gson()
        product = gson.fromJson<Product>(intent.getStringExtra("item"), Product::class.java)
        SingleProductVM.product1.set(product)

        initObserver()
        Glide.with(this).load(product.image).into(binding.imgItem)

        single_product1.amount_per_kg.value = "${product.price} Rs."
        single_product1.item_name.value = product.item_name

        binding.goToCart.setOnClickListener {
            var intent = Intent(this,GoToCartActivity::class.java)
            startActivity(intent)
        }



    }

    private fun initObserver() {
        SingleProductVM.getItem(product.item_name).observe(this, Observer {
            Log.e("priyanka","itemPresent ${it.isPresent}")
            if (it.isPresent){
                SingleProductVM.item_present.value = true
                SingleProductVM.quantityOfItemPresentInDb.value = it.quantity
            }
            else{
                SingleProductVM.item_present.value = false

            }
        })

        SingleProductVM.quantityOfItems.observe(this, Observer {
            single_product1.quantity_of_item.value = " $it ${product.unit}"
            var total_price = it * product.price.toInt()
            single_product1.total_amount.value = "$total_price Rs."

        })

        SingleProductVM.item_present.observe(this, Observer {

            single_product1.isItemPresent.value = it
        })
    }


    class ClickHandler {
        fun gotoNextActivity(view: View?) {
        }
    }
}