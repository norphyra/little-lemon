package com.example.littlelemonapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class MenuViewModel (private val repository: MenuRepositoryImpl): ViewModel() {

    val menu: SharedFlow<List<MenuItemEntity>> = flow
    { emit(repository.getMenu()) }.shareIn(viewModelScope, SharingStarted.Lazily, 1)

    suspend fun getMenuItemsByCategory(category: String): List<MenuItemEntity> {
        return repository.getMenuItemsByCategory(category)
    }

    class MenuViewModelFactory @AssistedInject constructor(private val repository: MenuRepositoryImpl): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            //require(modelClass == MenuViewModel::class)
            return MenuViewModel(repository = repository) as T
        }

        @AssistedFactory
        interface Factory {
            fun create(): MenuViewModelFactory
        }
    }
}