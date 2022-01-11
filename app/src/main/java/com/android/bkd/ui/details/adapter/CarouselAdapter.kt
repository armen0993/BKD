package com.android.bkd.ui.details.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.ui.details.view_holder.CarouselViewHolder

class CarouselAdapter(private val context:Context):RecyclerView.Adapter<CarouselViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view = LayoutInflater.from(context).inflate()
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}