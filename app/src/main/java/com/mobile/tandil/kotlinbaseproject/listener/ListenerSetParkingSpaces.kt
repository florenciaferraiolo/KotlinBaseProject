package com.mobile.tandil.kotlinbaseproject.listener

import java.io.Serializable

interface ListenerSetParkingSpaces : Serializable {
    fun listenerParkingSpaces(parkingSpaces: String)
}
