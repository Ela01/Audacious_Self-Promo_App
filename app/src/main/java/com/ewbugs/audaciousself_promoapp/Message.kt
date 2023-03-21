package com.ewbugs.audaciousself_promoapp

//Data Container
data class Message(

    val contactName: String,
    val contactNumber: String,
    val myDisplayName: String,
    val includeJunior: Boolean,
    val jobTitle: String?,
    val immediateStart: Boolean,
    val startDate: String?,
) : java.io.Serializable {

    //function expressions:

    fun getFullJobDescription() = if (includeJunior) "a Junior $jobTitle" else "an $jobTitle"

    fun getAvailability() = if (immediateStart) "immediately" else "from $startDate"

}
