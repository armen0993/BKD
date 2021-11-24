package com.android.bkd.ui.my_reservations.active


import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentActiveReservationsBinding
import com.android.bkd.view_model.ReservationActiveViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ActiveReservationsFragment : BaseFragment<FragmentActiveReservationsBinding>(R.layout.fragment_active_reservations) {
    private val mViewModel by viewModel<ReservationActiveViewModel>()

    override fun getViewModel(): BaseViewModel = mViewModel


}