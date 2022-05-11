package com.godzuche.artgallery

data class Art(
    val title: String,
    val artist: String,
    val year: String,
    val artResource: Int,
)

val arts = listOf(
    Art(
        title = "Orange Night Deer",
        artist = "Omk",
        year = "2021",
        artResource = R.drawable.omk_unsplash,
    ),
    Art(
        title = "Sculp",
        artist = "Simon Lee",
        year = "2021",
        artResource = R.drawable.simon_lee_unsplash,
    ),
    Art(
        title = "Human Flower",
        artist = "Simon Lee",
        year = "2022",
        artResource = R.drawable.simonlee_unsplash,
    )
)