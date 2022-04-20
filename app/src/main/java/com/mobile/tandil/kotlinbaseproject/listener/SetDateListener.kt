package com.mobile.tandil.kotlinbaseproject.listener

import java.io.Serializable

interface SetDateListener : Serializable {
    fun onDateSelected(date: String, isStart: Boolean)
}
