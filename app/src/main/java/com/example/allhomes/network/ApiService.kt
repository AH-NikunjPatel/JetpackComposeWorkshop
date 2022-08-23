package com.example.allhomes.network

import com.example.allhomes.model.PropertyRequest
import com.example.allhomes.model.PropertyResponse
import com.example.allhomes.model.PropertyResult
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import com.example.allhomes.utils.*
import retrofit2.converter.gson.GsonConverterFactory

interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("search")
    suspend fun getPropertyList(
        @Body property: PropertyRequest
    ): PropertyResponse

    companion object{
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if(apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}