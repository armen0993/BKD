package com.android.bkd.ui.my_drivers.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.databinding.ItemMyDriversBinding

class MyDriversViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    val mBinding = ItemMyDriversBinding.bind(itemView.rootView)

    fun bind(name:String,surName:String){
        mBinding.nameDriver.text = name
        mBinding.surnameDriver.text = surName

    }
}