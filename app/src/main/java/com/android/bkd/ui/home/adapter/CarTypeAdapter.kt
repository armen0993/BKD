package com.android.bkd.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


import com.android.bkd.R
import com.android.bkd.ui.home.model.CarTypeModel
import com.android.bkd.widget.ReflectionImageView
import com.bumptech.glide.Glide


class CarTypeAdapter(private var list: List<CarTypeModel>) :
    RecyclerView.Adapter<CarTypeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ReflectionImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_car_type, parent, false)
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.image).load(list[position].img).into(holder.image)
    }

    fun updateData(list: List<CarTypeModel>) {
        this.list = list
        notifyDataSetChanged()
    }
}