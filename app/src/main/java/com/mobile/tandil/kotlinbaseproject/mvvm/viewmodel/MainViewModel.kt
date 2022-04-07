package com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.tandil.kotlinbaseproject.mvvm.model.MainModel

class MainViewModel(model: MainModel) : ViewModel() {

    private val mainModel = model
    private val mutableLiveData: MutableLiveData<ParkingData> = MutableLiveData()

    fun getValue(): LiveData<ParkingData> {
        return mutableLiveData
    }

    fun updateParkingAvailableValue(parkingAvailableUpdate: String) {
        mainModel.updateParkingSpacesAvailable(parkingAvailableUpdate)
    }

    fun showParkingSizeFragment() {
        mutableLiveData.value = ParkingData(CheckState.SHOW_FRAGMENT)
    }

    data class ParkingData(
        val state: CheckState
    )

    enum class CheckState {
        SHOW_FRAGMENT
    }
}
