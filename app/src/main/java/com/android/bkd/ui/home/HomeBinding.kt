package com.android.bkd.ui.home

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentManager

import com.android.bkd.extensions.hide
import com.android.bkd.extensions.show
import com.android.bkd.utils.DialogUtils
import com.android.bkd.view_model.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

object HomeBinding {
    @BindingAdapter(value = ["app:openCalendar", "app:mViewModel"], requireAll = false)
    @JvmStatic
    fun openCalendar(
        layout: ConstraintLayout,
        fragmentManager: FragmentManager?,
        mViewModel: HomeViewModel
    ) {
        fragmentManager?.let { manager ->
            layout.setOnClickListener {
                DialogUtils.dataPickerDialog(manager) { start, end ->
                    mViewModel.getDate(start, end)
                }
            }
        }
    }

    @BindingAdapter("app:show")
    @JvmStatic
    fun changeVisibility(view: View, visibility: StateFlow<Boolean>) {
        CoroutineScope(Dispatchers.Main).launch {
            visibility.collect {
                if (it) view.show()
                else view.hide()
            }
        }
    }

    @BindingAdapter("app:value")
    @JvmStatic
    fun setText(textView: TextView, text: StateFlow<CharSequence>) {
        CoroutineScope(Dispatchers.Main).launch {
            text.collect {
                textView.text = it
            }
        }
    }
}