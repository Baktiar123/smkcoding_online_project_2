package data

import com.example.projectdua.IndonesiaItem
import retrofit2.Call
import retrofit2.http.GET

interface IndonesiaService {
    @GET("indonesia")
    fun getIndonesia(): Call<List<IndonesiaItem>>
}