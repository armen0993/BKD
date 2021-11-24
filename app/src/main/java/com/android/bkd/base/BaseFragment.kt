package com.android.bkd.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController


abstract class BaseFragment<T : ViewDataBinding>(private var resLayout: Int) : Fragment()  {

    protected lateinit var mBinding: T

    abstract fun getViewModel(): BaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(inflater, resLayout, container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        return mBinding.root
    }

    private fun observeNavigation(viewModel: BaseViewModel) {
        viewModel.navigation.observe(viewLifecycleOwner, {
            it?.getContentIfNotHandled()?.let { command ->
                try {
                    when (command) {
                        is NavigationCommand.To -> findNavController().navigate(
                            command.directions,
                            getExtras()
                        )
                        is NavigationCommand.Back -> findNavController().navigateUp()
                    }
                } catch (e: Exception) {
                    Log.e("navigation", "An error happened: $e")
                }

            }
        })
    }
    open fun getExtras(): FragmentNavigator.Extras = FragmentNavigatorExtras()
}