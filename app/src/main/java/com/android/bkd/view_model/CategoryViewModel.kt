package com.android.bkd.view_model

import com.android.bkd.R
import com.android.bkd.base.BaseViewModel
import com.android.bkd.ui.category.model.CategoryModel

class CategoryViewModel:BaseViewModel() {

    fun getData() = mutableListOf(
        CategoryModel(
            image = R.drawable.ic_category_car,
            carName = "Fiat Doblo L1H1"
        ),
        CategoryModel(
            image = R.drawable.ic_category_car,
            carName = "Fiat Doblo L1H1"
        ),
        CategoryModel(
            image = R.drawable.ic_category_car,
            carName = "Fiat Doblo L1H1"
        ),
        CategoryModel(
            image = R.drawable.ic_category_car,
            carName = "Fiat Doblo L1H1"
        ),
        CategoryModel(
            image = R.drawable.ic_category_car,
            carName = "Fiat Doblo L1H1"
        )
    )
}