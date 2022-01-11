package com.android.bkd.module_view_model

import com.android.bkd.view_model.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { MainViewModel() }
    viewModel { HomeViewModel() }
    viewModel { MyReservationsViewModel() }
    viewModel { CategoryViewModel() }
    viewModel { NotificationViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { SearchViewModel() }
    viewModel { ReservationActiveViewModel() }
    viewModel { ReservationHistoryViewModel() }
    viewModel { RegistrationViewModel() }
    viewModel { SignInViewModel() }
    viewModel { CheckYourEmailViewModel() }
    viewModel { EmailVerifiedSuccessViewModel() }
    viewModel { CheckEmailViewModel() }
    viewModel { CreateNewPasswordViewModel() }
    viewModel { EnterEmailViewModel() }
    viewModel { DetailsViewModel() }
    viewModel { AccessoriesViewModel() }
    viewModel { MyDriversViewModel() }

}