package com.example.shashank.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {
    private val users = ArrayList<MyDataItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyleview = findViewById<RecyclerView>(R.id.Recyclerview)
        recyleview.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            recyleview.adapter = MyAdaptor(users)
        }
        getData()
    }

    private fun getData() {
        val BASE_URL="https://api.publicapis.org/"
        val retroFit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(Api::class.java)
        val retrofitData = retroFit.getUserDetails()
                GlobalScope.launch {
            val retro = retrofitData
            withContext(Dispatchers.Main){
                Log.d("resp","${retro}".toString())
            }
        }

    }
    interface Api {
        @GET("/entries")
         fun getUserDetails(): JsonObject
    }
}