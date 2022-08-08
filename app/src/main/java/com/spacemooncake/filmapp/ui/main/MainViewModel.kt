package com.spacemooncake.filmapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spacemooncake.filmapp.model.AppState
import com.spacemooncake.filmapp.model.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val localLiveData = MutableLiveData<AppState>()
    val liveData: LiveData<AppState> get() = localLiveData

    fun getFilmsData() = getFilmsFromServer()

    private fun getFilmsFromServer() {
        viewModelScope.launch(Dispatchers.IO) {
            if (isActive) {
                localLiveData.postValue(AppState.Success(repository.getFilmsFromServer()))
            }
        }
    }
}