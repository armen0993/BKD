package com.android.bkd.view_model

import com.android.bkd.base.BaseViewModel
import com.android.bkd.ui.my_drivers.model.MyDriversModel

class MyDriversViewModel :BaseViewModel(){

    fun getListDrivers() = mutableListOf(
        MyDriversModel("Arkadi","Tadevosyan")
    )
}