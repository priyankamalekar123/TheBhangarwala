package com.sweeka.thebhangarwala.db.DataModels

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
@Entity(tableName = "product")
class Product(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    val id:Int,

    @ColumnInfo(name = "type")
    @SerializedName("type")
    @Expose
    val type: String,

    @ColumnInfo(name = "categories")
    @SerializedName("categories")
    @Expose
    var categories: String,


    @ColumnInfo(name = "image")
    @SerializedName("image")
    @Expose
    val image: String,

    @ColumnInfo(name = "item_name")
    @SerializedName("item_name")
    @Expose
    val item_name: String,

    @ColumnInfo(name = "price")
    @SerializedName("price")
    @Expose
    val price: String,

    @ColumnInfo(name = "unit")
    @SerializedName("unit")
    @Expose
    val unit: String,

    @ColumnInfo(name = "quantity")
    @Expose
    val quantity: Int = 0,

    @ColumnInfo(name = "totalAmount")
    @Expose
    val totalAmount: Long = 0,

    @ColumnInfo(name = "isPresent")
    @Expose
    val isPresent: Boolean = false
    )