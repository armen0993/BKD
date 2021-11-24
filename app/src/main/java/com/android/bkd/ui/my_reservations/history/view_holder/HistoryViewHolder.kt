package com.android.bkd.ui.my_reservations.history.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

import com.android.bkd.databinding.ItemHistoryReservationBinding
import com.android.bkd.ui.home.model.ReservationHistoryModel

class HistoryViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    val mBinding = ItemHistoryReservationBinding.bind(itemView.rootView)

    fun bind(reservationHistoryModel: ReservationHistoryModel) {
        mBinding.model = reservationHistoryModel
    }}