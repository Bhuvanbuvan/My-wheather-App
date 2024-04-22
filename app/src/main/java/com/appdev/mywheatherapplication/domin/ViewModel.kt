package com.appdev.mywheatherapplication.domin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appdev.mywheatherapplication.data.RootModel
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModel(private val repository: Repository):ViewModel() {
    var data=MutableLiveData<RootModel>()
    fun getDataFromRepo(city:String):LiveData<RootModel>{
        viewModelScope.launch {
            val model=repository.getDataFromApi(city)
            if (model != null) {
                if (model.body()!==null){
                    data.value=model.body()
                }
            }
        }
        return data
    }

}