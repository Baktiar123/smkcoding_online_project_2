package com.example.projectdua

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.global_item.*

class ProvinsiAdapter(private val context: Context, private val items:
List<ProvinsiItem>, private val listener: (ProvinsiItem)-> Unit) :
    RecyclerView.Adapter<ProvinsiAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(context, LayoutInflater.from(context).inflate(R.layout.global_item,
            parent, false))
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }
    class ViewHolder(val context: Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item: ProvinsiItem, listener: (ProvinsiItem) -> Unit) {
            txtRegion.text = item.attributes.provinsi
            txtUserRepo.text = item.attributes.kasusPosi.toString()

            containerView.setOnClickListener { listener(item) }
        }
    }
}