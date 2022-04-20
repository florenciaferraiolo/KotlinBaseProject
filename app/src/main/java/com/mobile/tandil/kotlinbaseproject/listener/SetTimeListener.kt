package com.mobile.tandil.kotlinbaseproject.listener

import java.io.Serializable

interface SetTimeListener : Serializable {
    fun onTimeSelected(time: String, isStart: Boolean)
}
