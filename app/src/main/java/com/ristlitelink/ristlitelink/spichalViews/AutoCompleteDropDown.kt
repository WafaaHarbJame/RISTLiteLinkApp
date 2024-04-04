package com.ristlitelink.ristlitelink


import android.content.Context
import android.graphics.Rect
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.ListView
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import com.ristlitelink.ristlitelink.classes.Constants


class AutoCompleteDropDown : AppCompatAutoCompleteTextView {
    private val startClickTime: Long = 0
    private var isPopup = false

    //    @Override
    //    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
    //        Drawable dropdownIcon = ContextCompat.getDrawable(getContext(), R.drawable.ic_arrow_down);
    //        if (dropdownIcon != null) {
    //            right = dropdownIcon;
    //            right.mutate().setAlpha(5);
    //        }
    //        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
    //            super.setCompoundDrawablesRelativeWithIntrinsicBounds(left, top, right, bottom);
    //        } else {
    //            super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
    //        }
    //
    //    }
    private val mPosition = ListView.INVALID_POSITION

    constructor(context: Context?) : super(context!!) {
        init()
        //        setOnItemClickListener(this);
    }

    constructor(arg0: Context?, arg1: AttributeSet?) : super(arg0!!, arg1) {
        init()
        //        setOnItemClickListener(this);
    }

    constructor(arg0: Context?, arg1: AttributeSet?, arg2: Int) : super(arg0!!, arg1, arg2) {
        init()
        //        setOnItemClickListener(this);
    }

    private fun init() {
        val typeface = Typeface.createFromAsset(context.assets, Constants.NORMAL_FONT)
        setTypeface(typeface)
    }

    override fun enoughToFilter(): Boolean {
        return true
    }

    override fun onFocusChanged(
        focused: Boolean, direction: Int,
        previouslyFocusedRect: Rect?
    ) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
        try {
            if (focused) {
                performFiltering("", 0)
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(windowToken, 0)
                keyListener = null
                dismissDropDown()
            } else {
                isPopup = false
            }
        } catch (e: Exception) {
            e.printStackTrace()
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
            keyListener = null
            dismissDropDown()
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_UP -> {
                if (isPopup) {
                    dismissDropDown()
                } else {
                    try {
                        requestFocus()
                        showDropDown()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }

    override fun showDropDown() {
        super.showDropDown()
        isPopup = true
    }

    override fun dismissDropDown() {
        super.dismissDropDown()
        isPopup = false
    }

    companion object {
        //    implements AdapterView.OnItemClickListener
        private const val MAX_CLICK_DURATION = 200
    }
}