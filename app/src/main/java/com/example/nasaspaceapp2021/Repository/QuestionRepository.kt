package com.example.nasaspaceapp2021.Repository


import com.example.gamepedia.ui.api.ServiceBuilder
import com.example.nasaspaceapp2021.api.GameAPI
import com.example.nasaspaceapp2021.response.GameResponse
import com.example.nasaspaceapp2021.ui.api.MyApiRequest
import okhttp3.MultipartBody

class QuestionRepository : MyApiRequest() {
    private val gameAPI =
        ServiceBuilder.buildService(GameAPI::class.java)

//    suspend fun insertGame(gname : String, gdesc : String, gprice : String,gplatform : String,  ggenre : String, body : MultipartBody.Part ): AddGameResponse {
//        return apiRequest {
//            gameAPI.loadGame(gname, gdesc, gprice, gplatform, ggenre,body )
//        }
//    }


    suspend fun loadQuestion(): GameResponse {
        return apiRequest {
            gameAPI.loadQuestion("1")
        }
    }



//    suspend fun uploadImage(id: String, body: MultipartBody.Part):ImageResponse{
//        return apiRequest {
//            studentAPI.uploadImage(ServiceBuilder.token!!, id, body)
//        }
//    }

}