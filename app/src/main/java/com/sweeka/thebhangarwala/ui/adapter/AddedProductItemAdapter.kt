package com.sweeka.thebhangarwala.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sweeka.thebhangarwala.R
import com.sweeka.thebhangarwala.db.DataModels.Product
import com.sweeka.thebhangarwala.db.DataModels.SelectedProduct
import com.sweeka.thebhangarwala.ui.interfaces.recycleViewCallback

class AddedProductItemAdapter(var context: Context,var recycleViewCallback: recycleViewCallback):RecyclerView.Adapter<AddedProductItemAdapter.ViewHolder>() {


    private var AddedProduct = ArrayList<Product>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.added_product_item_viewlayout,parent,false)
        return ViewHolder(view,recycleViewCallback)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = AddedProduct[position]
        holder.itemName.text = data.item_name
        holder.itemPrice.text = "${data.price} ${data.unit}"
        Glide.with(context).load(data.image).into(holder.item_img)
    }

    override fun getItemCount(): Int {
       return AddedProduct.size
    }

    fun setSelectedProductList(addedProduct: ArrayList<Product>){
        AddedProduct.addAll(addedProduct)
        notifyDataSetChanged()
    }


    class ViewHolder(ItemView: View,recycleViewCallback: recycleViewCallback):RecyclerView.ViewHolder(ItemView) {

        var itemName = ItemView.findViewById<TextView>(R.id.added_item_name)
        var itemPrice = ItemView.findViewById<TextView>(R.id.price)
        var item_img = ItemView.findViewById<ImageView>(R.id.added_img)

        init {
            ItemView.setOnClickListener {
                recycleViewCallback.onClick(adapterPosition)
            }

        }
    }
}