package com.example.projectdua

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment__my_friends.*

class Fragment_MyFriends : Fragment() {

    lateinit var listTeman : ArrayList<MyFriend>

    private fun simulasiDataTeman(){
        listTeman = ArrayList()
        listTeman.add(MyFriend("Fahri","Laki-Laki","Fahri@smkkoding.com","0898713342","Malang"))
        listTeman.add(MyFriend("Ahmad","Laki-Laki","ahmd@smkkoding.com","0898172442","Malang"))
    }

    private fun tampilTeman(){
        rv_listMyFriends.layoutManager = LinearLayoutManager(activity)
        rv_listMyFriends.adapter = MyFriendAdapter(activity!!,listTeman)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment__my_friends, container, false)
    }
    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        simulasiDataTeman()
        tampilTeman()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}

