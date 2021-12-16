package com.android.bkd.ui.details.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.databinding.ItemTailLiftCarBinding

class TailLiftViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val mBinding =ItemTailLiftCarBinding.bind(itemView.rootView)

    fun bind(optionalTailLift:String,capacityTailLift:Int,unitOfMeasurement:String) {

        mBinding.optionalTailLift.text = optionalTailLift
        mBinding.capacityTailLift.text = capacityTailLift.toString()
        mBinding.unitOfMeasurement.text = unitOfMeasurement
    }
}