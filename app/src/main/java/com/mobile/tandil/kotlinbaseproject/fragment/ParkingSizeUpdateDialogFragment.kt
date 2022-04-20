package com.mobile.tandil.kotlinbaseproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.mobile.tandil.kotlinbaseproject.databinding.FragmentParkingSizeUpdateDialogBinding
import com.mobile.tandil.kotlinbaseproject.listener.ListenerSetParkingSpaces
import com.mobile.tandil.kotlinbaseproject.mvvm.model.ParkingSizeUpdateDialogModel
import com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel.ParkingSizeUpdateDialogViewModel
import com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel.ParkingSizeUpdateDialogViewModel.CheckState
import com.mobile.tandil.kotlinbaseproject.mvvm.viewmodel.ParkingSizeUpdateDialogViewModel.ParkingSpaceData
import com.mobile.tandil.kotlinbaseproject.utils.Constants

class ParkingSizeUpdateDialogFragment() : DialogFragment() {

    private lateinit var listener: ListenerSetParkingSpaces
    private lateinit var binding: FragmentParkingSizeUpdateDialogBinding
    private val model = ParkingSizeUpdateDialogModel()
    private val viewModel = ParkingSizeUpdateDialogViewModel(model)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentParkingSizeUpdateDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener = arguments?.getSerializable(Constants.LISTENER_PARKING_SPACES_SETTING_KEY) as ListenerSetParkingSpaces

        viewModel.getValue().observe({ lifecycle }, ::updateUI)

        setUpdateListeners()
    }

    private fun setUpdateListeners() {
        binding.confirmButton.setOnClickListener {
            viewModel.sendListener(binding.parkingAvailableEditText.text.toString())
        }
        binding.cancelButton.setOnClickListener {
            viewModel.closeDialog()
        }
    }

    private fun updateUI(data: ParkingSpaceData) {
        when (data.state) {
            CheckState.SEND_LISTENER -> {
                listener.listenerParkingSpaces(viewModel.getValue().value?.size.toString())
                dismiss()
            }
            CheckState.CLOSE_DIALOG -> {
                dismiss()
            }
        }
    }

    companion object {
        fun newInstance(listener: ListenerSetParkingSpaces): ParkingSizeUpdateDialogFragment {
            val fragment = ParkingSizeUpdateDialogFragment()
            val bundle = Bundle()
            bundle.putSerializable(Constants.LISTENER_PARKING_SPACES_SETTING_KEY, listener)
            fragment.arguments = bundle
            return fragment
        }

        const val MAIN_DIALOG_KEY: String = "mainDialog"
    }
}
