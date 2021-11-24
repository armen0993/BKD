package com.android.bkd.ui.my_reservations.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


import com.android.bkd.ui.my_reservations.active.ActiveReservationsFragment
import com.android.bkd.ui.my_reservations.history.ReservationHistoryFragment
import com.google.android.gms.common.util.CollectionUtils.listOf


class ViewPagerReservationAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val listFragment = listOf(
        ActiveReservationsFragment(),
        ReservationHistoryFragment()
    )

    override fun getItemCount(): Int {
        return listFragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return listFragment[position]

    }
}