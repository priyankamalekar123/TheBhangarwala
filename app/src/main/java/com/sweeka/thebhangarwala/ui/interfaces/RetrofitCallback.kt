package com.sweeka.thebhangarwala.ui.interfaces

interface RetrofitCallback {

    fun onSuccess()

    fun onFail(message:String)

    fun onApiFail(message:Throwable)
    fun onApiUnsuccessResponse(responseCode:Int)
}