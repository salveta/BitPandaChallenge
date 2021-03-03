package com.salvaperez.test1

import com.salvaperez.test1.data.api.ApiResult
import com.salvaperez.test1.data.repository.WalletHelper
import com.salvaperez.test1.domain.model.AssetCode
import com.salvaperez.test1.domain.model.AssetModel
import com.salvaperez.test1.domain.model.WalletModel
import com.salvaperez.test1.utils.DummyDataTest
import org.assertj.core.api.Assertions
import org.junit.Test

class WalletHelperTest {

    @Test
    fun `parse wallet with fiat, cryptocoins, metals and the balance of the wallet and only no delete wallets`() {
        val value = walletModelValue()
        val result = WalletHelper().parseWallets(DummyDataTest.dummyCryptoWalletList,
        DummyDataTest.dummyEURWallet, DummyDataTest.dummyMetalWalletList)
        Assertions.assertThat(result).isEqualTo(value)
    }

    @Test
    fun `get filter by Crypto`() {
        val value = cryptoWallet()
        WalletHelper().parseWallets(DummyDataTest.dummyCryptoWalletList,
                DummyDataTest.dummyEURWallet, DummyDataTest.dummyMetalWalletList)
        val result = WalletHelper().getRandomCurrency(0)
        Assertions.assertThat(result).isEqualTo(value)
    }

    @Test
    fun `get filter by Metal`() {
        val value = metalWallet()
        WalletHelper().parseWallets(DummyDataTest.dummyCryptoWalletList,
                DummyDataTest.dummyEURWallet, DummyDataTest.dummyMetalWalletList)
        val result = WalletHelper().getRandomCurrency(1)
        Assertions.assertThat(result).isEqualTo(value)
    }


    @Test
    fun `get filter by Fiat`() {
        val value = fiatWallet()
        WalletHelper().parseWallets(DummyDataTest.dummyCryptoWalletList,
                DummyDataTest.dummyEURWallet, DummyDataTest.dummyMetalWalletList)
        val result = WalletHelper().getRandomCurrency(2)
        Assertions.assertThat(result).isEqualTo(value)
    }

    private fun walletModelValue(): ApiResult.Success<List<WalletModel>> {
        val wallet : MutableList<WalletModel> = ArrayList()
        wallet.add( WalletModel(id = "1", walletId = AssetCode.FIAT, coinId = "1", isDefault = false, balance = 400.0, deleted = false, name = "EUR Wallet",
                asset = AssetModel(precision = 2, name = "Euro", symbol = "EUR", id = "1", price = "1.0 €", logo = "https://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/fiat/usd.svg")))
        wallet.add(WalletModel(id="2", walletId= AssetCode.FIAT, coinId="2", isDefault=false, balance=0.0, deleted=false, name="CHF Wallet",
                asset=AssetModel(precision=2, name="Swiss Franc", symbol="CHF", id="2", price="1.0 €", logo="https://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/fiat/chf.svg")))
        wallet.add(WalletModel(id="4", walletId= AssetCode.CRYPTO, coinId="3", isDefault=false, balance=2304.04, deleted=false, name="Test Ripple Wallet",
                asset=AssetModel(precision=4, name="Ripple", symbol="XRP", id="3", price="0.2119 €", logo="https://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/cryptocoin/xrp.svg")))
        wallet.add(WalletModel(id="3", walletId= AssetCode.CRYPTO, coinId="2", isDefault=false, balance=1032.23, deleted=false, name="Test BEST Wallet",
                asset=AssetModel(precision=4, name="Bitpanda Ecosystem Token", symbol="BEST", id="2", price="0.03 €", logo="https://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/cryptocoin/best.svg")))
        wallet.add(WalletModel(id="1", walletId= AssetCode.CRYPTO, coinId="1", isDefault=false, balance=133.7, deleted=false, name="Test BTC Wallet",
                asset=AssetModel(precision=4, name="Bitcoin", symbol="BTC", id="1", price="90.0 €", logo="https://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/cryptocoin/btc.svg")))
        wallet.add(WalletModel(id="2", walletId= AssetCode.METAL, coinId="4", isDefault=false, balance=2043.434, deleted=false, name="Gold Wallet 2",
                asset=AssetModel(precision=3, name="Gold", symbol="Gold", id="4", price="45.14 €", logo="https://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/cryptocoin/xau.svg")))
        wallet.add(WalletModel(id="2", walletId= AssetCode.METAL, coinId="5", isDefault=false, balance=200.0, deleted=false, name="Test Palladium Wallet",
                asset=AssetModel(precision=3, name="Palladium", symbol="Palladium", id="5", price="70.4 €", logo="http://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/cryptocoin/xpd.svg")))
        wallet.add( WalletModel(id="1", walletId= AssetCode.METAL, coinId="4", isDefault=true, balance=133.729, deleted=false, name="Gold Wallet 1",
                asset=AssetModel(precision=3, name="Gold", symbol="Gold", id="4", price="45.14 €", logo="https://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/cryptocoin/xau.svg")))
       return ApiResult.Success(wallet.toList())
    }

    private fun fiatWallet(): ApiResult.Success<List<WalletModel>> {
        val wallet : MutableList<WalletModel> = ArrayList()
        wallet.add( WalletModel(id = "1", walletId = AssetCode.FIAT, coinId = "1", isDefault = false, balance = 400.0, deleted = false, name = "EUR Wallet",
                asset = AssetModel(precision = 2, name = "Euro", symbol = "EUR", id = "1", price = "1.0 €", logo = "https://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/fiat/usd.svg")))
        wallet.add(WalletModel(id="2", walletId= AssetCode.FIAT, coinId="2", isDefault=false, balance=0.0, deleted=false, name="CHF Wallet",
                asset=AssetModel(precision=2, name="Swiss Franc", symbol="CHF", id="2", price="1.0 €", logo="https://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/fiat/chf.svg")))
        return ApiResult.Success(wallet.toList())
    }

    private fun cryptoWallet(): ApiResult.Success<List<WalletModel>> {
        val wallet : MutableList<WalletModel> = ArrayList()
        wallet.add(WalletModel(id="4", walletId= AssetCode.CRYPTO, coinId="3", isDefault=false, balance=2304.04, deleted=false, name="Test Ripple Wallet",
                asset=AssetModel(precision=4, name="Ripple", symbol="XRP", id="3", price="0.2119 €", logo="https://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/cryptocoin/xrp.svg")))
        wallet.add(WalletModel(id="3", walletId= AssetCode.CRYPTO, coinId="2", isDefault=false, balance=1032.23, deleted=false, name="Test BEST Wallet",
                asset=AssetModel(precision=4, name="Bitpanda Ecosystem Token", symbol="BEST", id="2", price="0.03 €", logo="https://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/cryptocoin/best.svg")))
        wallet.add(WalletModel(id="1", walletId= AssetCode.CRYPTO, coinId="1", isDefault=false, balance=133.7, deleted=false, name="Test BTC Wallet",
                asset=AssetModel(precision=4, name="Bitcoin", symbol="BTC", id="1", price="90.0 €", logo="https://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/cryptocoin/btc.svg")))
        return ApiResult.Success(wallet.toList())
    }

    private fun metalWallet(): ApiResult.Success<List<WalletModel>> {
        val wallet : MutableList<WalletModel> = ArrayList()
        wallet.add(WalletModel(id="2", walletId= AssetCode.METAL, coinId="4", isDefault=false, balance=2043.434, deleted=false, name="Gold Wallet 2",
                asset=AssetModel(precision=3, name="Gold", symbol="Gold", id="4", price="45.14 €", logo="https://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/cryptocoin/xau.svg")))
        wallet.add(WalletModel(id="2", walletId= AssetCode.METAL, coinId="5", isDefault=false, balance=200.0, deleted=false, name="Test Palladium Wallet",
                asset=AssetModel(precision=3, name="Palladium", symbol="Palladium", id="5", price="70.4 €", logo="http://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/cryptocoin/xpd.svg")))
        wallet.add( WalletModel(id="1", walletId= AssetCode.METAL, coinId="4", isDefault=true, balance=133.729, deleted=false, name="Gold Wallet 1",
                asset=AssetModel(precision=3, name="Gold", symbol="Gold", id="4", price="45.14 €", logo="https://bitpanda-assets.s3-eu-west-1.amazonaws.com/static/cryptocoin/xau.svg")))
        return ApiResult.Success(wallet.toList())
    }
}