package com.ristlitelink.ristlitelink.spichalViews



import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputLayout
import com.ristlitelink.ristlitelink.classes.Constants


class STextInputLayout : TextInputLayout {
    constructor(context: Context?) : super(context!!) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context!!, attrs, defStyle
    ) {
        init()
    }

    private fun init() {
        val typeface = Typeface.createFromAsset(context.assets, Constants.NORMAL_FONT)
        setTypeface(typeface)
    }
}