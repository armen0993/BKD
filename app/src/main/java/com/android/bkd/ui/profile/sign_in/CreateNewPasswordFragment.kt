package com.android.bkd.ui.profile.sign_in

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentCreateNewPasswordBinding
import com.android.bkd.view_model.CreateNewPasswordViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateNewPasswordFragment :
    BaseFragment<FragmentCreateNewPasswordBinding>(R.layout.fragment_create_new_password) {
    private val mViewModel by viewModel<CreateNewPasswordViewModel>()
    override fun getViewModel(): BaseViewModel = mViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
initListeners()
    }
    private fun initListeners() {
        mBinding.apply {
            buttonBack.setOnClickListener {
                activity?.onBackPressed()
            }
            resetPassword.setOnClickListener {
                findNavController().navigate(R.id.action_createNewPasswordFragment_to_profileFragment)
            }
        }

    }

}