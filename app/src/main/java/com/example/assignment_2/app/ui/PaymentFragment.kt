package com.example.assignment_2.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initListener()
    }

    private fun initListener() {
        val test = arguments?.getParcelable<OrderRemoteModel>("order")

        binding.btnPlaceOrder.setOnClickListener {
            val fullName = binding.etFullName.text.toString()
            val phoneNumber = binding.etPhoneNumber.text.toString()
            val pickupTime = binding.tpTime.hour.toString() + ":" + binding.tpTime.minute.toString()
            val cardType = binding.spPayCard.selectedItem.toString()
            val cardNumber = binding.etCardNumber.text.toString()
            val cardExpiryMonth = binding.etCardNumMonth.text.toString()
            val cardExpiryYear = binding.etCardNumYear.text.toString()
            val cvvNumber = binding.etCvvNum.text.toString()

            if (fullName.isNotEmpty()) {
                binding.PaymentScreen.isVisible = true
            }
            if (cardType != "_"){
                binding.cardScreen.isVisible = true
            }
            if (cvvNumber.isNotEmpty()){
                val orderData = PaymentRemoteModel(
                    fullName,
                    phoneNumber,
                    pickupTime,
                    cardType,
                    cardNumber,
                    cardExpiryMonth,
                    cardExpiryYear,
                    cvvNumber,
                    test!!
                )

                val bundle = bundleOf("Payment" to orderData)
                findNavController().navigate(R.id.resultFragment, bundle)
            }
        }
    }

}