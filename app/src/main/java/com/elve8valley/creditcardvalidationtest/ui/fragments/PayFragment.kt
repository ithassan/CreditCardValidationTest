package com.elve8valley.creditcardvalidationtest.ui.fragments

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.elve8valley.creditcardvalidationtest.base.BaseFragment
import com.elve8valley.creditcardvalidationtest.controller.CardController
import com.elve8valley.creditcardvalidationtest.databinding.PayFragmentBinding
import com.elve8valley.creditcardvalidationtest.util.ValidationUtil.checkCardType
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class PayFragment : BaseFragment<PayFragmentBinding>(PayFragmentBinding ::inflate) {
    @Inject
     lateinit var  cardController: CardController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickListener()
        subScribeToAllObserver()
    }


    private fun clickListener()
    {

        binding.dateBtn.setOnClickListener{
            getExpiryDate()
        }
        binding.payBtn.setOnClickListener {
            val cardNumber=binding.cardnum.text.toString()
            cardController.onCardValidate(binding.fname.text.toString(),
                binding.lname.text.toString(),
                cardNumber,
                binding.cvv.text.toString(),
                binding.date.text.toString()
            )

        }

        binding.cardnum.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.cardtype.text = checkCardType(binding.cardnum.text.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun subScribeToAllObserver()
    {
        
        cardController.cardValidationMessage.observe(viewLifecycleOwner) {
            if(cardController.stopObserver)
                updatedUI(it)

        }
    }

    override fun onPause() {
        super.onPause()
        cardController.stopObserver = false
    }


    private fun updatedUI( messageCode : Int)
    {
        when (messageCode) {
            0 -> {
                binding.fname.error = "Need To be Fill"
            }
            1 -> {
                binding.lname.error = "Need To be Fill"
            }
            2 -> {
                binding.fname.error = "Contain only Alphabets"
            }
            3 -> {
                binding.lname.error = "Contain only Alphabets"
            }
            4 -> {
                binding.cardnum.error = "Need To be Fill"
            }
            5 -> {
                binding.cardnum.error = "Card number is Invalid"
            }
            6 -> {
                binding.date.error = "Need To be Fill"
            }
            7 -> {
                binding.date.error = "please enter date like 12/10/2021"
            }
            8 -> {
                binding.cvv.error = "Need To be Fill"
            }
            9 -> {
                binding.cvv.error = "Please add your correct cvv number like explain in info"
            }
            else -> {
                showDialog()
            }
        }
    }

    private fun showDialog()
    {
        AlertDialog.Builder(requireContext())
            .setTitle("Alert!")
            .setMessage("Payment was successful.")
            .setPositiveButton("Done") { dialog, which ->
                dialog.dismiss()
            }.show()
    setUiToInitialState()
    }

    private fun setUiToInitialState()
    {
        cardController.stopObserver = false
        binding.fname.text =Editable.Factory.getInstance().newEditable("")
        binding.lname.text =Editable.Factory.getInstance().newEditable("")
        binding.cardnum.text =Editable.Factory.getInstance().newEditable("")
        binding.date.text =Editable.Factory.getInstance().newEditable("")
        binding.cvv.text =Editable.Factory.getInstance().newEditable("")
        binding.cardtype.text = ""
    }

    private fun getExpiryDate()
    {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(requireContext(), { _, year, monthOfYear, dayOfMonth ->
            val m = monthOfYear+1
           val expiryDate = "$dayOfMonth/$m/$year"
            binding.date.text = Editable.Factory.getInstance().newEditable(expiryDate)

        }, year, month, day)

        dpd.show()
    }




}
