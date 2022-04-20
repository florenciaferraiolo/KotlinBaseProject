package com.mobile.tandil.kotlinbaseproject.fragment

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.mobile.tandil.kotlinbaseproject.listener.SetDateListener
import com.mobile.tandil.kotlinbaseproject.utils.Constants
import java.util.Calendar

class DatePickerDialogFragment() : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private lateinit var listener: SetDateListener
    private var isStart: Boolean = true

    override fun onCreateDialog(savedInstanceState: Bundle?): DatePickerDialog {
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        listener = arguments?.getSerializable(Constants.LISTENER_SET_DATE) as SetDateListener
        isStart = arguments?.getBoolean(Constants.IS_START_KEY, true) == true

        return DatePickerDialog(activity as Context, this, year, month, day)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayofMonth: Int) {
        listener.onDateSelected("$dayofMonth${Constants.SLASH}$month${Constants.SLASH}$year", isStart)
    }

    companion object {
        fun newInstance(listener: SetDateListener, isStart: Boolean): DatePickerDialogFragment {
            val fragment = DatePickerDialogFragment()
            val bundle = Bundle()
            bundle.putSerializable(Constants.LISTENER_SET_DATE, listener)
            bundle.putBoolean(Constants.IS_START_KEY, isStart)
            fragment.arguments = bundle
            return fragment
        }
        const val DATE_PICKER_DIALOG: String = "datePicker"
    }
}
