package com.sweeka.thebhangarwala.db.DataModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "selectedProduct")
class SelectedProduct (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @Expose
    var id: Int=0,

    @ColumnInfo(name = "type")
    @Expose
    val type: String,

    @ColumnInfo(name = "categories")
    @Expose
    var categories: String,


    @ColumnInfo(name = "image")
    @Expose
    val image: String,

    @ColumnInfo(name = "item_name")
    @Expose
    val item_name: String,

    @ColumnInfo(name = "price")
    @Expose
    val price: String,

    @ColumnInfo(name = "quantity")
    @Expose
    val quantity: Int,

    @ColumnInfo(name = "totalAmount")
    @Expose
    val totalAmount: Long,

    @ColumnInfo(name = "unit")
    @Expose
    val unit:String



)