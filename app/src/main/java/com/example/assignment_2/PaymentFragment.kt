package com.example.assignment_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.assignment_2.databinding.FragmentPaymentBinding

class PaymentFragment: Fragment() {
    private lateinit var binding : FragmentPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaymentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bundle = arguments
        if (bundle != null) {
            val selectedCoffee = bundle.getString("selected_coffee", "No coffee selected")
            val checkbox1Checked = bundle.getBoolean("checkbox1", false)
            val checkbox2Checked = bundle.getBoolean("checkbox2", false)
            // Repeat for other data

            // Construct a message
            val message = "Selected Coffee: $selectedCoffee\n" +
                    "Checkbox 1 Checked: $checkbox1Checked\n" +
                    "Checkbox 2 Checked: $checkbox2Checked"

            // Set the message to a TextView using data binding
            //binding.tvShow.text = message
            Toast.makeText(requireContext(),"here: ", Toast.LENGTH_LONG).show()
        }
    }
}