package com.mobile.tandil.kotlinbaseproject.mvvm.model

import com.mobile.tandil.kotlinbaseproject.utils.Constants

class ParkingStayModel {
    private var startDate = Constants.EMPTY_STRING
    private var startTime = Constants.EMPTY_STRING
    private var endDate = Constants.EMPTY_STRING
    private var endTime = Constants.EMPTY_STRING

    fun updateStartDate(updatedStartDate: String) {
        startDate = updatedStartDate
    }

    fun updateStartTime(updatedStartTime: String) {
        startTime = updatedStartTime
    }

    fun updateEndDate(updatedEndDate: String) {
        endDate = updatedEndDate
    }

    fun updateEndTime(updatedEndTime: String) {
        endTime = updatedEndTime
    }
}
