package com.android.bkd.ui.search.view_holder

import android.view.View
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.R
import com.android.bkd.databinding.ItemCarListBinding
import com.android.bkd.databinding.ItemSearchCarListBinding


class CarSearchListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mBinding = ItemSearchCarListBinding.bind(itemView.rootView)

    fun initListener(){
        mBinding.labelDetails.setOnClickListener {
            Navigation.findNavController(itemView).navigate(R.id.action_searchFragment_to_detailsFragment)
        }
    }
}