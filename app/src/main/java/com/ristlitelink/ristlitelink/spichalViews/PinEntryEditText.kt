package com.ristlitelink.ristlitelink.spichalViews


import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.ristlitelink.ristlitelink.R
import com.ristlitelink.ristlitelink.RootApplication.Companion.instance


@SuppressLint("AppCompatCustomView")
class PinEntryEditText : EditText {
    var mSpace = 24f //24 dp by default
    var mCharSize = 0f
    var mNumChars = 4f
    var mLineSpacing = 8f //8dp by default
    private var mLineStroke = 1f //1dp by default
    private var mLinesPaint: Paint? = null
    var mStates = arrayOf(intArrayOf(android.R.attr.state_focused), intArrayOf(-android.R.attr.state_focused))
    var mColors = intArrayOf(
        ContextCompat.getColor(instance!!, R.color.colorPrimaryDark),
        ContextCompat.getColor(instance!!, R.color.colorPrimaryDark)
    )
    var mColorStates = ColorStateList(mStates, mColors)
    private fun getColorForState(vararg states: Int): Int {
        return mColorStates.getColorForState(states, Color.GRAY)
    }

    private var mClickListener: OnClickListener? = null

    /* next = is the current char the next character to be input? */
    private fun updateColorForLines(next: Boolean) {
        if (isFocused) {
            mLinesPaint!!.color = getColorForState(android.R.attr.state_focused)
            if (next) {
                mLinesPaint!!.color = getColorForState(android.R.attr.state_selected)
            }
        } else {
            mLinesPaint!!.color = getColorForState(-android.R.attr.state_focused)
        }
    }

    constructor(context: Context?) : super(context) {}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(
        context: Context, attrs: AttributeSet,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context, attrs: AttributeSet,
        defStyleAttr: Int, defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        setBackgroundResource(0)
        val multi = context.resources.displayMetrics.density
        mLineStroke = multi * mLineStroke
        mLinesPaint = Paint(paint)
        mLinesPaint!!.strokeWidth = mLineStroke
        mSpace = multi * mSpace //convert to pixels for our density
        mLineSpacing = multi * mLineSpacing //convert to pixels
        //        mMaxLength = attrs.getAttributeIntValue(
//                XML_NAMESPACE_ANDROID, "maxLength", 4);
//        mNumChars = mMaxLength;

        //Disable copy paste
        super.setCustomSelectionActionModeCallback(
            object : ActionMode.Callback {
                override fun onPrepareActionMode(
                    mode: ActionMode,
                    menu: Menu
                ): Boolean {
                    return false
                }

                override fun onDestroyActionMode(mode: ActionMode) {}
                override fun onCreateActionMode(
                    mode: ActionMode,
                    menu: Menu
                ): Boolean {
                    return false
                }

                override fun onActionItemClicked(
                    mode: ActionMode,
                    item: MenuItem
                ): Boolean {
                    return false
                }
            })
        //When tapped, move cursor to end of the text
        super.setOnClickListener { v ->
            setSelection(text.length)
            if (mClickListener != null) {
                mClickListener!!.onClick(v)
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas);
        val availableWidth = width - paddingRight - paddingLeft
        mCharSize = if (mSpace < 0) {
            availableWidth / (mNumChars * 2 - 1)
        } else {
            (availableWidth - mSpace * (mNumChars - 1)) / mNumChars
        }
        var startX = paddingLeft
        val bottom = height - paddingBottom

        //Text Width
        val text = text
        val textLength = text.length
        val textWidths = FloatArray(textLength)
        paint.getTextWidths(getText(), 0, textLength, textWidths)
        var i = 0
        while (i < mNumChars) {
            updateColorForLines(i == textLength)
            canvas.drawLine(
                startX.toFloat(), bottom.toFloat(), startX + mCharSize, bottom.toFloat(), mLinesPaint!!
            )
            if (getText().length > i) {
                val middle = startX + mCharSize / 2
                canvas.drawText(
                    text,
                    i,
                    i + 1,
                    middle - textWidths[0] / 2,
                    bottom - mLineSpacing,
                    paint
                )
            }
            startX += if (mSpace < 0) {
                (mCharSize * 2).toInt()
            } else {
                (mCharSize + mSpace).toInt()
            }
            i++
        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        mClickListener = l
    }

    override fun setCustomSelectionActionModeCallback(actionModeCallback: ActionMode.Callback) {
        throw RuntimeException("setCustomSelectionActionModeCallback() not supported.")
    }
}