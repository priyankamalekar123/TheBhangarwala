package com.sweeka.thebhangarwala.api.api_models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BottlesItem(
    @SerializedName("categories")
    @Expose
    val categories: String,
    @SerializedName("iid")
    @Expose
    val iid: String,
    @SerializedName("image")
    @Expose
    val image: String,
    @SerializedName("item_name")
    @Expose
    val item_name: String,
    @SerializedName("price")
    @Expose
    val price: String,
    @SerializedName("unit")
    @Expose
    val unit: String
)