package com.ristlitelink.ristlitelink.classes;


import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeErrorDialog
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeInfoDialog
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeProgressDialog
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeSuccessDialog
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.rcontracts.myrcontracts.classes.UtilityApp
import com.ristlitelink.ristlitelink.R


object GlobalData {
    const val hrmSite = "https://porequest.s3.us-east-1.amazonaws.com/"
    const val azurewebsites = "https://rcontracts.azurewebsites.net/"
    const val hrmWebsites = "https://ristdev.com:8085/"
    const val poRequestWebsites = "https://rporequest.azurewebsites.net/"
    const val backend = "/back-end/admin/"
    const val backendHrm = "/back-end/common/"
//    https://ristdev.com:8085/back-end/common/api/v1/auth/login

    //public static final String ApiURL = BaseURL + "api/";
    const val Api = "api/"
    const val COUNTRY = "BH"
    const val COUNTRY_AMOUR = "DM"

    var refresh_cart = false
    var sortType: Int = 0
    var refresh_points = false
    var Position = 0
    var EDIT_PROFILE = false
    var REFRESH_ADV = false
    var REFRESH_CART = false
    var CHAT_ID_OPEN = 0
    var errorDialog: AwesomeErrorDialog? = null
    var infoDialog: AwesomeInfoDialog? = null
    var successDialog: AwesomeSuccessDialog? = null
    var progressDialog: AwesomeProgressDialog? = null

    //============================================================================






    fun GlideImg(c: Context?, image: String?, placeholder: Int, imageView: ImageView?) {
        var photoUrl: String? = ""
        val requestOptions = RequestOptions()


        try {
            Glide.with(c!!).asBitmap().load(photoUrl.plus(image))
                .apply(requestOptions)
                .thumbnail(0.5f)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .placeholder(placeholder).into(imageView!!)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    fun GlideImgHr(c: Context?, image: String?, placeholder: Int, imageView: ImageView?) {
        var photoUrl: String? = ""
        val requestOptions = RequestOptions()
        photoUrl = UtilityApp.getHrmUrl()
        try {
            Glide.with(c!!).asBitmap().load(photoUrl.plus(image))
                .apply(requestOptions)
                .placeholder(placeholder).into(imageView!!)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    fun CoilImg(c: Context?, image: String?, placeholder: Int, imageView: ImageView?) {
        var photoUrl: String? = ""
        val requestOptions = RequestOptions()
        photoUrl = if (image != null && !image.isEmpty()) {
            image
        } else {
            UtilityApp.getUrl()
        }
        try {
            Glide.with(c!!).asBitmap().load(photoUrl)
                .apply(requestOptions)
                .thumbnail(0.5f)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .placeholder(placeholder).into(imageView!!)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    fun GlideImgGif(c: Context?, image: String?, placeholder: Int, imageView: ImageView?) {
        var photoUrl: String? = ""
        photoUrl = if (image != null && !image.isEmpty()) {
            image
        } else {
            UtilityApp.getUrl()
        }
        try {
            Glide.with(c!!).load(photoUrl).override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .placeholder(placeholder).into(
                    imageView!!
                )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun GlideImgWithTransform(
        c: Context?,
        image: String?,
        placeholder: Int,
        imageView: ImageView?
    ) {
        var photoUrl: String? = ""
        photoUrl = if (image != null && !image.isEmpty()) {
            image
        } else {
            UtilityApp.getUrl()
        }
        try {
            Glide.with(c!!).load(photoUrl)
                .transform(RoundedCorners(25))
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .placeholder(placeholder).into(imageView!!)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun GlideImgWeb(c: Context?, image: String?, placeholder: Int, imageView: ImageView?) {
        var photoUrl: String? = ""
        photoUrl = if (image != null && !image.isEmpty()) {
            image
        } else {
            UtilityApp.getUrl()
        }
        try {
            Glide.with(c!!).load(photoUrl) //                    .apply(requestOptions)
                //                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(14)))
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).placeholder(placeholder).into(
                    imageView!!
                )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    fun glideImagWithoutBase(c: Context?, photoUrl: String?, placeholder: Int, imageView: ImageView?) {

        try {
            Glide.with(c!!).load(photoUrl)
               .placeholder(placeholder).into(
                    imageView!!
                )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun GlideImgGifSize(c: Context, image: String?, placeholder: Int, imageView: ImageView?) {
        var photoUrl: String? = ""
        photoUrl = if (image != null && !image.isEmpty()) {
            image
        } else {
            UtilityApp.getUrl()
        }
        try {
            Glide.with(c).load(photoUrl).placeholder(placeholder).apply(
                RequestOptions().transform(
                    RoundedCorners(
                        c.resources.getDimension(com.intuit.sdp.R.dimen._8sdp).toInt()
                    )
                ).error(R.drawable.holder_image).skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
            )
                .into(imageView!!)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }




    fun progressDialog(c: Context?, title: Int, msg: Int) {
        if (progressDialog == null) {
            progressDialog = AwesomeProgressDialog(c)
            progressDialog?.setTitle(title)?.setMessage(msg)?.setColoredCircle(R.color.colorPrimaryDark)
                ?.setDialogIconAndColor(R.drawable.ic_dialog_info, R.color.white)?.setCancelable(false)
            progressDialog?.show()?.setOnDismissListener {
                progressDialog = null
            }
        }
    }

    fun hideProgressDialog() {
        if (progressDialog != null) progressDialog?.hide()
    }

    fun errorDialog(c: Context?, title: Int, msg: String?) {
        errorDialog = AwesomeErrorDialog(c)
        errorDialog?.setTitle(title)
        errorDialog?.setMessage(msg)
        errorDialog?.setColoredCircle(R.color.dialogErrorBackgroundColor)
            ?.setDialogIconAndColor(R.drawable.ic_dialog_error, R.color.white)?.setCancelable(true)
            ?.setButtonBackgroundColor(R.color.dialogErrorBackgroundColor)
            ?.setButtonText(c?.getString(R.string.ok))
            ?.setButtonBackgroundColor(R.color.dialogErrorBackgroundColor)
            ?.setErrorButtonClick { errorDialog?.hide() }

        errorDialog?.show()
    }

    fun errorDialogWithButton(c: Context, title: String?, msg: String?) {
        errorDialog = AwesomeErrorDialog(c)
        errorDialog!!.setTitle(title)
        errorDialog!!.setMessage(msg)
        errorDialog!!.setColoredCircle(R.color.dialogErrorBackgroundColor)
            .setDialogIconAndColor(
                com.awesomedialog.blennersilva.awesomedialoglibrary.R.drawable.ic_dialog_error,
                R.color.white
            ).setCancelable(true)
            .setButtonBackgroundColor(R.color.dialogErrorBackgroundColor)
            .setButtonText(c.getString(R.string.ok)).setErrorButtonClick { errorDialog!!.hide() }
        errorDialog!!.show()
    }


    fun infoDialog(c: Context?, title: String?, msg: String?) {
        infoDialog = AwesomeInfoDialog(c)
        infoDialog!!.setMessage(msg)
        infoDialog!!.setTitle(title)
        infoDialog!!.setColoredCircle(com.awesomedialog.blennersilva.awesomedialoglibrary.R.color.dialogInfoBackgroundColor)
            .setDialogIconAndColor(
                com.awesomedialog.blennersilva.awesomedialoglibrary.R.drawable.ic_dialog_info,
                R.color.white
            ).setCancelable(true)
        infoDialog!!.show()
    }

    fun successDialog(c: Context?, title: String?, msg: String?) {
        successDialog = AwesomeSuccessDialog(c)
        successDialog!!.setTitle(title).setMessage(msg)
            .setColoredCircle(com.awesomedialog.blennersilva.awesomedialoglibrary.R.color.dialogSuccessBackgroundColor)
            .setDialogIconAndColor(R.drawable.ic_check, R.color.white).setCancelable(true)
        successDialog!!.show()
    }

    fun Toast(context: Context?, msg: String?) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun Toast(context: Context, resId: Int) {
        Toast.makeText(context, context.getString(resId), Toast.LENGTH_SHORT).show()
    }

    fun ToastLong(context: Context, resId: Int) {
        Toast.makeText(context, context.getString(resId), Toast.LENGTH_LONG).show()
    }
    fun getIntro(countryCode: String): String {
        var introStr = "3"
        val hashMap = HashMap<String, String>()

        // country Id :4 ,country name Oman
        // country Id :17 ,country name Bahrain
        // country Id :117 ,country name Kuwait
        // country Id :178 ,country name Qatar
        // country Id :191 ,country name Saudi_Arabia
        // country Id :229 ,country name United_Arab_Emirates_ar
        hashMap["968"] = "9"
        hashMap["973"] = "3"
        hashMap["965"] = "6"
        hashMap["974"] = "5"
        hashMap["966"] = "5"
        hashMap["971"] = "5"
        introStr = if (countryCode == "966" || countryCode == "971") {
            hashMap[countryCode].toString() + "xxxxxxxxx"
        } else {
            hashMap[countryCode].toString() + "xxxxxxxx"
        }
        return introStr
    }




    fun getFilePath(context: Context): String {

        return context.getExternalFilesDir(null).toString()
    }

}
