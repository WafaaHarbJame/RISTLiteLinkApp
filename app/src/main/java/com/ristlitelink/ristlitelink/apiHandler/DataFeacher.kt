package com.ristlitelink.ristlitelink.apiHandler

import android.app.Activity
import android.os.Environment
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rcontracts.myrcontracts.Utils.PathUtil
import com.rcontracts.myrcontracts.classes.UtilityApp
import com.ristlitelink.ristlitelink.classes.Constants
import com.ristlitelink.ristlitelink.classes.ResultAPIModel
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.net.NoRouteToHostException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.*


class DataFeacher {
    private val TAG = "Log"

    private var dataFetcherCallBack: DataFetcherCallBack? = null
    private var mainApiService: ApiInterface? = null
    private var mainCall: Call<Any?>? = null
    private var altCall: Call<Any?>? = null

    private var isCallAltApi = false
    private var lang: String? = null
    private var headerMap: MutableMap<String, Any> = HashMap()
    private var callbackApi: Callback<Any?>

    constructor() {

        mainApiService =
            ApiClient.getClient(UtilityApp.getBaseUrl())?.create(ApiInterface::class.java)!!

        dataFetcherCallBack = object : DataFetcherCallBack {
            override fun Result(obj: Any?, func: String?, otherData: Any?) {

            }
        }
        lang = if (UtilityApp.getLanguage() != null) {
            UtilityApp.getLanguage()
        } else {
            Locale.getDefault().language
        }
        headerMap["Accept"] = "application/json"
        headerMap["Content-Type"] = "application/json"
        headerMap["Accept-Language"] = lang.toString()

        if (UtilityApp.getUserToken()?.isNotEmpty() == true) {
            val accessToken = UtilityApp.getUserToken()
            headerMap["Authorization"] = Constants.TOKEN_PREFIX + accessToken
//            headerMap["ApiKey"] = Constants.TOKEN_PREFIX + accessToken

        }
        callbackApi = object : Callback<Any?> {
            override fun onResponse(call: Call<Any?>, response: Response<Any?>) {
                if (response.isSuccessful) {

//                    ResultAPIModel result = (ResultAPIModel) response.body();
                    dataFetcherCallBack?.Result(
                        response.body(), Constants.success, true
                    )

                } else {
                    var errorModel: ResultAPIModel<*>? = null
                    println("Log code" + response.code())

                    try {
                        val error = response.errorBody()?.string()
                        Log.e("Log", "Log error $error")
                        errorModel =
                            Gson().fromJson(error, object : TypeToken<ResultAPIModel<*>?>() {}.type)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    if (response.code() == 404 || response.code() == 443) {

                        if (isCallAltApi) dataFetcherCallBack?.Result(
                            errorModel, Constants.ERROR, false
                        )
                        else retryRequestWithNewUrl()


                    } else if (response.code() == 401) {
                        dataFetcherCallBack?.Result(errorModel, Constants.UnAuthorize, false)
                    } else {
                        dataFetcherCallBack?.Result(errorModel, Constants.ERROR, false)
                    }
                }
            }

            override fun onFailure(call: Call<Any?>, t: Throwable) {
                Log.d(
                    javaClass.simpleName, "Log fai call Url ${call.request().url().encodedPath()}"
                )
                t.printStackTrace()
                if (t is SocketTimeoutException) {
                    println("Log 404 not found change url")
                    if (isCallAltApi) dataFetcherCallBack?.Result(
                        null, Constants.NO_CONNECTION, false
                    )
                    else retryRequestWithNewUrl()
                } else if ((t is UnknownHostException || t is NoRouteToHostException)) {
                    dataFetcherCallBack?.Result(null, Constants.NO_CONNECTION, false)
                } else {
                    dataFetcherCallBack?.Result(
                        null, Constants.FAIL, false
                    )
                }
            }
        }
    }

    constructor(isLong: Boolean, callBack: DataFetcherCallBack?) {
        this.dataFetcherCallBack = callBack
        mainApiService = if (isLong) ApiClient.getLongClient(UtilityApp.getBaseUrl())
            ?.create(ApiInterface::class.java)!!
        else ApiClient.getClient(UtilityApp.getBaseUrl())?.create(ApiInterface::class.java)!!


        lang = if (UtilityApp.getLanguage() != null) {
            UtilityApp.getLanguage()
        } else {
            Locale.getDefault().language
        }
        headerMap["Accept-Language"] = lang.toString()
        headerMap["Accept"] = "application/json"
        headerMap["Content-Type"] = "application/json"
        if (UtilityApp.getUserToken()?.isNotEmpty() == true) {
            val accessToken = UtilityApp.getUserToken()
            headerMap["Authorization"] = Constants.TOKEN_PREFIX + accessToken
//                    headerMap["ApiKey"] = Constants.TOKEN_PREFIX + accessToken

        }
        callbackApi = object : Callback<Any?> {
            override fun onResponse(call: Call<Any?>, response: Response<Any?>) {
                val url = call.request().url().url().path
                println("Log url " + call.request().url())
                println(
                    "Log response time " + (response.raw()
                        .receivedResponseAtMillis() - response.raw().sentRequestAtMillis())
                )
                if (response.isSuccessful) {
                    dataFetcherCallBack?.Result(response.body(), Constants.success, true)

                } else {
                    var errorModel: ResultAPIModel<*>? = null
                    try {
                        val error = response.errorBody()!!.string()
                        Log.i("Log", "Log errorApiUrl $url")
                        Log.e("Log", "Log error $error")
                        Log.e("Log", "Log error code  " + response.code())

                        errorModel =
                            Gson().fromJson(error, object : TypeToken<ResultAPIModel<*>?>() {}.type)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    if (response.code() == 404 || response.code() == 443) {

                        println("Log 404 not found change url")
                        if (isCallAltApi) dataFetcherCallBack?.Result(
                            errorModel, Constants.ERROR, false
                        )
                        else retryRequestWithNewUrl()


                    } else if (response.code() == 401) {
                        dataFetcherCallBack?.Result(errorModel, Constants.UnAuthorize, false)
                    } else {
                        dataFetcherCallBack?.Result(errorModel, Constants.ERROR, false)
                    }
                }
            }

            override fun onFailure(call: Call<Any?>, t: Throwable) {
                t.printStackTrace()
                if (t is SocketTimeoutException) {
                    println("Log 404 not found change url")
                    if (isCallAltApi) dataFetcherCallBack?.Result(
                        null, Constants.NO_CONNECTION, false
                    )
                    else retryRequestWithNewUrl()
                } else if ((t is UnknownHostException || t is NoRouteToHostException)) {
                    dataFetcherCallBack?.Result(null, Constants.NO_CONNECTION, false)
                } else {
                    dataFetcherCallBack?.Result(null, Constants.FAIL, false)
                }
            }
        }
    }


    private fun retryRequestWithNewUrl() {
        isCallAltApi = true
        altCall?.enqueue(callbackApi)

    }





}