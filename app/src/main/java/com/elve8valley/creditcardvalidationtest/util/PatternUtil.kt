package com.elve8valley.creditcardvalidationtest.util

object PatternUtil {
    const val visaCardPattern = "^4[0-9]{12}(?:[0-9]{3})?$"
    const val masterCardPattern = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14})$"
    const val americanExpressCardPattern = "^[34|37][0-9]{14}$"
    const val discoverCardPattern = "^65[4-9][0-9]{13}|64[4-9][0-9]{13}|6011[0-9]{12}|(622(?:12[6-9]|1[3-9][0-9]|[2-8][0-9][0-9]|9[01][0-9]|92[0-5])[0-9]{10})$"
    const val nameWithAlphabets = "^[a-zA-Z]*$"
}