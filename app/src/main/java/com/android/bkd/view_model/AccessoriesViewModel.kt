package com.android.bkd.view_model

import com.android.bkd.R
import com.android.bkd.base.BaseViewModel
import com.android.bkd.ui.accessories.model.AccessoriesModel

class AccessoriesViewModel:BaseViewModel() {

   fun getListAccessories() = listOf(
       AccessoriesModel( R.drawable.ic_accessories,"652"),
       AccessoriesModel( R.drawable.ic_accessories,"3.0"),
   )

}