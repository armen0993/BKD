package com.android.bkd.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.bkd.base.BaseViewModel
import com.android.bkd.ui.notification.model.NotificationsModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NotificationViewModel :BaseViewModel(){

   private val  _sizeNotify:MutableLiveData<Int> = MutableLiveData()
   val sizeNotify:LiveData<Int> = _sizeNotify

   fun listNotifications() = mutableListOf(
       NotificationsModel("Notifications can be of various types but for the user it is only the message text. ","20/03/21","15:30"),
       NotificationsModel("Notifications can be of various types but for the user it is only the message text. ","15/01/21","10:30"),
       NotificationsModel("Notifications can be of various types but for the user it is only the message text that is different in meaning and it expresses the Notification type itself. ","20/03/21","15:30"),
       NotificationsModel("Notifications can be of various types but for the user it is only the message text. ","20/03/21","13:00"),
       NotificationsModel("Notifications can be of various types but for the user it is only the message text. ","20/03/21","15:30"),
       NotificationsModel("Notifications can be of various types but for the user it is only the message text. ","20/03/21","14:30"),
       NotificationsModel("Notifications can be of various types but for the user it is only the message text that is different in meaning and it expresses the Notification type itself. ","20/03/21","15:30"),
       NotificationsModel("Notifications can be of various types but for the user it is only the message text. ","20/03/21","15:30"),
       NotificationsModel("Notifications can be of various types but for the user it is only the message text. ","20/03/21","15:30"),
       NotificationsModel("Notifications can be of various types but for the user it is only the message text. ","15/01/21","15:30"),
       NotificationsModel("Notifications can be of various types but for the user it is only the message text. ","20/03/21","17:30"),
       NotificationsModel("Notifications can be of various types but for the user it is only the message text. ","15/01/21","15:00"),
       NotificationsModel("Notifications can be of various types but for the user it is only the message text that is different in meaning and it expresses the Notification type itself. ","20/03/21","15:30"),
    )
   fun sizeNotifications(sizeList:Int){

       _sizeNotify.postValue(sizeList)

   }
}