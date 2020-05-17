package com.example.projectdua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import data.IndonesiaService
import data.apiRequest
import data.httpClient
import util.dismissLoading
import util.showLoading
import util.tampilToast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_indonesia.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_indonesia, container, false)
    }
    override fun onViewCreated(
        view: View,
        @Nullable savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        callApiGetIndonesia()
    }

    private fun callApiGetIndonesia() {
        showLoading(context!!, swipeRefreshLayout)

        showLoading(context!!,swipeRefreshLayout)
        val httpClient = httpClient()
        val apiRequest = apiRequest<IndonesiaService>(httpClient)
        val call = apiRequest.getIndonesia()
        call.enqueue(object : Callback<List<IndonesiaItem>> {
            override fun onFailure(call: Call<List<IndonesiaItem>>, t: Throwable) {
                dismissLoading(swipeRefreshLayout)
            }

            override fun onResponse(call: Call<List<IndonesiaItem>>, response:
            Response<List<IndonesiaItem>>) {
                dismissLoading(swipeRefreshLayout)
                when {
                    response.isSuccessful ->
                        when {
                            response.body()?.size != 0 ->
                                tampilIndonesia(response.body()!!)
                            else -> {
                                tampilToast(context!!, "Berhasil")
                            }
                        }
                    else -> {
                        tampilToast(context!!, "Gagal")
                    }
                }
            }
        })
    }

    private fun tampilIndonesia(Indonesia: List<IndonesiaItem>) {
        listIndonesia.layoutManager = LinearLayoutManager(context)
        listIndonesia.adapter = IndonesiaAdapter(context!!, Indonesia) {
            val IndonesiaData = it
            tampilToast(context!!, IndonesiaData.name)
        }
    }

}


