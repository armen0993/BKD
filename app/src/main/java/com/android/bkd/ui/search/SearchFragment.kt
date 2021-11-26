package com.android.bkd.ui.search

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentSearchBinding
import com.android.bkd.extensions.remove
import com.android.bkd.extensions.show
import com.android.bkd.ui.search.model.FilterModel
import com.android.bkd.ui.search.adapter.CarSearchListSearchAdapter
import com.android.bkd.ui.search.adapter.FilterAdapter
import com.android.bkd.view_model.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    private val mViewModel by viewModel<SearchViewModel>()
    private var isFilter = false
    override fun getViewModel(): BaseViewModel = mViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListeners()
        initRecycler()
        initCarList()
        initTransmissionRecycler()
    }

    private fun initListeners() {
        mBinding.actionBack.setOnClickListener {
            findNavController().popBackStack()
        }
        mBinding.actionEdit.setOnClickListener {
            findNavController().popBackStack()
        }
        mBinding.actionFilter.setOnClickListener {
            if (!isFilter) mBinding.containerFilter.show()
            else mBinding.containerFilter.remove()
            isFilter = !isFilter
        }

    }

    private fun initRecycler() {
        mBinding.listType.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = FilterAdapter().apply {
                updateData(
                    mutableListOf(
                        FilterModel(getString(R.string.tow_bar), R.drawable.ic_bar),
                        FilterModel(getString(R.string.label_double_cable), R.drawable.ic_bus),
                        FilterModel(getString(R.string.label_tail_lift), R.drawable.ic_bus),
                        FilterModel(getString(R.string.label_gps_navigation), R.drawable.ic_gps),
                        FilterModel(getString(R.string.label_air_conditioning), R.drawable.ic_air)
                    )
                )
            }
        }
    }

    private fun initTransmissionRecycler() {
        mBinding.listTransmission.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = FilterAdapter().apply {
                updateData(
                    mutableListOf(
                        FilterModel(getString(R.string.label_manual), R.drawable.ic_manual),
                        FilterModel(getString(R.string.label_automatic), R.drawable.ic_automatic)
                    )
                )
            }
        }
    }

    private fun initCarList() {
        mBinding.carList.adapter = CarSearchListSearchAdapter()
        mBinding.carList.isNestedScrollingEnabled = false
    }

}