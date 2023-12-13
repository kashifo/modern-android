package io.github.kashifo.modern.android.utils

import io.github.kashifo.modern.android.models.BookSearchResponse
import io.github.kashifo.modern.android.models.GBook
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("volumes")
    fun searchBooks(@Query("q") query:String, @Query("startIndex") startIndex:Int, @Query("maxResults") maxResults:Int ): Call<BookSearchResponse>

}