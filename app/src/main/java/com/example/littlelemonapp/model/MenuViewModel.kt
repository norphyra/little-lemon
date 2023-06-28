package com.example.littlelemonapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

class MenuViewModel (private val repository: MenuRepositoryImpl): ViewModel() {

    val menu: SharedFlow<List<MenuItemEntity>> = flow<List<MenuItemEntity>>
    { emit(repository.getMenu()) }.shareIn(viewModelScope, SharingStarted.Lazily, 1)

    suspend fun getMenuItemsByCategory(category: String): List<MenuItemEntity> {
        return repository.getMenuItemsByCategory(category)
    }

    class MenuViewModelFactory @Inject constructor(private val repository: MenuRepositoryImpl): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return when (modelClass) {
                MenuViewModel::class.java -> { MenuViewModel(repository = repository) }
                else -> {throw IllegalArgumentException("Unknown ViewModel class")}
            } as T
        }
    }
}