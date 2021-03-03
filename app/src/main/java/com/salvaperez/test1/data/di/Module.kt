package com.salvaperez.test1.data.di

import android.app.Application
import com.salvaperez.test1.data.datasource.DummyWebService
import com.salvaperez.test1.data.repository.WalletDataRepository
import com.salvaperez.test1.data.repository.WalletHelper
import com.salvaperez.test1.domain.repository.WalletRepository
import com.salvaperez.test1.domain.use_case.GetCurrency
import com.salvaperez.test1.domain.use_case.GetWallets
import com.salvaperez.test1.presentation.ui.detail.DetailActivity
import com.salvaperez.test1.presentation.ui.detail.DetailViewModel
import com.salvaperez.test1.presentation.ui.main.MainActivity
import com.salvaperez.test1.presentation.ui.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(
            listOf(
                wallet
            )
        )
    }
}

val wallet = module(override = true) {
    scope(named<MainActivity>()) {
        viewModel {
            MainViewModel(
                get(), get()
            )
        }

        scoped { GetWallets(get()) }
        scoped { GetCurrency(get()) }

    }

    single { DummyWebService() }
    single { WalletHelper() }

    factory<WalletRepository> {
        WalletDataRepository(get())
    }

    scope(named<DetailActivity>()) {
        viewModel {
            DetailViewModel()
        }
    }
}