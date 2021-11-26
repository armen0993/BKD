package com.android.bkd.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.R
import com.android.bkd.ui.search.view_holder.CarSearchListViewHolder

class CarSearchListSearchAdapter : RecyclerView.Adapter<CarSearchListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarSearchListViewHolder =
        CarSearchListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_search_car_list, parent, false)
        )


    override fun getItemCount(): Int = 10
    override fun onBindViewHolder(holder: CarSearchListViewHolder, position: Int) {

    }
}