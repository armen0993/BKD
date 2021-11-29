package com.android.bkd.view_model

import com.android.bkd.R
import com.android.bkd.base.BaseViewModel
import com.android.bkd.ui.details.model.DetailsCarModel

class DetailsViewModel : BaseViewModel() {

    fun getDetails() = listOf(
        DetailsCarModel(R.drawable.ic_sitter, "3"),
        DetailsCarModel(R.drawable.ic_fuel_type, "Diesel"),
        DetailsCarModel(R.drawable.ic_transmission, "Manual"),
        DetailsCarModel(R.drawable.ic_engine, "95 Kw / 130 Pk"),
        DetailsCarModel(R.drawable.ic_euronorm, "7"),
        DetailsCarModel(R.drawable.ic_car_size, "5.91 x 2.42 x 2.82 m"),
        DetailsCarModel(R.drawable.ic_car_length, "1.20 m"),
        DetailsCarModel(R.drawable.ic_conditionair, "Conditioning"),
        DetailsCarModel(R.drawable.ic_arrow_gps, "GPS"),
        DetailsCarModel(R.drawable.ic_tow_bar_gray, "Tow Bar"),
        DetailsCarModel(R.drawable.ic_door, "Slide door")
    )


}