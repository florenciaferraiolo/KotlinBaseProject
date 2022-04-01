package com.mobile.tandil.kotlinbaseproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mobile.tandil.kotlinbaseproject.databinding.ActivityMainBinding
import com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel.MainActivityViewModel
import com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel.MainActivityViewModel.CheckData
import com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel.MainActivityViewModel.CheckState

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainActivityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.checkButton.setOnClickListener {
            viewModel.initValue()
        }
        viewModel.getValue().observe({ lifecycle }, ::checkButtonToast)
    }

    private fun checkButtonToast(it: CheckData) {
        when (it.state) {
            CheckState.INITIAL -> {
                showToast(getString(R.string.main_activity_toast_initial_text))
            }
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
