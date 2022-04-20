package com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.tandil.kotlinbaseproject.mvvm.model.ParkingSizeUpdateDialogModel
import com.mobile.tandil.kotlinbaseproject.utils.Constants

class ParkingSizeUpdateDialogViewModel(model: ParkingSizeUpdateDialogModel) : ViewModel() {

    private val modelUpdate = model
    private val mutableLiveData: MutableLiveData<ParkingSpaceData> = MutableLiveData()

    fun getValue(): LiveData<ParkingSpaceData> {
        return mutableLiveData
    }

    fun sendListener(parkingSpacesUpdate: String) {
        mutableLiveData.value = ParkingSpaceData(CheckState.SEND_LISTENER, parkingSpacesUpdate)
        modelUpdate.updateParkingSpaces(parkingSpacesUpdate)
    }

    fun closeDialog() {
        mutableLiveData.value = ParkingSpaceData(CheckState.CLOSE_DIALOG, Constants.EMPTY_STRING)
    }

    data class ParkingSpaceData(
        val state: CheckState,
        val size: String
    )

    enum class CheckState {
        SEND_LISTENER,
        CLOSE_DIALOG
    }
}
