package io.github.kashifo.modern.android.utils

import android.app.Application

class MyApplication : Application() {

    companion object {
        private val TAG = MyApplication::class.java.simpleName
        @get:Synchronized
        var instance: MyApplication? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}
