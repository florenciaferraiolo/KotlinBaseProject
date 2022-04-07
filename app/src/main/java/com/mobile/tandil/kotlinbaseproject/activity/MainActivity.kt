package com.mobile.tandil.kotlinbaseproject.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobile.tandil.kotlinbaseproject.databinding.ActivityMainBinding
import com.mobile.tandil.kotlinbaseproject.fragment.ParkingSizeUpdateDialogFragment
import com.mobile.tandil.kotlinbaseproject.listener.ListenerSetParkingSpaces
import com.mobile.tandil.kotlinbaseproject.mvvm.model.MainModel
import com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel.MainViewModel.CheckState
import com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel.MainViewModel
import com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel.MainViewModel.ParkingData

class MainActivity : AppCompatActivity(), ListenerSetParkingSpaces {

    private lateinit var binding: ActivityMainBinding
    private val model = MainModel()
    private val viewModel = MainViewModel(model)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getValue().observe({ lifecycle }, ::updateUI)

        setListeners()
    }

    private fun setListeners() {
        binding.updateButton.setOnClickListener {
            viewModel.showParkingSizeFragment()
        }
    }

    private fun updateUI(data: ParkingData) {
        when (data.state) {
            CheckState.SHOW_FRAGMENT -> {
                val newFragment: ParkingSizeUpdateDialogFragment = ParkingSizeUpdateDialogFragment.newInstance(this@MainActivity)
                newFragment.show(supportFragmentManager, ParkingSizeUpdateDialogFragment.MAIN_DIALOG_KEY)
            }
        }
    }

    override fun listenerParkingSpaces(parkingSpaces: String) {
        binding.parkingAvailableTextField.text = parkingSpaces
        viewModel.updateParkingAvailableValue(parkingSpaces)
    }
}
