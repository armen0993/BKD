package com.android.bkd.ui.my_drivers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.R
import com.android.bkd.ui.my_drivers.model.MyDriversModel
import com.android.bkd.ui.my_drivers.view_holder.MyDriversViewHolder

class MyDriversAdapter(private val context: Context,private val listData:MutableList<MyDriversModel>) : RecyclerView.Adapter<MyDriversViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDriversViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_my_drivers, parent, false)
        return MyDriversViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyDriversViewHolder, position: Int) {
        holder.bind(
            name = listData[position].name,
            surName = listData[position].surName

        )

    }

    override fun getItemCount(): Int = listData.size
}