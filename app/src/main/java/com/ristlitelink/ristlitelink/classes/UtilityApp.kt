package com.rcontracts.myrcontracts.classes

import android.os.Build
import android.provider.Settings
import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ristlitelink.ristlitelink.RootApplication.Companion.instance
import com.ristlitelink.ristlitelink.Utils.LocaleUtils
import com.ristlitelink.ristlitelink.classes.Constants
import com.ristlitelink.ristlitelink.classes.GlobalData
import java.util.*


object UtilityApp {
    val deviceId: String
        get() = Settings.Secure.getString(instance?.contentResolver, Settings.Secure.ANDROID_ID)




    private fun setUserToken(userToken: String?) {
        instance?.sharedPManger?.SetData(Constants.KEY_TOKEN, userToken)
    }

    fun getFcmToken(): String? {
        return instance?.sharedPManger?.getDataString(Constants.KEY_FCM_TOKEN, "")
    }

     fun setFcmToken(fcmToken: String?) {
        instance?.sharedPManger?.SetData(Constants.KEY_FCM_TOKEN, fcmToken)
    }

    fun getUserToken(): String? {
        return instance?.sharedPManger?.getDataString(Constants.KEY_TOKEN, "")
    }

    fun getRefreshToken(): String? {
        return instance?.sharedPManger?.getDataString(Constants.KEY_REFRESH_TOKEN, "")
    }

    //
//    fun setRefreshToken(refreshToken: String?) {
//        instance?.sharedPManger?.SetData(Constants.KEY_REFRESH_TOKEN, refreshToken)
//    }
//
    fun isLogin(): Boolean {
        val userToken = instance?.sharedPManger?.getDataBool(Constants.KEY_LOGIN)
        return userToken != null
    }


    fun setLogin(login: Boolean?) {
        instance?.sharedPManger?.SetData(Constants.KEY_LOGIN, login)
    }

    fun getIsLogin(): Boolean? {
        return instance?.sharedPManger?.getDataBool(Constants.KEY_LOGIN, false)
    }

    //
    fun logOut() {
//        instance?.sharedPManger?.SetData(Constants.KEY_MEMBER, null)
        instance?.sharedPManger?.SetData(Constants.KEY_LOGIN, false)
        instance?.sharedPManger?.SetData(Constants.KEY_LOGIN_PREFERANCE, null)
        instance?.sharedPManger?.SetData(Constants.DB_TOTAL_POINTS, null)
        instance?.sharedPManger?.SetData(Constants.DB_COUPON_SETTINGS, null)
        instance?.sharedPManger?.SetData(Constants.DB_TOTAL_POINTS, null)
        instance?.sharedPManger?.SetData(Constants.KEY_CART_SIZE, null)
        instance?.sharedPManger?.SetData(Constants.KEY_DINNERS, null)
        instance?.sharedPManger?.SetData(Constants.KEY_BANNER, null)
        instance?.sharedPManger?.SetData(Constants.KEY_SLIDER, null)
        instance?.sharedPManger?.SetData(Constants.KEY_SOCIAL, null)
        instance?.sharedPManger?.SetData(Constants.KEY_SETTING, null)
        instance?.sharedPManger?.SetData(Constants.DB_loyal, null)
        instance?.sharedPManger?.SetData(Constants.KEY_SCAN_SOUND, null)
        instance?.sharedPManger?.SetData(Constants.KEY_SCAN_AGAIN, null)
        instance?.sharedPManger?.SetData(Constants.KEY_CART_FASTQ_Total, null)
        instance?.sharedPManger?.SetData(Constants.KEY_CART_FASTQ_SIZE, null)
        instance?.sharedPManger?.RemoveData(Constants.KEY_LOGIN_PREFERANCE)
        instance?.sharedPManger?.RemoveData(Constants.DB_TOTAL_POINTS)
        instance?.sharedPManger?.RemoveData(Constants.DB_COUPON_SETTINGS)
        instance?.sharedPManger?.RemoveData(Constants.KEY_CART_SIZE)
        instance?.sharedPManger?.RemoveData(Constants.KEY_DINNERS)
        instance?.sharedPManger?.RemoveData(Constants.KEY_BANNER)
        instance?.sharedPManger?.RemoveData(Constants.KEY_SLIDER)
        instance?.sharedPManger?.RemoveData(Constants.KEY_SOCIAL)
        instance?.sharedPManger?.RemoveData(Constants.KEY_SETTING)
        instance?.sharedPManger?.RemoveData(Constants.DB_loyal)
//        instance?.sharedPManger?.RemoveData(Constants.KEY_MEMBER)
        instance?.sharedPManger?.RemoveData(Constants.KEY_SCAN_SOUND)
        instance?.sharedPManger?.RemoveData(Constants.KEY_SCAN_AGAIN)
        instance?.sharedPManger?.RemoveData(Constants.KEY_CART_FASTQ_Total)
        instance?.sharedPManger?.RemoveData(Constants.KEY_CART_FASTQ_SIZE)
//        instance?.sharedPManger?.RemoveData(Constants.KEY_TOKEN)
//        instance?.sharedPManger?.RemoveData(Constants.KEY_FCM_TOKEN)
    }

    //
//    fun setToShPref(key: String?, data: String?) {
//        instance?.sharedPManger?.SetData(key, data)
//    }
//
//    fun setToShPref(key: String?, data: Boolean) {
//        instance?.sharedPManger?.SetData(key, data)
//    }
//
//    fun getFromShPref(key: String?): String? {
//        return instance?.sharedPManger?.getDataString(key)
//    }
//
//    fun getFCMToken(): String? {
//        return instance?.sharedPManger?.getDataString(Constants.KEY_FIREBASE_TOKEN)
//    }
//
//    fun setFCMToken(fcmToken: String?) {
//        instance?.sharedPManger?.SetData(Constants.KEY_FIREBASE_TOKEN, fcmToken)
//    }
//
    fun getLanguage(): String? {
        return instance?.sharedPManger?.getDataString(Constants.KEY_MEMBER_LANGUAGE)
    }

    fun setLanguage(language: String?) {
        instance?.sharedPManger?.SetData(Constants.KEY_MEMBER_LANGUAGE, language)
    }

    //
//    fun getNormalDelivery(): String? {
//        return instance?.sharedPManger?.getDataString(Constants.KEY_NORMAL_DELIVERY)
//    }
//
//    fun setNormalDelivery(normalDelivery: String?) {
//        instance?.sharedPManger?.SetData(Constants.KEY_NORMAL_DELIVERY, normalDelivery)
//    }
//
    fun setAppLanguage() {
        var lang = getLanguage()
        if (lang == null) lang = Constants.English
        LocaleUtils.setLocale(Locale(lang))
        LocaleUtils.updateConfig(instance, instance?.resources?.configuration)
    }

    //
//    fun getUserData(): MemberModel? {
//        val userJsonData = instance?.sharedPManger?.getDataString(Constants.KEY_MEMBER)
//        return Gson().fromJson(userJsonData, MemberModel::class.java)
//    }
//
//    fun setUserData(user: MemberModel?) {
//        setUserToken(user?.accessToken)
//        val userData = Gson().toJson(user)
//        instance?.sharedPManger?.SetData(Constants.KEY_MEMBER, userData)
//    }
//
//
//    fun getOrganizationData(): MutableList<OrganizationModel?>? {
//        val dataString = instance?.sharedPManger?.getDataString(Constants.KEY_ORGANIZATION)
//        return if (dataString?.isNotEmpty() == true) Gson().fromJson(
//            dataString,
//            object : TypeToken<MutableList<OrganizationModel?>?>() {}.type
//        ) else null
//    }
//
//    fun setOrganizationData(countryModelList: MutableList<OrganizationModel?>?) {
//        val userData = Gson().toJson(countryModelList)
//        instance?.sharedPManger?.SetData(Constants.KEY_ORGANIZATION, userData)
//    }
//
//
//
//
//    fun getLevelTypeData(): MutableList<LevelTypeModel?>? {
//        val dataString = instance?.sharedPManger?.getDataString(Constants.KEY_LEVEL_TYPE)
//        return if (dataString?.isNotEmpty() == true) Gson().fromJson(
//            dataString,
//            object : TypeToken<MutableList<LevelTypeModel?>?>() {}.type
//        ) else null
//    }
//
//    fun setLevelTypeData(countryModelList: MutableList<LevelTypeModel?>?) {
//        val userData = Gson().toJson(countryModelList)
//        instance?.sharedPManger?.SetData(Constants.KEY_LEVEL_TYPE, userData)
//    }
//
//
//
//    fun getDepartmentData(): MutableList<DepartmentModel?>? {
//        val dataString = instance?.sharedPManger?.getDataString(Constants.KEY_DEPARTMENTS)
//        return if (dataString?.isNotEmpty() == true) Gson().fromJson(
//            dataString,
//            object : TypeToken<MutableList<DepartmentModel?>?>() {}.type
//        ) else null
//    }
//
//    fun setDepartmentData(list: MutableList<DepartmentModel?>?) {
//        val userData = Gson().toJson(list)
//        instance?.sharedPManger?.SetData(Constants.KEY_DEPARTMENTS, userData)
//    }
//
//
//
//
//
//    fun getRequestStatusData(): MutableList<RequestStatusModel?>? {
//        val dataString = instance?.sharedPManger?.getDataString(Constants.KEY_REQUEST_STATUS)
//        return if (dataString?.isNotEmpty() == true) Gson().fromJson(
//            dataString,
//            object : TypeToken<MutableList<RequestStatusModel?>?>() {}.type
//        ) else null
//    }
//
//    fun setRequestStatusData(list: MutableList<RequestStatusModel?>?) {
//        val userData = Gson().toJson(list)
//        instance?.sharedPManger?.SetData(Constants.KEY_REQUEST_STATUS, userData)
//    }
//
//
//    fun getCountryCodeData(): MutableList<CountryModel?>? {
//        val dataString = instance?.sharedPManger?.getDataString(Constants.KEY_COUNTRIES)
//        return if (dataString?.isNotEmpty() == true) Gson().fromJson(
//            dataString,
//            object : TypeToken<MutableList<CountryModel?>?>() {}.type
//        ) else null
//    }
//
//    fun setCountryCodeData(list: MutableList<CountryModel?>?) {
//        val userData = Gson().toJson(list)
//        instance?.sharedPManger?.SetData(Constants.KEY_COUNTRIES, userData)
//    }
//
//
//    fun getFacilityData(): MutableList<FaclityModel?>? {
//        val dataString = instance?.sharedPManger?.getDataString(Constants.KEY_FACLITY)
//        return if (dataString?.isNotEmpty() == true) Gson().fromJson(
//            dataString,
//            object : TypeToken<MutableList<FaclityModel?>?>() {}.type
//        ) else null
//    }
//
//    fun setFacilityData(list: MutableList<FaclityModel?>?) {
//        val userData = Gson().toJson(list)
//        instance?.sharedPManger?.SetData(Constants.KEY_FACLITY, userData)
//    }
//
//
//    fun getCurrencyData(): MutableList<CurrencyModel?>? {
//        val dataString = instance?.sharedPManger?.getDataString(Constants.KEY_CURRENCY)
//        return if (dataString?.isNotEmpty() == true) Gson().fromJson(
//            dataString,
//            object : TypeToken<MutableList<CurrencyModel?>?>() {}.type
//        ) else null
//    }
//
//    fun setCurrencyData(list: MutableList<CurrencyModel?>?) {
//        val userData = Gson().toJson(list)
//        instance?.sharedPManger?.SetData(Constants.KEY_CURRENCY, userData)
//    }
//

    fun getUrl(): String? {
        return instance?.sharedPManger?.getDataString(Constants.KEY_URL, GlobalData.azurewebsites)
    }




    fun getHrmUrl(): String? {
        return instance?.sharedPManger?.getDataString(Constants.KEY_URL, GlobalData.hrmSite)
    }
    fun setUrl(url: String?) {
        instance?.sharedPManger?.SetData(Constants.KEY_URL, url)
    }


    fun getAccountType(): String? {
        return instance?.sharedPManger?.getDataString(
            Constants.KEY_ACCOUNT_TYPE,
            GlobalData.azurewebsites
        )
    }

    fun setAccountType(type: String?) {
        instance?.sharedPManger?.SetData(Constants.KEY_ACCOUNT_TYPE, type)
    }


    fun getBaseUrl(): String? {
        return instance?.sharedPManger?.getDataString(
            Constants.KEY_BASE_URL,
            GlobalData.azurewebsites
        )
    }

    fun setBaseUrl(url: String?) {
        instance?.sharedPManger?.SetData(Constants.KEY_BASE_URL, url)
    }


    fun getDeviceModel(): String {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        return if (model.startsWith(manufacturer)) {
            capitalize(model)
        } else capitalize(manufacturer) + " " + model
    }
    fun getDeviceManufacturer(): String? {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        return model
    }



    private fun capitalize(str: String): String {
        if (TextUtils.isEmpty(str)) {
            return str
        }
        val arr = str.toCharArray()
        var capitalizeNext = true
        val phrase = StringBuilder()
        for (c in arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(c.uppercaseChar())
                capitalizeNext = false
                continue
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true
            }
            phrase.append(c)
        }
        return phrase.toString()
    }

}
