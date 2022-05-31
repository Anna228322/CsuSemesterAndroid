package com.example.csusemesterandroid.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.csusemesterandroid.domain.models.BrandInfo
import com.example.csusemesterandroid.domain.models.PhoneInfo
import com.example.csusemesterandroid.domain.usecases.GetAllPhones
import com.example.csusemesterandroid.domain.usecases.SaveAllPhones
import com.example.csusemesterandroid.mappers.ItemMapper
import com.example.csusemesterandroid.ui.recyclerview.models.PhoneItem
import kotlinx.coroutines.*
import javax.inject.Inject

class PhonesViewModel @Inject constructor(
    private val getAllPhones: GetAllPhones,
    private val saveAllPhones: SaveAllPhones,
    private val itemMapper: ItemMapper
): ViewModel() {
    val loading = MutableLiveData(false)
    val error = MutableLiveData("")
    val items = MutableLiveData(emptyList<PhoneItem>())
    val chosenPhone = MutableLiveData<PhoneInfo?>(null)
    private var phones = emptyList<PhoneItem>()
    private var search = ""
    private var job: Job? = null

    private val handler = CoroutineExceptionHandler { _, t ->
        error.value = "Failed to load"
        loading.value = false
        t.printStackTrace()
    }

    fun loadPhones(brand: BrandInfo?) {
        job = viewModelScope.launch(handler) {
            if (brand == null) {
                error.value = "Brand was null"
            } else {
                loading.value = true
                items.value = withContext(Dispatchers.IO) {
                    getAllPhones.fromDb(brand)
                        .mapIndexed { index, info -> itemMapper.infoToItem(info, index, ::click) }
                        .filter { item -> search.isEmpty() || search.lowercase() in item.phoneInfo.name.lowercase() }
                }
                items.value = withContext(Dispatchers.IO) { getAllPhones.fromApi(brand)
                    .mapIndexed { index, info -> itemMapper.infoToItem(info, index, ::click) }
                    .filter { item -> search.isEmpty() || search.lowercase() in item.phoneInfo.name.lowercase() }
                }
                phones = items.value!!
                loading.value = false
                withContext(Dispatchers.IO) {
                    saveAllPhones.save(items.value!!.map { item -> item.phoneInfo })
                }
            }
        }
    }

    fun search(query: String) {
        search = query
        items.value = phones.filter { item -> query.isEmpty() || query.lowercase() in item.phoneInfo.name.lowercase() }
    }

    fun stop() {
        job?.cancel()
    }

    private fun click(index: Int) {
        chosenPhone.value = items.value?.getOrNull(index)?.phoneInfo
    }
}