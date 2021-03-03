package com.salvaperez.test1.presentation.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.salvaperez.test1.R
import com.salvaperez.test1.domain.model.AssetModel
import com.salvaperez.test1.presentation.utils.Resource
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private val vModel: DetailViewModel by currentScope.viewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        vModel.onInit(intent.getParcelableExtra<AssetModel>(CURRENCY_DATA))
        loadObservers()
    }

    private fun loadObservers(){
        vModel.currency.observe(this, Observer { place ->
            when(place.status){
                Resource.Status.SUCCESS -> showData(place.data as AssetModel)
            }
        })

        toolbarDetail.setOnClickListener { finish() }
    }

    private fun showData(data: AssetModel){
        txtCurrencySymbol.text = data.symbol
        txtCurrencyPrice.text = data.price.toString()
    }

    companion object{
        const val CURRENCY_DATA = "components.data"
    }
}