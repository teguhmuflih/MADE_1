package com.dicoding.made_1.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.made_1.core.domain.usecase.SportUseCase

class FavoriteViewModel(sportUseCase: SportUseCase) : ViewModel() {
    val favoriteSport = sportUseCase.getFavoriteSport().asLiveData()
}