package com.juliensacre.testmsf.ui.trombi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.juliensacre.testmsf.R
import com.juliensacre.testmsf.domain.trombi.DevModel
import kotlinx.android.synthetic.main.item_dev.view.*

class TrombiAdapter(val onClick: (DevModel) -> Unit) :
    RecyclerView.Adapter<TrombiAdapter.ViewHolder>() {

    private var values: MutableList<DevModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dev, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.itemName.text = item.name
        holder.itemDescription.text = item.description
        holder.itemPicture.load(item.picture){
            crossfade(true)
            placeholder(R.drawable.placeholder_picture_dev)
            transformations(CircleCropTransformation())
        }
        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

    override fun getItemCount(): Int = values.size

    fun updateValues(items: List<DevModel>) {
        values = items.toMutableList()
        notifyDataSetChanged()
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val itemName: TextView = view.tv_devItem_name
        val itemDescription: TextView = view.tv_devItem_description
        val itemPicture: ImageView = view.iv_devItem_photo
    }
}