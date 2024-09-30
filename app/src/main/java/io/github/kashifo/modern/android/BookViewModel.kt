package io.github.kashifo.modern.android

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.kashifo.modern.android.models.BookSearchResponse
import io.github.kashifo.modern.android.models.GBook
import io.github.kashifo.modern.android.utils.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BookViewModel : ViewModel() {

    private var movieLiveData = MutableLiveData<List<GBook>>()

    fun getPopularMovies() {
        ApiClient.apiService.searchBooks("steve", 0, 10).enqueue(object  : Callback<BookSearchResponse> {
            override fun onResponse(call: Call<BookSearchResponse>, response: Response<BookSearchResponse>) {
                if (response.body()!=null){
                    println("onResponse()")
                    println(response.body()?.items?.size)
                    println(response.body())
                    movieLiveData.value = response.body()!!.items!!
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<BookSearchResponse>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }

    fun observeMovieLiveData() : LiveData<List<GBook>> {
        return movieLiveData
    }
}