package com.elve8valley.creditcardvalidationtest.controller

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elve8valley.creditcardvalidationtest.data.model.CardModel
import javax.inject.Inject

class CardController @Inject constructor() {
    var stopObserver = false
    private val _cardValidationMessage: MutableLiveData<Int> = MutableLiveData()
    val cardValidationMessage:LiveData<Int>
        get()=_cardValidationMessage
    private lateinit var cardModel: CardModel

    fun onCardValidate( firstname:String,
                        lastName: String,
                        cardNum: String,
                        CVV: String,
                        expiryDate:String)
    {
        stopObserver = true
        cardModel = CardModel(firstname,lastName,cardNum,CVV,expiryDate)
        val valid = cardModel.isValid()
        _cardValidationMessage.value = valid
    }
}