package com.appdev.mywheatherapplication.domin

import android.provider.DocumentsContract.Root
import com.appdev.mywheatherapplication.data.RootModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/data/2.5/weather?appid=a2c78d3ed85c5de81871ebffa5c7ce03")
    suspend fun getdata(
        @Query("q") q:String
    ):Response<RootModel>
}