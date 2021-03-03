package com.salvaperez.test1.presentation.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.salvaperez.test1.R
import com.salvaperez.test1.domain.model.WalletModel
import com.salvaperez.test1.presentation.extensions.invisible
import com.salvaperez.test1.presentation.extensions.open
import com.salvaperez.test1.presentation.extensions.visible
import com.salvaperez.test1.presentation.ui.detail.DetailActivity
import com.salvaperez.test1.presentation.utils.Resource
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import com.salvaperez.test1.domain.model.AssetModel

class MainActivity : AppCompatActivity() {

    private val vModel: MainViewModel by currentScope.viewModel(this)
    private lateinit var adapterMain: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vModel.onStart()
        initViews()
        loadObservers()
    }

    private fun initViews() {
        adapterMain = MainAdapter(this@MainActivity){
            onclick(it)
        }

        rvWallet.layoutManager = LinearLayoutManager(this)
        rvWallet.adapter = adapterMain


        btnFilterCurrencies.setOnClickListener {
            vModel.filterCurrencies()
        }
    }

    private fun loadObservers() {
        vModel.wallets.observe(this, Observer { products ->
            when(products.status){
                Resource.Status.SUCCESS -> showAirQuality(products.data as List<WalletModel>)
                Resource.Status.ERROR -> showError()
                Resource.Status.LOADING -> loading(products.data as Boolean)
            }
        })
    }

    private fun showAirQuality(data: List<WalletModel>){
        adapterMain.data = data
    }

    private fun loading(isLoading: Boolean) {
        if(isLoading) {
            progressBar.visible()
        } else {
            progressBar.invisible()
        }
    }

    private fun showError(){
        Toast.makeText(this@MainActivity, getString(R.string.no_data), Toast.LENGTH_SHORT).show()
    }

    private fun onclick(data: AssetModel){
        val extras = Bundle()
        extras.putParcelable(DetailActivity.CURRENCY_DATA, data)
        open(DetailActivity::class.java, extras)
    }
}