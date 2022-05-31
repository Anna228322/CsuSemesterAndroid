package com.example.csusemesterandroid.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.csusemesterandroid.domain.models.DetailsInfo
import com.example.csusemesterandroid.domain.models.PhoneInfo
import com.example.csusemesterandroid.domain.usecases.GetPhoneDetails
import com.example.csusemesterandroid.domain.usecases.SavePhoneDetails
import kotlinx.coroutines.*
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val getPhoneDetails: GetPhoneDetails,
    private val savePhoneDetails: SavePhoneDetails
): ViewModel() {
    val loading = MutableLiveData(false)
    val error = MutableLiveData("")
    val item = MutableLiveData<DetailsInfo?>()
    private var job: Job? = null

    private val handler = CoroutineExceptionHandler { _, t ->
        error.value = "Failed to load"
        loading.value = false
        t.printStackTrace()
    }

    fun load(phone: PhoneInfo?) {
        job = viewModelScope.launch(handler) {
            if (phone == null) {
                error.value = "Phone was null"
            } else {
                loading.value = true
                item.value =  withContext(Dispatchers.IO) { getPhoneDetails.fromDb(phone) }
                item.value =  withContext(Dispatchers.IO) {getPhoneDetails.fromApi(phone) }
                loading.value = false
                withContext(Dispatchers.IO) { savePhoneDetails.save(item.value!!) }
            }
        }
    }

    fun stop() {
        job?.cancel()
    }
}