package com.android.bkd.ui.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.android.bkd.R
import com.android.bkd.ui.category.model.CategoryModel
import com.android.bkd.ui.category.view_holder.CategoryViewHolder

class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {

    private val mItems: MutableList<CategoryModel> = mutableListOf()

    fun setData(data: List<CategoryModel>) {
        mItems.clear()
        mItems.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category, parent, false)
        )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(mItems[position])
        holder.mBinding.imgCar.load(R.drawable.ic_category_car)
    }

    override fun getItemCount(): Int = mItems.size
}