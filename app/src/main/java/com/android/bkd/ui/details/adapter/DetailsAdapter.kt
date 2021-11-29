package com.android.bkd.ui.details.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.R
import com.android.bkd.ui.details.model.DetailsCarModel
import com.android.bkd.ui.details.view_holder.DetailsViewHolder

class DetailsAdapter(val context: Context, private val listDetails: List<DetailsCarModel>) :
    RecyclerView.Adapter<DetailsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val itemView =
            LayoutInflater.from(context).inflate(R.layout.item_details_car, parent, false)
        return DetailsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.bind(
            image = listDetails[position].image,
            detail = listDetails[position].detail
        )
    }

    override fun getItemCount(): Int {
        return listDetails.size

    }
}