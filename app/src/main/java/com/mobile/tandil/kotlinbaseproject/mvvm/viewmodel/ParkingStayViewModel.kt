package com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mobile.tandil.kotlinbaseproject.mvvm.model.ParkingStayModel
import com.mobile.tandil.kotlinbaseproject.utils.Constants

class ParkingStayViewModel(private val model: ParkingStayModel) {

    private val mutableLiveData: MutableLiveData<ParkingStayData> = MutableLiveData()

    fun getValue(): LiveData<ParkingStayData> {
        return mutableLiveData
    }

    fun showStartDatePickerFragment() {
        mutableLiveData.value = ParkingStayData(CheckState.SHOW_START_DATE_PICKER_FRAGMENT)
    }

    fun saveStartDate(startDate: String) {
        model.updateStartDate(startDate)
        mutableLiveData.value = ParkingStayData(CheckState.SHOW_START_TIME_PICKER_FRAGMENT)
    }

    fun saveStartTime(startTime: String) {
        model.updateStartTime(startTime)
    }

    fun showEndDatePickerFragment() {
        mutableLiveData.value = ParkingStayData(CheckState.SHOW_END_DATE_PICKER_FRAGMENT)
    }

    fun saveEndDate(endDate: String) {
        model.updateEndDate(endDate)
        mutableLiveData.value = ParkingStayData(CheckState.SHOW_END_TIME_PICKER_FRAGMENT)
    }

    fun saveEndTime(endTime: String) {
        model.updateEndTime(endTime)
    }

    fun closeActivity() {
        mutableLiveData.value = ParkingStayData(CheckState.CLOSE_ACTIVITY)
    }

    fun onDateSelected(date: String, start: Boolean) {
        if (start) {
            mutableLiveData.value = ParkingStayData(CheckState.ON_START_DATE_SELECTED, date)
        } else {
            mutableLiveData.value = ParkingStayData(CheckState.ON_END_DATE_SELECTED, date)
        }
    }

    fun onTimeSelected(time: String, start: Boolean) {
        if (start) {
            mutableLiveData.value = ParkingStayData(CheckState.ON_START_TIME_SELECTED, time = time)
        } else {
            mutableLiveData.value = ParkingStayData(CheckState.ON_END_TIME_SELECTED, time = time)
        }
    }

    data class ParkingStayData(
        val state: CheckState,
        val date: String = Constants.EMPTY_STRING,
        val time: String = Constants.EMPTY_STRING
    )

    enum class CheckState {
        SHOW_START_DATE_PICKER_FRAGMENT,
        SHOW_END_DATE_PICKER_FRAGMENT,
        SHOW_START_TIME_PICKER_FRAGMENT,
        SHOW_END_TIME_PICKER_FRAGMENT,
        CLOSE_ACTIVITY,
        ON_START_DATE_SELECTED,
        ON_END_DATE_SELECTED,
        ON_START_TIME_SELECTED,
        ON_END_TIME_SELECTED
    }
}
