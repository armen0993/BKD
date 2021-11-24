package com.android.bkd.ui.profile.registration

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentRegistrationBinding
import com.android.bkd.view_model.RegistrationViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class RegistrationFragment : BaseFragment<FragmentRegistrationBinding>(R.layout.fragment_registration) {
    private val mViewModel by viewModel<RegistrationViewModel>()
    override fun getViewModel(): BaseViewModel =mViewModel
    private var isSearch = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        mBinding.apply {
            containerContinue.setOnClickListener {
                startAnimate(R.anim.move_to_right)
                lifecycleScope.launch {
                    delay(300)
                    findNavController().navigate(R.id.action_registrationFragment_to_checkYourEmailFragment)
                }
            }
        }
    }

    private fun startAnimate(animate: Int) {
        mBinding.labelButtonContinue.apply {
            val anim = AnimationUtils.loadAnimation(context, animate)
            anim.fillAfter = true
            startAnimation(anim)
            isSearch = !isSearch
        }
    }
}