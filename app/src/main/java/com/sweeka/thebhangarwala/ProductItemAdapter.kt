package com.sweeka.thebhangarwala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductItemAdapter(private val list:List<String>):RecyclerView.Adapter<ProductItemAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_layout,parent,false)

        return ViewHolder(view)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
         var product_img = ItemView.findViewById<ImageView>(R.id.product_img)
         var checkbox = ItemView.findViewById<CheckBox>(R.id.check_box)
         var product_name = ItemView.findViewById<TextView>(R.id.product_name)
         var rupees = ItemView.findViewById<TextView>(R.id.rupees)


    }
}