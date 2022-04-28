package com.mobile.tandil.kotlinbaseproject.database

import com.mobile.tandil.kotlinbaseproject.entity.Reservation

class ReservationDataBase {
    private var reservations: HashMap<Int, List<Reservation>> = hashMapOf()
    private var reservationList: List<Reservation> = emptyList()

    fun addReservation(reservation: Reservation, parkingLot: Int) {
        if (reservations.isNullOrEmpty()) {
            reservationList.toMutableList().add(reservation)
            reservations[parkingLot] = reservationList
        } else {
            reservations[parkingLot].apply { reservations.values.add(reservationList) }
        }
    }
}
