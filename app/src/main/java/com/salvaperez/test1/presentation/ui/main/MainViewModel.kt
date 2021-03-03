package com.salvaperez.test1.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salvaperez.test1.domain.model.WalletModel
import com.salvaperez.test1.domain.use_case.GetCurrency
import com.salvaperez.test1.domain.use_case.GetWallets
import com.salvaperez.test1.presentation.utils.Resource
import kotlinx.coroutines.async

class MainViewModel(private val getWallets: GetWallets, private val getCurrency: GetCurrency): ViewModel() {

    private val _wallets = MutableLiveData<Resource<List<WalletModel>>>()
    val wallets: LiveData<Resource<List<WalletModel>>> get() = _wallets

    fun onStart() {
        viewModelScope.async {
            getWallets(onGetWalletError = {}, onGetWalletSuccess = {})
            getWallets(onGetWalletError = {}, onGetWalletSuccess = {updateData(it)})
        }
    }

    fun filterCurrencies(){
        viewModelScope.async {
            getCurrency(onGetCurrencySuccess = {updateData(it)}, onGetCurrencyError = {})
        }
    }

    private fun updateData(data: List<WalletModel>){
        _wallets.value = Resource.loading(false)
        _wallets.value = Resource.success(data)
    }
}