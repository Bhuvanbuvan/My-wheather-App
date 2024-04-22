package com.appdev.mywheatherapplication.domin

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Retrofit_Insetence {
    //create ApiService
    fun getApiservice(builder:Retrofit.Builder):ApiInterface{
        return builder.build()
            .create(ApiInterface::class.java)
    }

    //Create RetrofitInstence
    fun getRetInstence():Retrofit.Builder{
        return  Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(MoshiConverterFactory.create())

    }
}