package com.haniel.ath_gallery.repository

import com.haniel.ath_gallery.R
import com.haniel.ath_gallery.model.Art

class Arts {
    private val data = mutableListOf<Art>(
        Art(R.drawable.filha_reverendo, "Filha do Reverendo", "Leonardo", 2024),
        Art(R.drawable.moinho_de_vento, "A Ilusão", "Leonardo", 2024),
        Art(R.drawable.governantes, "Os Ìdolos", "Leonardo", 2024),
        Art(R.drawable.midia, "Os Mensageiros", "Leonardo", 2024),
        Art(R.drawable.militares, "Braço Forte", "Leonardo", 2024),
        Art(R.drawable.plebe, "O Guia", "Leonardo", 2024),
        )

    operator fun get(index: Int): Art {
        return data[index % data.size]
    }

    fun getArt(index: Int): Art {
        return data[index % data.size]
    }

    fun size():Int{
        return data.size
    }

}