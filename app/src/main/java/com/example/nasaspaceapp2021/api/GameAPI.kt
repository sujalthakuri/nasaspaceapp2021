package com.example.nasaspaceapp2021.api

import com.example.nasaspaceapp2021.response.GameResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface GameAPI {

    @Multipart
    @POST("load_question")
    suspend fun loadGame(
        @Part("gname") gname : String,
        @Part("gdesc") gdesc : String,
        @Part("gprice") gprice : String,
        @Part("gplatform") gplatform : String,
        @Part("ggenre") ggenre : String,
        @Part file: MultipartBody.Part
    ): Response<GameResponse>


    @FormUrlEncoded
    @POST("load_question")
    suspend fun loadQuestion(
        @Field("questionBank") questionBank : String
    ): Response<GameResponse>



//    @Multipart
//    @PUT("game/{id}/photo")
//    suspend fun uploadImage(
//        @Header("Authorization") token: String,
//        @Path("id") id: String,
//        @Part file: MultipartBody.Part
//    ): Response<ImageResponse>
}