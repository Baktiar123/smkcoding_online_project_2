package data

import com.example.projectdua.GlobalItem
import retrofit2.Call
import retrofit2.http.GET

interface GlobalService {
    @GET("/")
    fun getGlobalApi(): Call<List<GlobalItem>>
}
