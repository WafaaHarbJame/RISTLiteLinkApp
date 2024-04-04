package com.ristlitelink.ristlitelink.apiHandler

interface DataFetcherCallBack {
    fun Result(
        obj: Any?,
        func: String?,
        otherData: Any?)
}
