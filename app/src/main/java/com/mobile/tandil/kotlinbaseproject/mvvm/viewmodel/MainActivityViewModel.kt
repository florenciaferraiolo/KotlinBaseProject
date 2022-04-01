package com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val mutableLiveData: MutableLiveData<CheckData> = MutableLiveData()

    fun getValue(): MutableLiveData<CheckData> {
        return mutableLiveData
    }

    fun initValue() {
        mutableLiveData.value = CheckData(CheckState.INITIAL)
    }

    data class CheckData(
        val state: CheckState = CheckState.INITIAL
    )

    enum class CheckState {
        INITIAL
    }
}
