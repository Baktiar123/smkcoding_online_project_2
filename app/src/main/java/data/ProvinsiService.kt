package data

import com.example.projectdua.ProvinsiItem
import retrofit2.Call
import retrofit2.http.GET

interface ProvinsiService {
    @GET("indonesia/provinsi/")
    fun getProv(): Call<List<ProvinsiItem>>
}