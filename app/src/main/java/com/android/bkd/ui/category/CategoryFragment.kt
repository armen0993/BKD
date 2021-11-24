package com.android.bkd.ui.category

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentCategoryBinding
import com.android.bkd.ui.category.adapter.CategoryAdapter
import com.android.bkd.view_model.CategoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category) {
    private val mViewModel by viewModel<CategoryViewModel>()
    override fun getViewModel(): BaseViewModel = mViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        mBinding.listVans.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mBinding.listVans.adapter = CategoryAdapter().apply {
            setData(mViewModel.getData())
        }

        mBinding.listDoubleCabs.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mBinding.listDoubleCabs.adapter = CategoryAdapter().apply {
            setData(mViewModel.getData())
        }

        mBinding.listBoxTrucks.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mBinding.listBoxTrucks.adapter = CategoryAdapter().apply {
            setData(mViewModel.getData())
        }

        mBinding.listTrucks.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mBinding.listTrucks.adapter = CategoryAdapter().apply {
            setData(mViewModel.getData())
        }

        mBinding.listFrigoVans.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mBinding.listFrigoVans.adapter = CategoryAdapter().apply {
            setData(mViewModel.getData())
        }
    }

}