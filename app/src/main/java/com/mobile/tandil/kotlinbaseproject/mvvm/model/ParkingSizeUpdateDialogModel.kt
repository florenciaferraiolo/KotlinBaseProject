package com.mobile.tandil.kotlinbaseproject.mvvm.model

import com.mobile.tandil.kotlinbaseproject.utils.Constants

class ParkingSizeUpdateDialogModel {
    private var parkingSpaces = Constants.EMPTY_STRING

    fun updateParkingSpaces(parkingSpacesUpdated: String) {
        parkingSpaces = parkingSpacesUpdated
    }
}
