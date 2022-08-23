package com.example.allhomes.ui.dashboard

import androidx.compose.runtime.*
import androidx.lifecycle.*
import com.example.allhomes.model.PropertyRequest
import com.example.allhomes.model.PropertyResult
import com.example.allhomes.network.ApiService
import com.example.allhomes.utils.BUY_MODE
import com.example.allhomes.utils.PROJECT
import com.example.allhomes.utils.RENT_MODE
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class DashboardViewModel() : ViewModel() {

    private val _state = MutableStateFlow(emptyList<PropertyResult>())
    val state: StateFlow<List<PropertyResult>>
        get() = _state

    var errorMessage: String by mutableStateOf("")

    fun getPropertyList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val propertyResponse =
                    apiService.getPropertyList(PropertyRequest(search_mode = RENT_MODE))
                _state.value = propertyResponse.search_results
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}