package com.android.bkd.ui.category.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.databinding.ItemCategoryBinding
import com.android.bkd.models.CategoryModel


class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val mBinding = ItemCategoryBinding.bind(itemView.rootView)

    fun bind(categoryModel: CategoryModel) {
        mBinding.model = categoryModel
    }
}