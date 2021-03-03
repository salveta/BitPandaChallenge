package com.salvaperez.test1.presentation.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmadrosid.svgloader.SvgLoader
import com.salvaperez.test1.R
import com.salvaperez.test1.domain.model.AssetModel
import com.salvaperez.test1.presentation.extensions.basicDiffUtil
import com.salvaperez.test1.domain.model.WalletModel
import com.salvaperez.test1.presentation.extensions.inflate
import kotlinx.android.synthetic.main.item_wallet.view.*

class MainAdapter(private val activity: MainActivity, private val listener: (AssetModel) -> Unit): RecyclerView.Adapter<MainAdapter.ViewHolder>(){

    var data: List<WalletModel> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new ->
            old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_wallet, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wallet = data[position]
        holder.bind(wallet, activity)

        holder.itemView.setOnClickListener {
            wallet.asset?.let {asset ->
                listener(asset)
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(wallet: WalletModel, activity: MainActivity) {
            wallet.asset?.logo?.let {logo ->
                SvgLoader.pluck()
                    .with(activity)
                    .load(logo, itemView.imgIcon)
            }


            itemView.txCurrency.text = wallet.asset?.symbol
            itemView.txBalance.text = wallet.balance.toString()
        }
    }
}