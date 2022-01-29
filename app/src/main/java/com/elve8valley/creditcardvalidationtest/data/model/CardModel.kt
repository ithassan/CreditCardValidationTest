package com.elve8valley.creditcardvalidationtest.data.model

import android.text.TextUtils
import android.util.Log
import com.elve8valley.creditcardvalidationtest.util.PatternUtil
import com.elve8valley.creditcardvalidationtest.util.ValidationUtil

class CardModel (private val firstname:String,
                 private val lastName: String,
                 private val cardNum: String,
                 private val CVV: String,
                 private val expiryDate:String
): ICardModel {
    override fun isValid() : Int {
        return when {
            TextUtils.isEmpty(firstname) -> 0
            !userNameWithAlphabets(firstname) -> 2
            TextUtils.isEmpty(lastName) -> 1
            !userNameWithAlphabets(lastName) -> 3
            TextUtils.isEmpty(cardNum) -> 4
            !checkLuhn() -> 5
            TextUtils.isEmpty(expiryDate) -> 6
            TextUtils.isEmpty(CVV) -> 7
            !isValidCvv() -> 8
            else -> -1
        }
    }

    override fun isValidCvv(): Boolean {
        return when {
            ValidationUtil.checkCardType(cardNum) == "American Express" && CVV.length == 4 -> true
            ValidationUtil.checkCardType(cardNum) != "American Express" && CVV.length == 3 -> true
            else -> false
        }
    }

    override fun checkLuhn(): Boolean {
        if(!TextUtils.isEmpty(cardNum)) {
            val nDigits = cardNum.length
            var nSum = 0
            var isSecond = false
            for (i in (nDigits - 1).downTo(0)) {
                var d = cardNum[i] - '0'
                if (isSecond)
                    d *= 2

                nSum += d / 10
                nSum += d % 10
                isSecond = !isSecond
            }
            return nSum % 10 == 0
        }
        else
        {
            return false
        }
    }

    override fun userNameWithAlphabets(name: String): Boolean {
        val pattern = Regex(PatternUtil.nameWithAlphabets)
        return pattern.matches(name)
    }
}