package com.sweeka.thebhangarwala

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sweeka.thebhangarwala.db.DataModels.Product
import com.sweeka.thebhangarwala.ui.interfaces.recycleViewCallback

class ProductItemAdapter(var context: Context,var recycleViewCallback: recycleViewCallback):RecyclerView.Adapter<ProductItemAdapter.ViewHolder>() {

      private var ProductList = ArrayList<Product>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout,parent,false)

        return ViewHolder(view,recycleViewCallback)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = ProductList[position]
        holder.product_name.text = data.item_name
        Glide.with(context).load(data.image).into(holder.product_img)



    }

    override fun getItemCount(): Int {
        return ProductList.size
    }

     fun setProductList(productList: ArrayList<Product>){
         ProductList.addAll(productList)
         notifyDataSetChanged()
     }

    class ViewHolder(ItemView: View,recycleViewCallback:recycleViewCallback):RecyclerView.ViewHolder(ItemView){
         var product_img = ItemView.findViewById<ImageView>(R.id.single_imageView)
         var product_name = ItemView.findViewById<TextView>(R.id.single_textView)

        init {
            ItemView.setOnClickListener {
                recycleViewCallback.onClick(adapterPosition)
            }
        }

    }
}