package io.github.kashifo.modern.android.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.github.kashifo.modern.android.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val retrofit: Retrofit by lazy {
        var client = OkHttpClient.Builder().build()
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            client = OkHttpClient.Builder() //.addNetworkInterceptor(new StethoInterceptor())
                .addInterceptor(interceptor).build()
        }

        Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }
}

private fun getGson(): Gson {
    return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
}

object ApiClient {
    val apiService: ApiService by lazy {
        RetrofitClient.retrofit.create(ApiService::class.java)
    }
}