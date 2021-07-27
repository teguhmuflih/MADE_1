package com.dicoding.made_1.detail

import androidx.lifecycle.ViewModel
import com.dicoding.made_1.core.domain.model.Sport
import com.dicoding.made_1.core.domain.usecase.SportUseCase

class DetailSportViewModel(private val sportUseCase: SportUseCase) : ViewModel() {
    fun setFavoriteSport(sport: Sport, newStatus:Boolean) =
        sportUseCase.setFavoriteSport(sport, newStatus)
}