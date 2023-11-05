package com.example.assignment_2.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.assignment_2.app.domain.OrderRemoteModel
import com.example.assignment_2.app.domain.PaymentRemoteModel
import com.example.assignment_2.databinding.FragmentPaymentBinding
import com.example.assignment_2.databinding.FragmentResultBinding

class ResultFragment:Fragment() {
        private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val order = arguments?.getParcelable<OrderRemoteModel>("order")
        val payment = arguments?.getParcelable<PaymentRemoteModel>("order")
        Toast.makeText(requireContext(), "${order.toString()}, ${payment.toString()}",Toast.LENGTH_LONG).show()

        initListener()
    }

    private fun initListener() {
    }
}