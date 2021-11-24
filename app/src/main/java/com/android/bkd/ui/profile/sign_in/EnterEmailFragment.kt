package com.android.bkd.ui.profile.sign_in

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentEnterEmailBinding
import com.android.bkd.view_model.EnterEmailViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class EnterEmailFragment : BaseFragment<FragmentEnterEmailBinding>(R.layout.fragment_enter_email) {

    private val mViewModel by viewModel<EnterEmailViewModel>()
    private var isSearch = false
    override fun getViewModel(): BaseViewModel = mViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        mBinding.apply {
            containerSend.setOnClickListener {
                startAnimate(R.anim.move_to_right)
                lifecycleScope.launch {
                    delay(300)
                findNavController().navigate(R.id.action_enterEmailFragment_to_checkEmailFragment)
                            }
        }}
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