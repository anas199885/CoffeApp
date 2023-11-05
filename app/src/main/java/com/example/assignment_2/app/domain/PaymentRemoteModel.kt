package com.example.assignment_2.app.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PaymentRemoteModel(
    val fullName: String,
    val phoneNumber: String,
    val pickupTime: String,
    val cardType: String,
    val cardNumber: String,
    val cardExpiryMonth: String,
    val cardExpiryYear: String,
    val cvvNumber: String
):Parcelable
