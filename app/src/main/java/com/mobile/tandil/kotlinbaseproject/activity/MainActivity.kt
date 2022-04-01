package com.mobile.tandil.kotlinbaseproject.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mobile.tandil.kotlinbaseproject.R
import com.mobile.tandil.kotlinbaseproject.databinding.ActivityMainBinding
import com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel.MainViewModel
import com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel.MainViewModel.CheckData
import com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel.MainViewModel.CheckState

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getValue().observe({ lifecycle }, ::updateUI)

        setListeners()
    }

    private fun setListeners() {
        binding.checkButton.setOnClickListener {
            viewModel.initValue()
        }
    }

    private fun updateUI(data: CheckData) {
        when (data.state) {
            CheckState.INITIAL -> {
                showToast(getString(R.string.main_activity_toast_initial_text))
            }
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
