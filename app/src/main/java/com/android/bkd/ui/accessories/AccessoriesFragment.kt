package com.android.bkd.ui.accessories

import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentAccessoriesBinding
import com.android.bkd.view_model.AccessoriesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccessoriesFragment : BaseFragment<FragmentAccessoriesBinding>(R.layout.fragment_accessories) {

    private val mViewModel by viewModel<AccessoriesViewModel>()
    override fun getViewModel(): BaseViewModel = mViewModel

}