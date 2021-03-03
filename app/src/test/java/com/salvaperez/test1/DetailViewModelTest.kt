package com.salvaperez.test1

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.salvaperez.test1.domain.model.AssetModel
import com.salvaperez.test1.presentation.ui.detail.DetailViewModel
import com.salvaperez.test1.presentation.utils.Resource
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var vm: DetailViewModel

    @Before
    fun setUp() {
        vm = DetailViewModel()
    }

    @Test
    fun `onInit return an object if is not empty`() {
        vm.onInit(createAssetModel())
        val resource = vm.currency.value
        assertEquals(vm.currency.value, Resource.success(createAssetModel()))
        assertEquals(resource?.status, Resource.Status.SUCCESS)
    }

    @Test
    fun `onInit return error if  object is empty`() {
        vm.onInit(null)
        val resource = vm.currency.value
        assertEquals(resource?.status, Resource.Status.ERROR)
    }

    private fun createAssetModel(): AssetModel {
        return AssetModel(2, "Fiat", "EUR", "2", "1.0", "logo")
    }
}