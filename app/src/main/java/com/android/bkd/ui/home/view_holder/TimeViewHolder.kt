package com.android.bkd.ui.home.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.databinding.ItemTimeBinding


class TimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mBinding = ItemTimeBinding.bind(itemView.rootView)

    fun bind(time: String) {
        mBinding.time = time
    }
}