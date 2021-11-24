package com.android.bkd.ui.profile.registration

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentCheckYourEmailBinding
import com.android.bkd.view_model.CheckYourEmailViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CheckYourEmailFragment : BaseFragment<FragmentCheckYourEmailBinding>(R.layout.fragment_check_your_email) {
    private val mViewModel by viewModel<CheckYourEmailViewModel>()
    override fun getViewModel(): BaseViewModel = mViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(3000)
            findNavController().navigate(R.id.action_checkYourEmailFragment_to_emailVerifiedSuccessFragment)
        }
    }

}