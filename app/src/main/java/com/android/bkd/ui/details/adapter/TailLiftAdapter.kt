package com.android.bkd.ui.details.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.R
import com.android.bkd.ui.details.model.TailLiftCarModel
import com.android.bkd.ui.details.view_holder.TailLiftViewHolder

class TailLiftAdapter(val context: Context, private val listTailLift: List<TailLiftCarModel>) :
    RecyclerView.Adapter<TailLiftViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TailLiftViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_tail_lift_car, parent, false)
        return TailLiftViewHolder(view)
    }

    override fun onBindViewHolder(holder: TailLiftViewHolder, position: Int) {
        holder.bind(

            capacityTailLift = listTailLift[position].capacityTailLift,
            optionalTailLift = listTailLift[position].optionalTailLift,
            unitOfMeasurement = listTailLift[position].unitOfMeasurement
        )
    }

    override fun getItemCount(): Int {
        return listTailLift.size
    }
}