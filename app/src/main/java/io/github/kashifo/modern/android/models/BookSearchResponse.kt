package io.github.kashifo.modern.android.models

data class BookSearchResponse(
    val kind: String,
    val totalItems: Short,
    val items: ArrayList<GBook>
)