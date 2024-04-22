package com.appdev.mywheatherapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.appdev.mywheatherapplication.data.RootModel
import com.appdev.mywheatherapplication.domin.Repository
import com.appdev.mywheatherapplication.domin.Retrofit_Insetence
import com.appdev.mywheatherapplication.domin.ViewModel
import com.appdev.mywheatherapplication.ui.theme.MyWheatherApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyWheatherApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val repo=Repository(Retrofit_Insetence.getApiservice(Retrofit_Insetence.getRetInstence()))
                    val viewmodel=ViewModel(repo)
                    val data:RootModel? by viewmodel
                        .getDataFromRepo("Puducherry")
                        .observeAsState(null)
                    Log.i("TAGY","${data?.main?.humidity}")
                }
            }
        }
    }
}
