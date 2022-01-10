package com.android.bkd.ui.accessories.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.R
import com.android.bkd.ui.accessories.model.AccessoriesModel
import com.android.bkd.ui.accessories.view_holder.AccessoriesViewHolder

class AccessoriesAdapter(val context: Context, private val listAccessories:List<AccessoriesModel>):RecyclerView.Adapter<AccessoriesViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccessoriesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_accessories,parent,false)
        return AccessoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: AccessoriesViewHolder, position: Int) {
       holder.bind(
           iconAccessories = listAccessories[position].iconAccessories,
           priceAccessories = listAccessories[position].priceAccessories,
       )
        holder.pieceAccessories()

    }

    override fun getItemCount(): Int {
     return listAccessories.size
    }


}