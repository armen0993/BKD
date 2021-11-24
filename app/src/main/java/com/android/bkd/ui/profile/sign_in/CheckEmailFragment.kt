package com.android.bkd.ui.profile.sign_in

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentCheckEmailBinding
import com.android.bkd.view_model.CheckEmailViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class CheckEmailFragment : BaseFragment<FragmentCheckEmailBinding>(R.layout.fragment_check_email) {
    private val mViewModel by viewModel<CheckEmailViewModel>()
    override fun getViewModel(): BaseViewModel = mViewModel
    private var isSearch = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        mBinding.apply {
            containerOpenEmail.setOnClickListener {
                startAnimate(R.anim.move_to_right)
                lifecycleScope.launch {
                    delay(300)
                    findNavController().navigate(R.id.action_checkEmailFragment_to_createNewPasswordFragment)
                }

            }
              buttonBack.setOnClickListener {
                  activity?.onBackPressed()
              }
        }
    }

    private fun startAnimate(animate: Int) {
        mBinding.labelButtonSignIn.apply {
            val anim = AnimationUtils.loadAnimation(context, animate)
            anim.fillAfter = true
            startAnimation(anim)
            isSearch = !isSearch
        }
    }


}