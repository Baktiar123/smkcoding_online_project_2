package com.example.projectdua


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import data.GlobalService
import data.ProvinsiService
import data.apiRequest
import data.httpClient
import util.dismissLoading
import util.showLoading
import util.tampilToast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_global.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GlobalFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_global, container, false)
    }
    override fun onViewCreated(
        view: View,
        @Nullable savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        callApiGetGlobalData()
    }
    private fun callApiGetGlobalData() {
        showLoading(context!!, swipeRefreshLayout)
        val httpClient = httpClient()
        val apiRequest = apiRequest<GlobalService>(httpClient)
        val call = apiRequest.getGlobalApi()
        call.enqueue(object : Callback<List<GlobalItem>> {
            override fun onFailure(call: Call<List<GlobalItem>>, t: Throwable) {
                dismissLoading(swipeRefreshLayout)
            }
            override fun onResponse(call: Call<List<GlobalItem>>, response:
            Response<List<GlobalItem>>) {
                dismissLoading(swipeRefreshLayout)
                when {
                    response.isSuccessful ->
                        when {
                            response.body()?.size != 0 ->
                                tampilGithubUser(response.body()!!)
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

    private fun tampilGithubUser(githubUsers: List<GlobalItem>) {
        listGlobal.layoutManager = LinearLayoutManager(context)
        listGlobal.adapter = GlobalAdapter(context!!, githubUsers) {

            val githubUser = it
            tampilToast(context!!, githubUser.attributes.countryRegion)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}