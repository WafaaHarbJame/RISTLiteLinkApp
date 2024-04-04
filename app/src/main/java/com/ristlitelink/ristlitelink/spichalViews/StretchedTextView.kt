package com.ristlitelink.ristlitelink.spichalViews



import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class StretchedTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var spacingExtra = 0f

    fun setSpacingExtra(px: Float) {
        spacingExtra = px
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        val text = text.toString()
        val paint = paint

        var x = 0f
        for (element in text) {
            val charString = element.toString()
            canvas.drawText(charString, x, baseline.toFloat(), paint)
            x += paint.measureText(charString) + spacingExtra
            // Add a condition for Arabic letters that you want to stretch
            if (element == 'ح' || element == 'ر' || element == 'ر' || element ==  'ت' || element == 'ف') {
                x += spacingExtra // increase extra spacing after specific characters
            }
        }
    }
}
