package com.example.projectdua

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.indonesia_item.*

class IndonesiaAdapter (private val context: Context, private val items: List<IndonesiaItem>,
                        private val listener: (IndonesiaItem)-> Unit) : RecyclerView.Adapter<IndonesiaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(context, LayoutInflater.from(context).inflate(R.layout.indonesia_item,
            parent, false))
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position), listener)
    }
    class ViewHolder(val context: Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item: IndonesiaItem, listener: (IndonesiaItem) -> Unit) {
            txtName.text = item.name
            txtPositif.text = item.positif
            txtDirawat.text = item.dirawat
            txtSembuh.text = item.sembuh
            txtMeninggal.text = item.meninggal

            containerView.setOnClickListener { listener(item) }
        }
    }
}