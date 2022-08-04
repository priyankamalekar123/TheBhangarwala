package com.sweeka.thebhangarwala


class Selected {

    private val list = emptyList<String>()

    fun getList(): List<String>? {
        return list
    }

    fun setList(list: List<String?>) {
//        Selected.list = list
    }


    private val imagedata = HashMap<String, String>()
    fun getImagedata(): HashMap<String, String>? {
        return imagedata
    }

    fun setImagedata(imagedata: HashMap<String?, String?>) {
//        Selected.imagedata = imagedata
    }


    private val getDetails = ArrayList<HashMap<String, String>>()
    fun getGetDetails(): ArrayList<HashMap<String, String>>? {
        return getDetails
    }

    fun setGetDetails(getDetails: ArrayList<HashMap<String?, String?>?>) {
//        Selected.getDetails = getDetails
    }

}
