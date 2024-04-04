package com.ristlitelink.ristlitelink.classes

import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class GridItem(
    val id: String,
    val backgroundColor: Color,
    val imageIcon: Painter,
    val text: String
)
