package com.elve8valley.creditcardvalidationtest.controller

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.elve8valley.creditcardvalidationtest.data.model.CardModel
import javax.inject.Inject

class CardController @Inject constructor() {
    val cardValidationMessage: MutableLiveData<Int> = MutableLiveData()
    private lateinit var cardModel: CardModel

    fun onCardValidate( firstname:String,
                        lastName: String,
                        cardNum: String,
                        CVV: String,
                        expiryDate:String)
    {
        cardModel = CardModel(firstname,lastName,cardNum,CVV,expiryDate)
        val valid = cardModel.isValid()
        cardValidationMessage.value = valid
    }
}