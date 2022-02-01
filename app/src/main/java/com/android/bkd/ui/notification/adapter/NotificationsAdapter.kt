package com.android.bkd.ui.notification.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.R
import com.android.bkd.ui.notification.model.NotificationsModel
import com.android.bkd.ui.notification.view_holder.NotificationsViewHolder

class NotificationsAdapter(val context: Context, private val listData: MutableList<NotificationsModel>) :
    RecyclerView.Adapter<NotificationsViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun deleteItem(position: Int){
        listData.removeAt(position)
        notifyDataSetChanged()
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_notifications, parent, false)
        return NotificationsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationsViewHolder, position: Int) {
        val currentData = listData[position]

        holder.dateTitle.text = currentData.date
        holder.notificationTitle.text = currentData.notification
        holder.hourTitle.text = currentData.hour

    }

    override fun getItemCount() = listData.size

}
