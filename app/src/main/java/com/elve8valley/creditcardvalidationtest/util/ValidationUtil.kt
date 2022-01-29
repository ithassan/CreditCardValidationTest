package com.elve8valley.creditcardvalidationtest.util

object ValidationUtil {
    fun checkCardType(cardNum : String) :String {
        var cardType = ""
        val listOfCardType = arrayListOf("VISA",
            "MASTERCARD",
            "American Express",
            "DISCOVER"
        )
        val listOfPattern = arrayListOf(PatternUtil.visaCardPattern,
            PatternUtil.masterCardPattern,
            PatternUtil.americanExpressCardPattern,
            PatternUtil.discoverCardPattern
        )
        var i = 0
        loop@ for (p in listOfPattern) {
            val pattern = Regex(p)
            when {
                pattern.matches(cardNum) -> {
                    cardType = listOfCardType[i]
                    break@loop
                }
            }
            i += 1
        }
        return cardType
    }
}