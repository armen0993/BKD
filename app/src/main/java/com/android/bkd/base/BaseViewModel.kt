package com.android.bkd.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections

abstract class BaseViewModel: ViewModel() {

    // FOR ERROR HANDLER
    protected val _snackBarError = MutableLiveData<Event<Any>>()
    val snackBarError: LiveData<Event<Any>> get() = _snackBarError

    // FOR NAVIGATION
    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>> = _navigation

    fun navigate(directions: NavDirections) {
        _navigation.value = Event(NavigationCommand.To(directions))
    }
}