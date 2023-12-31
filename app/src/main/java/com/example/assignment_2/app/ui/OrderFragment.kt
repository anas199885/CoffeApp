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
        var drink= ""

        binding.rdCoffeeType.setOnCheckedChangeListener { _, checkedId ->
            drink = when (checkedId) {
                R.id.rb_americano -> "Americano"
                R.id.rb_cappuccino -> "Cappuccino"
                R.id.rb_latte -> "Latte"
                R.id.rb_macchiato -> "Macchiato"
                else -> ""
            }
            showDrinkSize()
        }

        var size = ""
        val options: MutableList<String> = mutableListOf()


        binding.rdSize.setOnCheckedChangeListener { _, checkedId ->
            size = when (checkedId) {
                R.id.smallSize -> "Small"
                R.id.mediumSize -> "Medium"
                R.id.largeSize -> "Large"
                else -> ""
            }
            showOptions()
            continueClick(drink,size,options)
        }

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

    }

    private fun continueClick(drink: String, size: String, options: MutableList<String>) {

        binding.btnContinue.setOnClickListener {
            val order = OrderRemoteModel(drink, size, options)
            val bundle = bundleOf("order" to order)
            val resultFragment=ResultFragment()
            resultFragment.arguments = bundle
            findNavController().navigate(R.id.paymentFragment, bundle)
        }
    }

    private fun showDrinkSize() {
        binding.drinkSize.isVisible = true
    }

    private fun showOptions() {
        binding.options.isVisible = true
        binding.btnContinue.isClickable = true
    }
}