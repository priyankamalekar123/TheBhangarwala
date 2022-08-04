package com.sweeka.thebhangarwala.api.api_models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Responceorder(

    @SerializedName("success_msg")
    @Expose
    val successMsg: Boolean?,
    @SerializedName("message")
    @Expose
    val message: String
)
