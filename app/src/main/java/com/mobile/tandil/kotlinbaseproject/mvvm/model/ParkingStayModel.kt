package com.mobile.tandil.kotlinbaseproject.mvvm.model

import com.mobile.tandil.kotlinbaseproject.database.ReservationDataBase
import com.mobile.tandil.kotlinbaseproject.entity.Reservation
import com.mobile.tandil.kotlinbaseproject.utils.Constants

class ParkingStayModel {
    private var database = ReservationDataBase()
    private var startDate = Constants.EMPTY_STRING
    private var startTime = Constants.EMPTY_STRING
    private var endDate = Constants.EMPTY_STRING
    private var endTime = Constants.EMPTY_STRING
    private var parkingLot = Constants.EMPTY_INT
    private var securityCode = Constants.EMPTY_INT

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

    fun updateParkingLot(updatedParkingLot: Int) {
        parkingLot = updatedParkingLot
    }

    fun saveReservation(reservation: Reservation, parkingLot: Int) {
        database.addReservation(reservation, parkingLot)
    }
}
