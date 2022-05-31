package com.example.csusemesterandroid.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.csusemesterandroid.domain.models.BrandInfo
import com.example.csusemesterandroid.domain.usecases.GetAllBrands
import com.example.csusemesterandroid.domain.usecases.SaveAllBrands
import com.example.csusemesterandroid.mappers.ItemMapper
import com.example.csusemesterandroid.ui.recyclerview.models.BrandItem
import kotlinx.coroutines.*
import javax.inject.Inject

class BrandsViewModel @Inject constructor(
    private val getAllBrands: GetAllBrands,
    private val saveAllBrands: SaveAllBrands,
    private val itemMapper: ItemMapper
): ViewModel() {
    val loading = MutableLiveData(false)
    val error = MutableLiveData("")
    val items = MutableLiveData(emptyList<BrandItem>())
    val chosenBrand = MutableLiveData<BrandInfo?>(null)
    private var job: Job? = null

    private val handler = CoroutineExceptionHandler { _, t ->
        error.value = "Failed to load"
        loading.value = false
        t.printStackTrace()
    }

    fun setList() {
        job = viewModelScope.launch(handler) {
            loading.value = true
            items.value =  withContext(Dispatchers.IO) { getAllBrands.fromDb()
                .mapIndexed { index, info -> itemMapper.infoToItem(info, index, ::click) } }
            items.value =  withContext(Dispatchers.IO) { getAllBrands.fromApi()
                .mapIndexed { index, info -> itemMapper.infoToItem(info, index, ::click) } }
            loading.value = false
            withContext(Dispatchers.IO) {
                saveAllBrands.save(items.value!!.map { item -> item.brandInfo })
            }
        }
    }

    fun stop() {
        job?.cancel()
    }

    private fun click(index: Int) {
        chosenBrand.value = items.value?.getOrNull(index)?.brandInfo
    }
}