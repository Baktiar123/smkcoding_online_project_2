package com.example.projectdua

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.global_item.*

class GlobalAdapter(private val context: Context, private val items:
List<GlobalItem>, private val listener: (GlobalItem)-> Unit) :
    RecyclerView.Adapter<GlobalAdapter.ViewHolder>() {
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
        fun bindItem(item: GlobalItem, listener: (GlobalItem) -> Unit) {
            txtRegion.text = item.attributes.countryRegion
            txtUserRepo.text = item.attributes.deaths.toString()

            containerView.setOnClickListener { listener(item) }
        }
    }
}