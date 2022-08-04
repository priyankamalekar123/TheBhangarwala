package com.sweeka.thebhangarwala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductItemAdapter(/*private var ProductList:ArrayList<String>*/):RecyclerView.Adapter<ProductItemAdapter.ViewHolder>() {

      private var ProductList = ArrayList<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout,parent,false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = ProductList[position]
        holder.product_name.text = data

    }

    override fun getItemCount(): Int {
        return ProductList.size
    }

     fun setProductList(productList:ArrayList<String>){
         ProductList = productList
         notifyDataSetChanged()
     }

    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
         var product_img = ItemView.findViewById<ImageView>(R.id.imageView)
         var checkbox = ItemView.findViewById<CheckBox>(R.id.checkbox)
         var product_name = ItemView.findViewById<TextView>(R.id.textView)
         var rupees = ItemView.findViewById<TextView>(R.id.price)
    }
}