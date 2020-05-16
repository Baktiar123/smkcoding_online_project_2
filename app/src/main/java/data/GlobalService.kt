package data

import com.example.projectdua.GlobalItem
import retrofit2.Call

interface GlobalService {
    fun getUsers(): Call<List<GlobalItem>>
}