package com.example.assignment_2.app.ui

import android.annotation.SuppressLint
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
       initListener()
    }

    @SuppressLint("SetTextI18n")
    private fun initListener() {
        val orderInfo = arguments?.getParcelable<PaymentRemoteModel>("Payment")
        binding.payment =orderInfo
        if (orderInfo?.OrderInfo?.drinkOptions?.isNotEmpty() == true) {
            binding.tvOrder.text = "A ${orderInfo.OrderInfo.drinkSize} Of ${orderInfo.OrderInfo.drinkName}, With ${orderInfo.OrderInfo.drinkOptions}"
        }else{
            binding.tvOrder.text = "A ${orderInfo?.OrderInfo?.drinkSize} Of ${orderInfo?.OrderInfo?.drinkName}"
        }
    }

}