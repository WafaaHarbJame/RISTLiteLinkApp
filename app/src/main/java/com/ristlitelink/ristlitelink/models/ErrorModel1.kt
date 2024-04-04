package com.ristlitelink.ristlitelink.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class ErrorModel1 {
    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("status")
    @Expose
    var status = 0

    @SerializedName("detail")
    @Expose
    var detail: String? = null

    @SerializedName("traceId")
    @Expose
    var traceId: String? = null

   var errors: Errors? = null
    class Errors {
        var recordAccessDenied: List<String>? = null

    }
}


