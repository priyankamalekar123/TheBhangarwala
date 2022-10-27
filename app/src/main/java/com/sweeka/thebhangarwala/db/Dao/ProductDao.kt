package com.sweeka.thebhangarwala.db.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sweeka.thebhangarwala.db.DataModels.Product


@Dao
interface ProductDao {

@Insert
 fun addProduct(product: Product)

// @Query("SELECT * FROM product WHERE iid =:iid")
// fun getProduct(iid:String):ArrayList<Product>

 @Query("SELECT * FROM product WHERE type = :type")
 fun getProduct(type:String):List<Product>

 @Query("DELETE FROM product")
 fun deleteAll()

 @Query("SELECT * FROM product WHERE item_name = :itemName")
 fun getSelectedItem(itemName:String):LiveData<Product>

 @Query("SELECT * FROM product WHERE isPresent == 1")
 fun getAddedProduct():LiveData<List<Product>>

 @Query(" UPDATE product SET quantity = :quantity , totalAmount =:totalAmount ,isPresent =:isPresent WHERE item_name =:itemName")
 fun updateSell(quantity:Int,totalAmount:Long,itemName:String,isPresent:Boolean)


}