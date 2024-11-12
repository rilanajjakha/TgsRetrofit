package com.example.tgsretrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tgsretrofit.adapter.com.example.tgsretrofit.TrackAdapter
import com.example.tgsretrofit.databinding.ActivityMainBinding
import com.example.tgsretrofit.model.ApiData
import com.example.tgsretrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var trackAdapter: TrackAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        trackAdapter = TrackAdapter(emptyList())
        binding.recyclerView.adapter = trackAdapter

        getChartData()
    }

    private fun getChartData() {
        val call = ApiClient.getInstance().getChartData()  // Use getInstance() to get the ApiService
        call.enqueue(object : Callback<ApiData> {
            override fun onResponse(call: Call<ApiData>, response: Response<ApiData>) {
                if (response.isSuccessful) {
                    val tracks = response.body()?.tracks?.data ?: emptyList()
                    trackAdapter = TrackAdapter(tracks) // Update the adapter with new data
                    binding.recyclerView.adapter = trackAdapter
                } else {
                    Toast.makeText(applicationContext, "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ApiData>, t: Throwable) {
                Toast.makeText(applicationContext, "Error fetching data", Toast.LENGTH_SHORT).show()
            }
        })
    }
}