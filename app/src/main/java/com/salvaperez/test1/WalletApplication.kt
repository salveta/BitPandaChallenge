package com.salvaperez.test1

import android.app.Application
import com.salvaperez.test1.data.di.initDI

class WalletApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

}