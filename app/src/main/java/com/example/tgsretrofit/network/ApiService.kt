package com.example.tgsretrofit.network

import com.example.tgsretrofit.model.ApiData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("chart")
    fun getChartData(): Call<ApiData>
}