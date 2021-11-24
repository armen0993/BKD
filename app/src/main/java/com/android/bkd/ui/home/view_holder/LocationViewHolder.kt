package com.android.bkd.ui.home.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.databinding.ItemLocationBinding

class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val mBinding = ItemLocationBinding.bind(itemView.rootView)

    fun bind(data: String) {
        mBinding.name = data
    }
}