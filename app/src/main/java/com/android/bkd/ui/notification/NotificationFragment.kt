package com.android.bkd.ui.notification

import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentNotificationBinding
import com.android.bkd.view_model.NotificationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class NotificationFragment : BaseFragment<FragmentNotificationBinding>(R.layout.fragment_notification) {
    private val mViewModel by viewModel<NotificationViewModel>()
    override fun getViewModel(): BaseViewModel = mViewModel


}