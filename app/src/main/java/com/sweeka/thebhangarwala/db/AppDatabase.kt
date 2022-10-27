package com.sweeka.thebhangarwala.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sweeka.thebhangarwala.db.Dao.ProductDao
import com.sweeka.thebhangarwala.db.DataModels.Product
import com.sweeka.thebhangarwala.db.DataModels.SelectedProduct

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

  abstract fun productDao():ProductDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "bhangaarwaala_db").build() }
            }
            return INSTANCE!!
        }
    }
}