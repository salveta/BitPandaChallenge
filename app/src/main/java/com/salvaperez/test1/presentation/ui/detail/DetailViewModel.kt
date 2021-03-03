package com.salvaperez.test1.presentation.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.salvaperez.test1.domain.model.AssetModel
import com.salvaperez.test1.presentation.utils.Resource

class DetailViewModel: ViewModel() {

    private val _currency = MutableLiveData<Resource<AssetModel>>()
    val currency: LiveData<Resource<AssetModel>> get() = _currency

    fun onInit(currency: AssetModel?){
        currency?.let {
            _currency.value = Resource.success(currency)
        }?: run {
            _currency.value = Resource.error()
        }
    }
}