package com.example.assignment_2.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.assignment_2.R
import com.example.assignment_2.app.domain.OrderRemoteModel
import com.example.assignment_2.app.domain.PaymentRemoteModel
import com.example.assignment_2.databinding.FragmentPaymentBinding

class PaymentFragment: Fragment() {
    private lateinit var binding : FragmentPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentPaymentBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun getOrderInfo() {
        val test = arguments?.getParcelable<OrderRemoteModel>("order")
        //binding.test = test
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val test = arguments?.getParcelable<OrderRemoteModel>("order")
        initListener()
    }

    private fun initListener() {
        val fullName = binding.etFullName.text.toString()
        val phoneNumber = binding.etPhoneNumber.text.toString()
        val pickupTime = binding.tpTime.hour.toString() + ":" + binding.tpTime.minute.toString()
        val cardType = binding.spPayCard.selectedItem.toString()
        val cardNumber = binding.etCardNumber.text.toString()
        val cardExpiryMonth = binding.etCardNumMonth.text.toString()
        val cardExpiryYear = binding.etCardNumYear.text.toString()
        val cvvNumber = binding.etCvvNum.text.toString()

        val orderData = PaymentRemoteModel(
            fullName,
            phoneNumber,
            pickupTime,
            cardType,
            cardNumber,
            cardExpiryMonth,
            cardExpiryYear,
            cvvNumber
        )

        //val test = arguments?.getParcelable<OrderRemoteModel>("order")
    binding.btnPlaceOrder.setOnClickListener {
        val bundle = bundleOf("Payment" to orderData)
        //bundle.putParcelable("orderData", orderData)
        findNavController().navigate(R.id.resultFragment, bundle)

    }

    }
}