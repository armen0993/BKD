package com.android.bkd.ui.details.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.databinding.ItemDetailsCarBinding

class DetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val mBinding = ItemDetailsCarBinding.bind(itemView.rootView)

    fun bind(image: Int, detail: String) {
        mBinding.imgDetails.setImageResource(image)
        mBinding.labelDetails.text = detail
    }

}