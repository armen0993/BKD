package com.android.bkd.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.android.bkd.R
import com.android.bkd.base.BaseFragment
import com.android.bkd.base.BaseViewModel
import com.android.bkd.databinding.FragmentHomeBinding
import com.android.bkd.extensions.remove
import com.android.bkd.extensions.show
import com.android.bkd.ui.home.adapter.CarListAdapter
import com.android.bkd.ui.home.adapter.CarTypeAdapter
import com.android.bkd.ui.home.adapter.LocationAdapter
import com.android.bkd.ui.home.adapter.TimeAdapter
import com.android.bkd.ui.home.model.CarTypeModel
import com.android.bkd.utils.Validation
import com.android.bkd.view_model.HomeViewModel
import com.android.bkd.widget.CarouselLayoutManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val mViewModel by viewModel<HomeViewModel>()
    override fun getViewModel(): BaseViewModel = mViewModel
    private var isSearch = false
    private var isPickUpTime: Boolean = false
    private var isReturnTime: Boolean = false
    private var isPickUpLocation: Boolean = false
    private var isReturnLocation: Boolean = false
    private var isPickUpSelected = false
    private var isReturnSelected = false
    private var checkerErrors = false
    private lateinit var textPickUpLocation: String
    private lateinit var textReturnLocation: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textPickUpLocation = mBinding.textPickUpLocation.text.toString()
        textReturnLocation = mBinding.textReturnLocation.text.toString()
        mBinding.fragment = this
        mBinding.mViewModel = mViewModel
        initListeners()
        initRecycler()
        initCarList()
        initTime()
        mBinding.containerPickUpTime.collapse()
        mBinding.containerReturnTime.collapse()
        mBinding.containerMapLocation.collapse()
        initLocationRecycler()
        checkerPositionButton()

    }


    @SuppressLint("UseCompatLoadingForDrawables")
    private fun checkerErrors(): Boolean {
        when {
            mBinding.textStartDate.text.isEmpty() -> {
                mBinding.layoutDate.background =
                    resources.getDrawable(R.drawable.background_field_error, null)
                checkerErrors = !checkerErrors
            }
            mBinding.textPickUpLocation.text.isEmpty() -> {
                checkerErrors = !checkerErrors
            }
            checkerPickUpLocation() -> {
                mBinding.layoutPickUpLocation.background =
                    resources.getDrawable(R.drawable.background_field_error, null)
                checkerErrors = !checkerErrors
            }
            checkerReturnLocation() -> {
                mBinding.layoutReturnLocation.background =
                    resources.getDrawable(R.drawable.background_field_error, null)
                checkerErrors = !checkerErrors
            }
        }
        return checkerErrors
    }

    private fun checkerPickUpLocation(): Boolean {
        var checkerPickUpLocation = false
        if (mBinding.textPickUpLocation.text == textPickUpLocation) {
            checkerPickUpLocation = true
        }
        return checkerPickUpLocation
    }

    private fun checkerReturnLocation(): Boolean {
        var checkerReturnLocation = false
        if (mBinding.textReturnLocation.text == textReturnLocation) {
            checkerReturnLocation = true
        }
        return checkerReturnLocation
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    private fun initErrors() {
        mBinding.layoutDate.background = resources.getDrawable(R.drawable.background_field, null)
        mBinding.layoutPickUpLocation.background =
            resources.getDrawable(R.drawable.background_field, null)
        mBinding.layoutReturnLocation.background =
            resources.getDrawable(R.drawable.background_field, null)

        if (checkerErrors()) {
            mBinding.labelError.show()
            mBinding.labelError.text = Validation.ERROR_EDIT_TEXT.errorMassage
            if (isSearch) {
                mBinding.containerButton.transitionToStart()
                isSearch= !isSearch
            }
            checkerErrors = !checkerErrors
        } else {
            mBinding.labelError.remove()
            // mViewModel.navigate(HomeFragmentDirections.actionHomeFragmentToSearchFragment())
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }

    }

    private fun checkerPositionButton() {
        mBinding.containerButton.setTransitionListener(object : TransitionAdapter() {

            override fun onTransitionCompleted(
                motionLayout: MotionLayout?,
                currentId: Int
            ) {
                when (currentId) {
                    R.id.end -> {
                        isSearch = !isSearch
                    }
                }
                initErrors()
            }
        })
    }

    private fun initListeners() {

        mBinding.ImagePickUp.setOnClickListener {
            if (isPickUpTime) hidePickUpTime()
            else showPickUpTime()
        }
        mBinding.imageReturn.setOnClickListener {
            if (isReturnTime) hideReturnTime()
            else showReturnTime()
        }
        mBinding.layoutPickUpLocation.setOnClickListener {
            if (!isReturnSelected) {
                showLocationSheet()
            }
        }

        mBinding.layoutReturnLocation.setOnClickListener {
            if (!isPickUpSelected) {
                showLocation()
            }
        }

    }

    private fun showLocationSheet() {
        if (!isPickUpLocation) {
            isPickUpSelected = true
            mBinding.containerMapLocation.expand()
            mBinding.imagePickUpLocation.animate().rotation(180f).setDuration(500).start()
        } else {
            isPickUpSelected = false
            mBinding.containerMapLocation.collapse()
            mBinding.imagePickUpLocation.animate().rotation(0f).setDuration(500).start()
        }
        isPickUpLocation = !isPickUpLocation
    }

    private fun showLocation() {
        if (!isReturnLocation) {
            isReturnSelected = true
            mBinding.containerMapLocation.expand()
            mBinding.imageReturnLocation.animate().rotation(180f).setDuration(500).start()
        } else {
            isReturnSelected = false
            mBinding.containerMapLocation.collapse()
            mBinding.imageReturnLocation.animate().rotation(0f).setDuration(500).start()
        }
        isReturnLocation = !isReturnLocation
    }


    private fun initCarList() {
        mBinding.carList.adapter = CarListAdapter()
        mBinding.carList.isNestedScrollingEnabled = false
    }

    private fun initRecycler() {
        val list = mutableListOf<CarTypeModel>()
        list.add(CarTypeModel(R.layout.item_car_list, "Adastra"))
        list.add(CarTypeModel(R.drawable.ic_vans_yellow, "Beach Bum"))
        list.add(CarTypeModel(R.drawable.ic_vans_yellow, "Dark Phoenix"))
        list.add(CarTypeModel(R.drawable.ic_vans_yellow, "Glass"))
        list.add(CarTypeModel(R.drawable.ic_vans_yellow, "Her Smell"))


        val adapter = CarTypeAdapter(list)

        mBinding.carTypeList.adapter = adapter
        mBinding.carTypeList.set3DItem(true)
        mBinding.carTypeList.setAlpha(true)
        val carouselLayoutManager = mBinding.carTypeList.getCarouselLayoutManager()
        val currentlyCenterPosition = mBinding.carTypeList.getSelectedPosition()

        mBinding.carTypeList.setItemSelectListener(object : CarouselLayoutManager.OnSelected {
            override fun onItemSelected(position: Int) {
                list[1].img.rem(R.drawable.ic_vans_yellow)
            }
        })
    }

    private fun showPickUpTime() {
        mBinding.ImagePickUp.load(R.drawable.ic_pick_up_time_default)
        isPickUpTime = true
        mBinding.containerPickUpTime.expand()
    }

    private fun hidePickUpTime() {
        mBinding.ImagePickUp.load(R.drawable.ic_pick_up_car)
        isPickUpTime = false
        mBinding.containerPickUpTime.collapse()
    }

    private fun showReturnTime() {
        mBinding.imageReturn.load(R.drawable.ic_return_car_default)
        isReturnTime = true
        mBinding.containerReturnTime.expand()
    }

    private fun hideReturnTime() {
        mBinding.imageReturn.load(R.drawable.ic_return_car)
        isReturnTime = false
        mBinding.containerReturnTime.collapse()
    }

    private fun initTime() {
        lifecycleScope.launch {
            mViewModel.pickUpTime.collect() { data ->
                initTimeRecycler(mBinding.listPickUpTime, data, true)
                initTimeRecycler(mBinding.listReturnTime, data, false)
            }
        }
    }

    private fun initTimeRecycler(
        recyclerview: RecyclerView,
        data: List<String>,
        isPickUp: Boolean
    ) {
        recyclerview.apply {
            adapter = TimeAdapter(if (isPickUp) ::pickUpListener else ::returnListener).apply {
                updateData(data)
            }
        }
    }

    private fun pickUpListener(time: String) {
        hidePickUpTime()
        mBinding.textPickUp.remove()
        mBinding.textStartTime.show()
        mBinding.textStartTime.text = time
    }

    private fun returnListener(time: String) {
        hideReturnTime()
        mBinding.textReturnTime.remove()
        mBinding.textEndTime.show()
        mBinding.textEndTime.text = time
        mBinding.textUnderTime.show()
    }

    private fun initLocationRecycler() {
        mBinding.listLocation.apply {
            adapter = LocationAdapter(::selectLocation, ::openMap).apply {
                updateData(
                    mutableListOf(
                        getString(R.string.label_bkd_office),
                        getString(R.string.label_parking_1),
                        getString(R.string.label_parking_2)
                    )
                )
            }
        }
    }

    private fun openMap() {
        if (isPickUpSelected) {
            isPickUpSelected = !isPickUpSelected
            mBinding.imagePickUpLocation.animate().rotation(0f).setDuration(500).start()
            isPickUpLocation = !isPickUpLocation
        } else {
            isReturnSelected = !isReturnSelected
            mBinding.imageReturnLocation.animate().rotation(0f).setDuration(500).start()
            isReturnLocation = !isReturnLocation
        }
        //mViewModel.navigate(HomeFragmentDirections.actionHomeFragmentToMapFragment())
        findNavController().navigate(R.id.action_homeFragment_to_mapFragment)

    }

    private fun selectLocation(name: String) {
        mBinding.containerMapLocation.collapse()
        if (isPickUpSelected) {
            mBinding.textPickUpLocation.text = name
            isPickUpSelected = !isPickUpSelected
            mBinding.imagePickUpLocation.animate().rotation(0f).setDuration(500).start()
            isPickUpLocation = !isPickUpLocation
        } else {
            isReturnSelected = !isReturnSelected
            mBinding.textReturnLocation.text = name
            mBinding.imageReturnLocation.animate().rotation(0f).setDuration(500).start()
            isReturnLocation = !isReturnLocation
        }
    }
}