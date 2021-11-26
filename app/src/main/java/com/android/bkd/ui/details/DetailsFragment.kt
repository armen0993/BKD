package com.android.bkd.ui.details

import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentDetailsBinding
import com.android.bkd.view_model.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(R.layout.fragment_details) {

    private val mViewModel by viewModel<DetailsViewModel>()
    override fun getViewModel(): BaseViewModel = mViewModel


}