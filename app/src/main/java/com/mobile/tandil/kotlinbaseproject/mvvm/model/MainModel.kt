package com.mobile.tandil.kotlinbaseproject.mvvm.model

import com.mobile.tandil.kotlinbaseproject.utils.Constants

class MainModel {
    private var parkingSpacesAvailable = Constants.EMPTY_STRING_KEY

    fun updateParkingSpacesAvailable(updatedParking: String) {
        parkingSpacesAvailable = updatedParking
    }
}
