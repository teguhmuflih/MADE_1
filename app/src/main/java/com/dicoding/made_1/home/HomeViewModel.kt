package com.dicoding.made_1.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.made_1.core.domain.usecase.SportUseCase

class HomeViewModel(sportUseCase: SportUseCase) : ViewModel() {
    val sport = sportUseCase.getAllSport().asLiveData()
}