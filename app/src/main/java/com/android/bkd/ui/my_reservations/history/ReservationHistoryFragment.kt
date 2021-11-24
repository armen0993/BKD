package com.android.bkd.ui.my_reservations.history

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentReservationHistoryBinding
import com.android.bkd.ui.my_reservations.history.adapter.HistoryAdapter
import com.android.bkd.view_model.ReservationHistoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ReservationHistoryFragment : BaseFragment<FragmentReservationHistoryBinding>(R.layout.fragment_reservation_history) {
    private val mViewModel by viewModel<ReservationHistoryViewModel>()

    override fun getViewModel(): BaseViewModel = mViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        mBinding.recycler.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mBinding.recycler.adapter = HistoryAdapter().apply {
            setData(mViewModel.getData())
        }
    }


}