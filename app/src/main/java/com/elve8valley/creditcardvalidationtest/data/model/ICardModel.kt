package com.elve8valley.creditcardvalidationtest.data.model

interface ICardModel {
    fun isValid() : Int
    fun isValidCvv():Boolean
    fun checkLuhn():Boolean
    fun isDateValid() : Boolean
    fun userNameWithAlphabets(name : String):Boolean


}