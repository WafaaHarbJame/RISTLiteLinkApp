package com.ristlitelink.ristlitelink.models

import java.io.Serializable

data class SupplierInfo(
    val supplierName: String,
    val currencyCode: String,
    val code: String,
    val currencyRate: String,
    val vatNo: String
):Serializable
