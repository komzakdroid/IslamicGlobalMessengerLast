package com.limuealimi.islamicglobalmessengerfromyasimin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.Navigation
import com.limuealimi.islamicglobalmessengerfromyasimin.R
import com.limuealimi.islamicglobalmessengerfromyasimin.databinding.ActivityMainBinding
import com.limuealimi.islamicglobalmessengerfromyasimin.models.UserData
import com.limuealimi.islamicglobalmessengerfromyasimin.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

/*
        ApiClient.apiService.nameCheck("peter")
            .enqueue(object : Callback<UserData> {
                override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                    if (response.isSuccessful) {
                        val userData = response.body()
                        binding.name.text = userData?.gender
                    }
                }

                override fun onFailure(call: Call<UserData>, t: Throwable) {
                    binding.name.text = "O'xshamadiku!"
                }

            })*/
    }

    override fun onNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp()
    }
}