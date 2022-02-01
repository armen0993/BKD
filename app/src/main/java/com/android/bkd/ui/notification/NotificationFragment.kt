package com.android.bkd.ui.notification

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentNotificationBinding
import com.android.bkd.extensions.hide
import com.android.bkd.extensions.show
import com.android.bkd.ui.notification.adapter.NotificationsAdapter
import com.android.bkd.view_model.NotificationViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel



class NotificationFragment :
    BaseFragment<FragmentNotificationBinding>(R.layout.fragment_notification) {
    private val mViewModel by sharedViewModel<NotificationViewModel>()
    override fun getViewModel(): BaseViewModel = mViewModel
    private var checkerState = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        initRecycler()

        mViewModel.sizeNotifications(mViewModel.listNotifications().size)



    }


    private fun initListeners() {
        mBinding.btnSelect.setOnClickListener {
            select()
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables", "ResourceAsColor")
    private fun select() {
       // mBinding.textBtnSelect.setTextColor(R.color.color_yellow)
        if (checkerState){
            mBinding.textBtnSelect.text = resources.getText(R.string.select)
            mBinding.textBtnSelectAll.hide()
        }else{
            mBinding.textBtnSelect.text = resources.getText(R.string.cancel)
            mBinding.textBtnSelectAll.show()
        }

        checkerState = !checkerState

    }

    private fun initRecycler(){
        val adapterNotifications = NotificationsAdapter(requireContext(),mViewModel.listNotifications())

        val swipeToDeleteCallBack = object : SwipeToDeleteCallBack() {

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when(direction){
                    ItemTouchHelper.LEFT->{
                        adapterNotifications.deleteItem(viewHolder.adapterPosition)

                    }
                    ItemTouchHelper.RIGHT->{

                    }
                }


            }

        }

        val touchHelper = ItemTouchHelper(swipeToDeleteCallBack)
        touchHelper.attachToRecyclerView(mBinding.recyclerNotifications)

        mBinding.recyclerNotifications.adapter = adapterNotifications
        mBinding.recyclerNotifications.layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

    }

}

