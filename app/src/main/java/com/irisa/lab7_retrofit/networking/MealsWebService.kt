package com.irisa.lab7_retrofit.networking

import com.irisa.lab7_retrofit.networking.response.Constants
import com.irisa.lab7_retrofit.networking.response.*
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory

class MealsWebService {
    private lateinit var api: MealsAPI //Interfaz

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsAPI::class.java)
    }

    //Categories
    suspend fun getMealsCategories(): CategoryResponse {
        return api.getCategories()
    }

    //Filters
    suspend fun getMealsFilter(category: String): FilterResponse {
        return api.getFilter(category)
    }

    //LookUp
    suspend fun getMealsLook(id: String): LookResponse {
        return api.getLookUp(id)
    }
}


