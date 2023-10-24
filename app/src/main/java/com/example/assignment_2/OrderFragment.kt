package com.example.assignment_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.assignment_2.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {
    private lateinit var binding: FragmentOrderBinding
    private val dataBundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrderBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        selectCoffee()
    }

    private fun selectCoffee() {
        binding.cvAmerican.setOnClickListener {
            binding.textAmericano.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesDark))
            binding.textCappuccino.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesLight))
            binding.textLatte.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesLight))
            binding.textMacchiato.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesLight))

            binding.drinkSize.isVisible = true
            selectSize()
        }
        binding.cvCappuccino.setOnClickListener {
            binding.textCappuccino.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesDark))
            binding.textAmericano.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesLight))
            binding.textLatte.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesLight))
            binding.textMacchiato.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesLight))

            binding.drinkSize.isVisible = true
            selectSize()
        }
        binding.cvLatte.setOnClickListener {
            binding.textLatte.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesDark))
            binding.textAmericano.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesLight))
            binding.textCappuccino.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesLight))
            binding.textMacchiato.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesLight))
            binding.drinkSize.isVisible = true
            selectSize()
        }
        binding.cvMacchiato.setOnClickListener {
            binding.textMacchiato.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesDark))
            binding.textAmericano.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesLight))
            binding.textCappuccino.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesLight))
            binding.textLatte.setBackgroundColor(resources.getColor(com.example.assignment_2.R.color.ShadesLight))

            binding.drinkSize.isVisible = true
            selectSize()
        }
    }

    private fun selectSize() {
        binding.rdSize.setOnCheckedChangeListener { group, checkedId ->
            val size = when (checkedId) {
                R.id.smallSize -> "Small"
                R.id.mediumSize -> "Medium"
                R.id.largeSize -> "Large"
                else -> ""
            }
            dataBundle.putString("coffee_size", size)
            selectOptions()
        }
    }

    private fun selectOptions() {
        binding.options.isVisible = true

        val checkbox1 = binding.checkBox1
        val checkbox2 = binding.checkBox2
        val checkbox3 = binding.checkBox3
        val checkbox4 = binding.checkBox4
        val checkbox5 = binding.checkBox5
        val checkbox6 = binding.checkBox6
        val checkbox7 = binding.checkBox7

        binding.Continue.setOnClickListener {
            dataBundle.putBoolean("checkbox1", checkbox1.isChecked)
            dataBundle.putBoolean("checkbox2", checkbox2.isChecked)
            dataBundle.putBoolean("checkbox3", checkbox3.isChecked)
            dataBundle.putBoolean("checkbox4", checkbox4.isChecked)
            dataBundle.putBoolean("checkbox5", checkbox5.isChecked)
            dataBundle.putBoolean("checkbox6", checkbox6.isChecked)
            dataBundle.putBoolean("checkbox7", checkbox7.isChecked)

            val newFragment = PaymentFragment()
            newFragment.arguments = dataBundle

            findNavController().navigate(R.id.paymentFragment)
        }
    }
}