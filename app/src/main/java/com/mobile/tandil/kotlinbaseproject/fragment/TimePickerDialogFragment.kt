package com.mobile.tandil.kotlinbaseproject.fragment

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.mobile.tandil.kotlinbaseproject.listener.SetTimeListener
import com.mobile.tandil.kotlinbaseproject.utils.Constants
import java.util.Calendar

class TimePickerDialogFragment() : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    private lateinit var listener: SetTimeListener
    private var isStart: Boolean = true

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        listener = arguments?.getSerializable(Constants.LISTENER_SET_TIME) as SetTimeListener
        isStart = arguments?.getBoolean(Constants.IS_START_KEY, true) == true

        return TimePickerDialog(activity as Context, this, hour, minute, true)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        listener.onTimeSelected("$hourOfDay${Constants.TWO_DOTS}$minute", isStart)
    }

    companion object {
        fun newInstance(listener: SetTimeListener, isStart: Boolean): TimePickerDialogFragment {
            val fragment = TimePickerDialogFragment()
            val bundle = Bundle()
            bundle.putSerializable(Constants.LISTENER_SET_TIME, listener)
            bundle.putBoolean(Constants.IS_START_KEY, isStart)
            fragment.arguments = bundle
            return fragment
        }

        const val TIME_PICKER_DIALOG: String = "timePicker"
    }
}
