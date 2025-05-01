package com.example.notes.data


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.example.notes.ui.theme.LightAqua
import com.example.notes.ui.theme.LightBrown
import com.example.notes.ui.theme.LightGreen
import com.example.notes.ui.theme.LightPink
import kotlinx.datetime.LocalDateTime


data class Note(
    var id: Int,
    var title: String,
    var content: String,
    var createdAt: LocalDateTime,
    var color: Int
) {
    fun toColor(): Color = Color(color) // Convert Int to Color
    companion object {
        fun fromColor(): Int  {
            val colors = listOf<Color>(LightPink, LightAqua, LightBrown, LightGreen)
            return colors.random().toArgb()
        } // Convert Color to Int
    }

}