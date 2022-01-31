package com.android.bkd.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentDetailsBinding
import com.android.bkd.extensions.remove
import com.android.bkd.extensions.show
import com.android.bkd.ui.details.adapter.DetailsAdapter
import com.android.bkd.ui.details.adapter.TailLiftAdapter
import com.android.bkd.ui.details.model.DetailsCarModel
import com.android.bkd.view_model.DetailsViewModel
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(R.layout.fragment_details) {

    private val mViewModel by viewModel<DetailsViewModel>()
    private var isDetailsSelected = false
    private var isTailLiftSelected = false
    override fun getViewModel(): BaseViewModel = mViewModel



    @SuppressLint("UnsafeOptInUsageError")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        adapterDetails()
        adapterTailLift()
        mBinding.containerDetails.expand()
        mBinding.containerTailLift.collapse()


        mBinding.carouselRecycler.set3DItem(true)





    }

    private fun initListeners() {
        mBinding.detailAndIcon.setOnClickListener {
            if (isDetailsSelected) hideDetails()
            else showDetails()
        }
        mBinding.tailLiftAndIcon.setOnClickListener {
            if (isTailLiftSelected) hideTailLift()
            else showTailLift()
        }

        mBinding.btnAccessories.setOnClickListener {
            findNavController().navigate(R.id.action_detailsFragment_to_accessoriesFragment)
        }
        mBinding.btnAddDriver.setOnClickListener {
            findNavController().navigate(R.id.action_detailsFragment_to_myDiversFragment)
        }
    }

    private fun showDetails() {
        mBinding.containerDetails.expand()
        isDetailsSelected = true
        mBinding.imgDetails.rotation = 180f
        mBinding.containerDetails.show()
    }

    private fun hideDetails() {
        mBinding.containerDetails.collapse()
        isDetailsSelected =false
        mBinding.containerDetails.remove()
        mBinding.imgDetails.rotation = 360f
    }

    private fun adapterDetails() {
        val list = mViewModel.getDetails()
        val adapterDetails = DetailsAdapter(requireContext(), list)
        mBinding.recyclerDetails.adapter = adapterDetails
    }

    private fun showTailLift() {
        mBinding.containerTailLift.expand()
        isTailLiftSelected = true
        mBinding.imgTailLift.rotation = 180f
        mBinding.containerTailLift.show()
    }

    private fun hideTailLift() {
        mBinding.containerTailLift.collapse()
        isTailLiftSelected =false
        mBinding.containerTailLift.remove()
        mBinding.imgTailLift.rotation = 360f
    }

    private fun adapterTailLift() {
        val listTailLift = mViewModel.getTailLift()
        val adapterTailLift = TailLiftAdapter(requireContext(), listTailLift)
        mBinding.recyclerTailLift.adapter = adapterTailLift

    }


}