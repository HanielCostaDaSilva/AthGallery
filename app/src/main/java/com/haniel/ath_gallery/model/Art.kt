package com.haniel.ath_gallery.model

import androidx.compose.ui.graphics.painter.Painter

data class Art(
    var imageID: Int,
    var title: String,
    var author: String,
    var year: Int
)