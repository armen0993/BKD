package com.android.bkd.ui.my_drivers

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentMyDiversBinding
import com.android.bkd.ui.my_drivers.adapter.MyDriversAdapter
import com.android.bkd.view_model.MyDriversViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyDiversFragment : BaseFragment<FragmentMyDiversBinding>(R.layout.fragment_my_divers) {


    val mViewModel by viewModel<MyDriversViewModel>()

    override fun getViewModel(): BaseViewModel = mViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }


    private fun initAdapter(){
        mBinding.recyclerMyDrivers.adapter = MyDriversAdapter(requireContext(),mViewModel.getListDrivers())
        mBinding.recyclerMyDrivers.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }




}