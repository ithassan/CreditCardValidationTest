package com.elve8valley.creditcardvalidationtest.ui.fragments

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
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
            val cardNumber=binding.cardNumEditText.text.toString()
            cardController.onCardValidate(binding.fNameEditText.text.toString(),
                binding.lNameEditText.text.toString(),
                cardNumber,
                binding.cvvEditText.text.toString(),
                binding.dateEditText.text.toString()
            )

        }

        binding.cardNumEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.cardtype.text = checkCardType(binding.cardNumEditText.text.toString())
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
                binding.fNameEditText.error = "Need To be Fill"
            }
            1 -> {
                binding.fNameEditText.error = "Contain only Alphabets"

            }
            2 -> {
                binding.lNameEditText.error = "Need To be Fill"
            }
            3 -> {
                binding.lNameEditText.error = "Contain only Alphabets"
            }
            4 -> {
                binding.cardNumEditText.error = "Need To be Fill"
            }
            5 -> {
                binding.cardNumEditText.error = "Card number is Invalid"
            }
            6 -> {
                binding.dateEditText.error = "Need To be Fill"
            }
            7 -> {
                binding.dateEditText.error = "please enter date like 12/10/2021"
            }
            8 -> {
                binding.cvvEditText.error = "Need To be Fill"
            }
            9 -> {
                binding.cvvEditText.error = "Please add your correct cvv number like explain in info"
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
        binding.fNameEditText.text =Editable.Factory.getInstance().newEditable("")
        binding.lNameEditText.text =Editable.Factory.getInstance().newEditable("")
        binding.cardNumEditText.text =Editable.Factory.getInstance().newEditable("")
        binding.dateEditText.text =Editable.Factory.getInstance().newEditable("")
        binding.cvvEditText.text =Editable.Factory.getInstance().newEditable("")
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
            binding.dateEditText.text = Editable.Factory.getInstance().newEditable(expiryDate)

        }, year, month, day)

        dpd.show()
    }

}
