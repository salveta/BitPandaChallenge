package com.salvaperez.test1.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AssetModel( var precision: Int = 0,
                       var name: String = "",
                       var symbol: String = "",
                       var id: String = "",
                       var price: String,
                       val logo: String = ""): Parcelable