package com.appdev.mywheatherapplication.domin

import android.util.Log
import com.appdev.mywheatherapplication.data.RootModel
import retrofit2.Response

class Repository(private val apiInterface: ApiInterface) {
    suspend fun getDataFromApi(city:String):Response<RootModel>?{
        return try {
            val reponse:Response<RootModel> = apiInterface.getdata(city)
            if (reponse.isSuccessful){
               reponse
            }else{
                Log.e("TAGY","Unsucessfully response : ${reponse.errorBody()?.toString()}")
                null
            }
        }catch (e:Exception){
            Log.e("TAGY", "${e.message}",e)
            null
        }
    }
}