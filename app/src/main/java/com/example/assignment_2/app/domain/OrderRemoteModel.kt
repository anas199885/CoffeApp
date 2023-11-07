package com.example.assignment_2.app.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OrderRemoteModel(

    val drinkName: String,

    val drinkSize: String?,

    val drinkOptions: List<String>,

): Parcelable