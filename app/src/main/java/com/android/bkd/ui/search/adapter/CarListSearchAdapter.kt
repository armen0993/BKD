package com.android.bkd.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.android.bkd.R
import com.android.bkd.ui.home.view_holder.CarListViewHolder

class CarListSearchAdapter : RecyclerView.Adapter<CarListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder =
        CarListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_car_list, parent, false)
        )

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 10
}