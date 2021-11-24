package com.android.bkd.view_model

import com.android.bkd.R
import com.android.bkd.base.BaseViewModel
import com.android.bkd.ui.home.model.ReservationHistoryModel

class ReservationHistoryViewModel:BaseViewModel() {

    fun getData() = mutableListOf(

        ReservationHistoryModel(
            carLogo = R.drawable.ic_category_car,
            carName = "Fiat Doblo L1H1"
        ),
        ReservationHistoryModel(
            carLogo = R.drawable.ic_category_car,
            carName = "Fiat Doblo L1H1"
        ),

        ReservationHistoryModel(
            carLogo = R.drawable.ic_category_car,
            carName = "Fiat Doblo L1H1"
        ),
        ReservationHistoryModel(
            carLogo = R.drawable.ic_category_car,
            carName = "Fiat Doblo L1H1"
        )
    )
}