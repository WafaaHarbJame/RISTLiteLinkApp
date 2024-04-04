package com.ristlitelink.ristlitelink.apiHandler

import android.util.Log
import com.google.gson.GsonBuilder

import com.ristlitelink.ristlitelink.classes.GlobalData
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiClient {
    //var BASE_URL = "https://rcontracts.azurewebsites.net/back-end/admin/"
   // var BASE_URL = "https://ristdev.com:8085/back-end/common/"
    var BASE_URL = ""
    private var retrofit: Retrofit? = null
    private var retrofitLong: Retrofit? = null
    private var country: String? = null
    var apiPath = ""

    fun getClient(currBaseUrl: String?): Retrofit? {


//        apiPath = if(UtilityApp.getAccountType()==Constants.HRM_TYPE){
//            GlobalData.backendHrm
//        } else{
//            GlobalData.backend
//        }

       // BASE_URL = "$currBaseUrl$apiPath${GlobalData.Api}"
        BASE_URL = currBaseUrl?: GlobalData.azurewebsites
        Log.i("TAG", "Log BASE_URL $BASE_URL")
        val gson = GsonBuilder().setLenient().create()
        //        if (retrofit == null) {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson)).client(okClient).build()
        //        }
        return retrofit
    }

    fun getLongClient(currBaseUrl: String?): Retrofit? {

//        apiPath = if(UtilityApp.getAccountType()==Constants.HRM_TYPE){
//            GlobalData.backendHrm
//        } else{
//            GlobalData.backend
//        }

        BASE_URL = currBaseUrl?:GlobalData.hrmWebsites

        val gson = GsonBuilder().setLenient().create()


//        if (retrofitLong == null) {
        retrofitLong = Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson))
            .client(getLongOkClient()).build()
        //        }
        return retrofitLong
    }

    private val okClient: OkHttpClient
        get() {
            val interceptor = Interceptor { chain: Interceptor.Chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .header("Accept", "application/json,*/*")
                    .header("Connection", "close")
                    .method(original.method(), original.body())
                    .build()
                chain.proceed(request)
            }
            return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
        }

    private fun getLongOkClient(): OkHttpClient {
        val interceptor = Interceptor { chain: Interceptor.Chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("Accept", "application/json")
                .header("Connection", "close")
                .method(original.method(), original.body())
                .build()
            chain.proceed(request)
        }
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(20, TimeUnit.MINUTES)
            .readTimeout(20, TimeUnit.MINUTES)
            .writeTimeout(20, TimeUnit.MINUTES)
            .build()
    }
}