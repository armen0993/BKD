package com.android.bkd.ui.my_reservations.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load

import com.android.bkd.R
import com.android.bkd.ui.my_reservations.history.model.ReservationHistoryModel
import com.android.bkd.ui.my_reservations.history.view_holder.HistoryViewHolder

class HistoryAdapter:RecyclerView.Adapter<HistoryViewHolder>() {

    private val mItems: MutableList<ReservationHistoryModel> = mutableListOf()
    fun setData(data: List<ReservationHistoryModel>) {
        mItems.clear()
        mItems.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HistoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_history_reservation, parent, false)
        )


    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(mItems[position])
        holder.mBinding.imgLogoCar.load(R.drawable.ic_fiat)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }


}