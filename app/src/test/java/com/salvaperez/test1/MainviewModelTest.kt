package com.salvaperez.test1

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.whenever
import com.salvaperez.test1.domain.use_case.GetCurrency
import com.salvaperez.test1.domain.use_case.GetWallets
import com.salvaperez.test1.presentation.ui.main.MainViewModel
import com.salvaperez.test1.presentation.utils.Resource
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var getWallets: GetWallets

    @Mock
    lateinit var getCurrency: GetCurrency

    private lateinit var vm: MainViewModel

    private val uiScope = CoroutineScope(Dispatchers.Main)


    @Before
    fun setUp() {
        vm = MainViewModel(getWallets, getCurrency)
    }

    @Test
    fun `get wallets return object`() {
        uiScope.launch {
            whenever(getWallets.invoke( onGetWalletSuccess = {
                val resource = vm.wallets.value
                assertEquals(resource?.status, Resource.Status.SUCCESS)
            }, onGetWalletError = {})).thenReturn(Unit)
        }
    }

    @Test
    fun `get currencies return object`() {
        uiScope.launch {
            whenever(getCurrency.invoke( onGetCurrencySuccess = {
                val resource = vm.wallets.value
                assertEquals(resource?.status, Resource.Status.SUCCESS)
            }, onGetCurrencyError = {})).thenReturn(Unit)
        }
    }
}