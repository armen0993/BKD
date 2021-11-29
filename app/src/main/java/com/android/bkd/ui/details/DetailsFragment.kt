package com.android.bkd.ui.details

import android.os.Bundle
import android.view.View
import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentDetailsBinding
import com.android.bkd.extensions.remove
import com.android.bkd.extensions.show
import com.android.bkd.ui.details.adapter.DetailsAdapter
import com.android.bkd.ui.details.model.DetailsCarModel
import com.android.bkd.view_model.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(R.layout.fragment_details) {

    private val mViewModel by viewModel<DetailsViewModel>()
    private var isDetailsSelected = false
    override fun getViewModel(): BaseViewModel = mViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        adapterDetails()
        mBinding.containerDetails.collapse()
    }


    private fun initListeners() {
        mBinding.details.setOnClickListener {
            if (isDetailsSelected) hideDetails()
            else showDetails()
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


}