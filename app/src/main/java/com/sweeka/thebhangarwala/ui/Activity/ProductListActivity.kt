package com.sweeka.thebhangarwala.ui.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.sweeka.thebhangarwala.ProductItemAdapter
import com.sweeka.thebhangarwala.R
import com.sweeka.thebhangarwala.databinding.ActivityProductListBinding
import com.sweeka.thebhangarwala.db.DataModels.Product
import com.sweeka.thebhangarwala.ui.interfaces.RetrofitCallback
import com.sweeka.thebhangarwala.ui.interfaces.recycleViewCallback
import com.sweeka.thebhangarwala.ui.viewmodels.ProductListViewModel
import com.sweeka.thebhangarwala.viewBinder.ProductListBinder

class ProductListActivity : BaseActivity(),recycleViewCallback {

    lateinit var binding: ActivityProductListBinding
//    lateinit var bottlesItem: ArrayList<BottlesItem>
    lateinit var productListVM: ProductListViewModel
    lateinit var categories:String
    var productListBinder = ProductListBinder()
    var product_list = arrayListOf<Product>()
    var data: List<Product>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)

        productListVM = ViewModelProviders.of(this).get(ProductListViewModel::class.java)


        binding.productlistviewmodel = productListVM
        binding.binder = productListBinder

        var bundle = intent.extras
        if (bundle != null){
            categories = bundle.getString("categories")!!
        }


        productListVM.getSecondlevelCategory(categories,object :RetrofitCallback{
            override fun onSuccess() {
                productListVM.getProd(categories)
            }

            override fun onFail(message: String) {
                TODO("Not yet implemented")
            }

            override fun onApiFail(message: Throwable){

                Log.e("priyanka","product_list $product_list")

            }

            override fun onApiUnsuccessResponse(responseCode: Int) {
                TODO("Not yet implemented")
            }

        })

        initObserver()
        setRecycler()
    }

    private fun setRecycler() {
//        var data = productListVM.getProduct(categories)
//        productListVM.getProd(categories)
//        productListVM.productData.observe(this, Observer {
//            Log.e("priyanka","productDataSize ${it.size}")
//            if (it.size != 0){
//                productListVM.isDataAvailable.value = true
//            }
//        })
//            var data1 = productListVM.getProduct1(categories)
//        if (data1.size > 0){
//            product_list.clear()
//            product_list.addAll(data1)
//            binding.productdataRecycler.layoutManager = LinearLayoutManager(this)
//            var productItemAdapter = ProductItemAdapter(this,this)
//            productItemAdapter.setProductList(product_list)
//            binding.productdataRecycler.adapter = productItemAdapter
//
//            //visibility
//            binding.progressBar.visibility = View.GONE
//            binding.noDataFound.visibility = View.GONE
//        }
//        else{
//           binding.progressBar.visibility = View.GONE
//           binding.noDataFound.visibility = View.VISIBLE
//        }
    }

    private fun initObserver(){
        productListVM.getProd(categories)

        productListVM.productData.observe(this, Observer {
            if (it != null){
                Log.e("priyanka","productDataSize ${it.size}")
                if (it.size != 0){
                    productListVM.isDataAvailable.value = true

                    binding.progressBar.visibility = View.GONE
                    binding.noDataFound.visibility = View.GONE
                }
                else{
                    binding.progressBar.visibility = View.GONE
                    binding.noDataFound.visibility = View.VISIBLE
                }
            }
            else{
                binding.progressBar.visibility = View.VISIBLE
                binding.noDataFound.visibility = View.GONE
            }

        })


//        productListVM.getProduct(categories).observe(this, Observer {
//
//            Log.e("priyanka","list size = ${it.size}")
//
//            data = it
//            binding.progressBar.visibility = View.GONE
//            binding.productdataRecycler.visibility = View.VISIBLE
//            if(it.size!=0){
//                productListVM.isDataAvailable.value = true
//                productListVM.check_db_data.value = "1"
//                product_list.clear()
//                product_list.addAll(it)
//                binding.productdataRecycler.layoutManager = LinearLayoutManager(this)
//                var productItemAdapter = ProductItemAdapter(this,this)
//                productItemAdapter.setProductList(product_list)
//                binding.productdataRecycler.adapter = productItemAdapter
//
//            } else{
//                productListVM.check_db_data.value = "0"
//            }
//        })
    }

    override fun onClick(position: Int) {
        var intent = Intent(this,SingleProductActivity::class.java)
        var item:Product = product_list[position]
        Log.e("priyanka","item ${item.item_name}")
        intent.putExtra("item",Gson().toJson(item))
        startActivity(intent)
    }


}