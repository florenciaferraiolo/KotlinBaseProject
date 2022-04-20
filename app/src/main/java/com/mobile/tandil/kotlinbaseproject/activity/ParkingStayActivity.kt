package com.mobile.tandil.kotlinbaseproject.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobile.tandil.kotlinbaseproject.databinding.ActivityParkingStayBinding
import com.mobile.tandil.kotlinbaseproject.fragment.DatePickerDialogFragment
import com.mobile.tandil.kotlinbaseproject.fragment.TimePickerDialogFragment
import com.mobile.tandil.kotlinbaseproject.listener.SetDateListener
import com.mobile.tandil.kotlinbaseproject.listener.SetTimeListener
import com.mobile.tandil.kotlinbaseproject.mvvm.model.ParkingStayModel
import com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel.ParkingStayViewModel
import com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel.ParkingStayViewModel.CheckState
import com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel.ParkingStayViewModel.ParkingStayData

class ParkingStayActivity : AppCompatActivity(), SetDateListener, SetTimeListener {

    private lateinit var binding: ActivityParkingStayBinding
    private val model = ParkingStayModel()
    private val viewModel = ParkingStayViewModel(model)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParkingStayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getValue().observe({ lifecycle }, ::updateUI)

        setListeners()
    }

    private fun setListeners() {
        binding.startDateTimeButton.setOnClickListener {
            viewModel.showStartDatePickerFragment()
        }
        binding.endDateTimeButton.setOnClickListener {
            viewModel.showEndDatePickerFragment()
        }
        binding.confirmButton.setOnClickListener {
            viewModel.closeActivity()
        }
        binding.cancelButton.setOnClickListener {
            viewModel.closeActivity()
        }
    }

    private fun updateUI(data: ParkingStayData) {
        when (data.state) {
            CheckState.SHOW_START_DATE_PICKER_FRAGMENT -> {
                val datePicker = DatePickerDialogFragment.newInstance(this, true)
                datePicker.show(supportFragmentManager, DatePickerDialogFragment.DATE_PICKER_DIALOG)
            }
            CheckState.SHOW_START_TIME_PICKER_FRAGMENT -> {
                val timePicker = TimePickerDialogFragment.newInstance(this, true)
                timePicker.show(supportFragmentManager, TimePickerDialogFragment.TIME_PICKER_DIALOG)
            }
            CheckState.SHOW_END_DATE_PICKER_FRAGMENT -> {
                val datePicker = DatePickerDialogFragment.newInstance(this, false)
                datePicker.show(supportFragmentManager, DatePickerDialogFragment.DATE_PICKER_DIALOG)
            }
            CheckState.SHOW_END_TIME_PICKER_FRAGMENT -> {
                val timePicker = TimePickerDialogFragment.newInstance(this, false)
                timePicker.show(supportFragmentManager, TimePickerDialogFragment.TIME_PICKER_DIALOG)
            }
            CheckState.CLOSE_ACTIVITY -> {
                finish()
            }
            CheckState.ON_START_DATE_SELECTED -> {
                binding.startDateSelectedTextView.text = data.date
                viewModel.saveStartDate(binding.startDateSelectedTextView.text.toString())
            }
            CheckState.ON_END_DATE_SELECTED -> {
                binding.endDateSelectedTextView.text = data.date
                viewModel.saveEndDate(binding.endDateSelectedTextView.text.toString())
            }
            CheckState.ON_START_TIME_SELECTED -> {

                binding.startTimeSelectedTextView.text = data.time
                viewModel.saveStartTime(binding.startTimeSelectedTextView.text.toString())
            }
            CheckState.ON_END_TIME_SELECTED -> {
                binding.endTimeSelectedTextView.text = data.time
                viewModel.saveEndTime(binding.endTimeSelectedTextView.text.toString())
            }
        }
    }

    override fun onDateSelected(date: String, isStart: Boolean) {
        viewModel.onDateSelected(date, isStart)
    }

    override fun onTimeSelected(time: String, isStart: Boolean) {
        viewModel.onTimeSelected(time, isStart)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ParkingStayActivity::class.java)
        }
    }
}
