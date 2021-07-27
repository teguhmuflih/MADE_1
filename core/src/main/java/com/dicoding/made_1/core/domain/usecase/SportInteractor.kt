package com.dicoding.made_1.core.domain.usecase

import com.dicoding.made_1.core.domain.model.Sport
import com.dicoding.made_1.core.domain.repository.ISportRepository

class SportInteractor(private val sportRepository: ISportRepository): SportUseCase {

    override fun getAllSport() = sportRepository.getAllSport()

    override fun getFavoriteSport() = sportRepository.getFavoriteSport()

    override fun setFavoriteSport(sport: Sport, state: Boolean) = sportRepository.setFavoriteSport(sport, state)
}