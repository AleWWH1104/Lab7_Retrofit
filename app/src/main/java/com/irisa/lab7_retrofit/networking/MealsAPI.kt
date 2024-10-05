package com.irisa.lab7_retrofit.networking

import com.irisa.lab7_retrofit.networking.response.*
import retrofit2.http.*

interface MealsAPI {
    //Categorias
    @GET(Constants.path_url_1)
    suspend fun getCategories(): CategoryResponse

    //Filtros
    @GET(Constants.path_url_2)
    suspend fun getFilter(
        @Query("c") category : String
    ): FilterResponse

    //Look
    @GET(Constants.path_url_3)
    suspend fun getLookUp(
        @Query("i") id : String
    ): LookResponse
}


