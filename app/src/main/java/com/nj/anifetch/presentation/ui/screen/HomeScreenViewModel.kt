package com.nj.anifetch.presentation.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nj.anifetch.domain.usecases.GetAnimeByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class HomeScreenViewModel(getAnimeByIdUseCase: GetAnimeByIdUseCase): ViewModel() {
    init {
        getAnimeData()
    }

    private fun getAnimeData() {
        viewModelScope.launch {

        }
    }
}