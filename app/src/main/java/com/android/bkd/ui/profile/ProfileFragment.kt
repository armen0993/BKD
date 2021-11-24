package com.android.bkd.ui.profile

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentProfileBinding
import com.android.bkd.view_model.ProfileViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {
    private val mViewModel by viewModel<ProfileViewModel>()
    override fun getViewModel(): BaseViewModel = mViewModel

    private var isSearch = false
    private var checkerPassword = false


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        inputTextChecker()

    }

    private fun initListeners() {
        mBinding.apply {
//            containerSignIn.setOnClickListener {
//                startAnimate(R.anim.move_to_right)
//                if (checkerPassword) {
//                    lifecycleScope.launch {
//                        delay(300)
//                        findNavController().navigate(R.id.action_profileFragment_to_enterEmailFragment)
//                    }
//                }
//            }

            labelForgotPassword.setOnClickListener {
                findNavController().navigate(R.id.action_profileFragment_to_enterEmailFragment)
            }
            register.setOnClickListener {
                findNavController().navigate(R.id.action_profileFragment_to_registrationFragment)
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

    private fun inputTextChecker() {
        mBinding.password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                when {
                    mBinding.password.text.isNullOrEmpty() -> {
                        mBinding.passwordContainer.error = "Incorrect password"

                    }
                    else -> {
                        mBinding.passwordContainer.error = null
                        checkerPassword = !checkerPassword
                    }
                }
            }

        })
    }
}