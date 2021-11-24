package com.android.bkd.ui.my_reservations

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentMyReservationsBinding
import com.android.bkd.ui.my_reservations.adapter.ViewPagerReservationAdapter
import com.android.bkd.view_model.MyReservationsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyReservationsFragment : BaseFragment<FragmentMyReservationsBinding>(R.layout.fragment_my_reservations) {
    private val mViewModel by viewModel<MyReservationsViewModel>()
    override fun getViewModel(): BaseViewModel =mViewModel

    private var clickButton = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createViewPager()
        initListeners()
    }

    private fun  createViewPager(){
        mBinding.viewPagerReservations.adapter=
            ViewPagerReservationAdapter(requireActivity().supportFragmentManager,lifecycle)
        mBinding.viewPagerReservations.isUserInputEnabled= false
    }

    private fun initListeners() {
        mBinding.labelReservationHistory.setOnClickListener {
            if (clickButton){
                startAnimate(R.anim.move_to_right)
                mBinding.buttonLabelActiveReservation.text =
                    resources.getText(R.string.reservations_history)
                mBinding.viewPagerReservations.currentItem = 1
                clickButton= false
            }
        }
        mBinding.buttonLabelActiveReservation.setOnClickListener {
            if (!clickButton){
                startAnimate(R.anim.move_to_left)
                mBinding.buttonLabelActiveReservation.text =
                    resources.getText(R.string.active_reservations)
                mBinding.viewPagerReservations.currentItem=0
                clickButton = true
            }
        }
    }

    private fun startAnimate(animate: Int) {
        mBinding.buttonLabelActiveReservation.apply {
            val anim = AnimationUtils.loadAnimation(context, animate)
            anim.fillAfter = true
            startAnimation(anim)
        }
    }

}