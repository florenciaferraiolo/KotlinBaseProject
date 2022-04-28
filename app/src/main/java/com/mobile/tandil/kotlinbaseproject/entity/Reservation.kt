package com.mobile.tandil.kotlinbaseproject.entity

import com.mobile.tandil.kotlinbaseproject.utils.Constants

class Reservation() {

    private lateinit var startDate: String
    private lateinit var endDate: String
    private lateinit var startTime: String
    private lateinit var endTime: String
    private var securityCode: Int = Constants.EMPTY_INT

    fun updateStartDate(updatedStartDate: String) {
        startDate = updatedStartDate
    }

    fun updateEndDate(updatedEndDate: String) {
        endDate = updatedEndDate
    }

    fun updateStartTime(updatedStartTime: String) {
        startTime = updatedStartTime
    }

    fun updateEndTime(updatedEndTime: String) {
        endTime = updatedEndTime
    }

    fun updateSecurityCode(updatedSecurityCode: Int) {
        securityCode = updatedSecurityCode
    }
}
