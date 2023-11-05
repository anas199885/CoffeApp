package com.example.assignment_2.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.assignment_2.app.domain.OrderRemoteModel
import com.example.assignment_2.R
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
        initListener()

    }

    private fun initListener() {
        var drink: String = "" // Initialize drink variable

        binding.cvAmerican.setOnClickListener {
            binding.textAmericano.setBackgroundColor(resources.getColor(R.color.ShadesDark))
            drink ="Americano"
            showDrinkSize()
        }

        binding.cvCappuccino.setOnClickListener {
            binding.textCappuccino.setBackgroundColor(resources.getColor(R.color.ShadesDark))
            drink = "Cappuccino"
            showDrinkSize()
        }

        binding.cvLatte.setOnClickListener {
            binding.textLatte.setBackgroundColor(resources.getColor(R.color.ShadesDark))
            drink = "Latte"
            showDrinkSize()
        }

        binding.cvMacchiato.setOnClickListener {
            binding.textMacchiato.setBackgroundColor(resources.getColor(R.color.ShadesDark))
            drink = "Macchiato"
            showDrinkSize()
        }

        // Initialize the size and options
        var size: String = ""
        val options: MutableList<String> = mutableListOf()

        // Handle size selection
        binding.rdSize.setOnCheckedChangeListener { _, checkedId ->
            size = when (checkedId) {
                R.id.smallSize -> "Small"
                R.id.mediumSize -> "Medium"
                R.id.largeSize -> "Large"
                else -> ""
            }
            showOptions()
        }

        // Handle option selection
        val optionCheckBoxes = listOf(
            binding.checkBox1,
            binding.checkBox2,
            binding.checkBox3,
            binding.checkBox4,
            binding.checkBox5,
            binding.checkBox6,
            binding.checkBox7
        )

        optionCheckBoxes.forEachIndexed { index, checkBox ->
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    options.add(checkBox.text.toString())
                } else {
                    options.remove(checkBox.text.toString())
                }
            }
        }

        binding.btnContinue.isClickable = false

        binding.btnContinue.setOnClickListener {

            val order = OrderRemoteModel(drink, size, options)
            val bundle = bundleOf("order" to order)
            findNavController().navigate(R.id.paymentFragment, bundle)
        }
    }

    private fun setDrink(drinkType: String) {
         //drink = drinkType
        // Update the UI to highlight the selected drink
        // (You can add your UI updates here)
    }

    private fun showDrinkSize() {
        // Update the UI to show the drink size options
        binding.drinkSize.isVisible = true
    }

    private fun showOptions() {
        // Update the UI to show the options and enable the "Continue" button
        binding.options.isVisible = true
        binding.btnContinue.setBackgroundColor(resources.getColor(R.color.ShadesDark))
        binding.btnContinue.isClickable = true
    }



}