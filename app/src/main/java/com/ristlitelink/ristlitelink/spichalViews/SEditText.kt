package com.ristlitelink.ristlitelink.spichalViews



import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.ristlitelink.ristlitelink.classes.Constants



class SEditText : AppCompatEditText {
    constructor(context: Context?) : super(context!!) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context!!, attrs, defStyle
    ) {
        init()
    }

    private fun init() {

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            this.setImportantForAutofill(IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS);
//        }
        val typeface = Typeface.createFromAsset(context.assets, Constants.NORMAL_FONT)
        setTypeface(typeface)
    }

    override fun setSelection(start: Int, stop: Int) {
        throw RuntimeException("Stub!")
    }

    override fun setSelection(index: Int) {
        throw RuntimeException("Stub!")
    }

    override fun selectAll() {
        throw RuntimeException("Stub!")
    }
}
