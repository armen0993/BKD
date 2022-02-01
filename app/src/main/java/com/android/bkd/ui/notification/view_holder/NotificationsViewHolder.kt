package com.android.bkd.ui.notification.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.databinding.ItemNotificationsBinding

class NotificationsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    val mBinding = ItemNotificationsBinding.bind(itemView.rootView)

    val notificationTitle = mBinding.notification
    var dateTitle = mBinding.date
    val hourTitle = mBinding.hour

}