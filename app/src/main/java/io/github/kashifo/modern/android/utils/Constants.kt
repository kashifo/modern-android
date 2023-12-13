package io.github.kashifo.modern.android.utils

object Constants {

    @JvmStatic
    val BASE_URL = "https://www.googleapis.com/books/v1/"

    fun getSearchUrl(query: String): String {
        return "$BASE_URL/volumes?q=$query&startIndex=0&maxResults=20"
    }

    fun getBookDetailUrl(bookId: String): String {
        return "$BASE_URL/volumes/$bookId"
    }

}