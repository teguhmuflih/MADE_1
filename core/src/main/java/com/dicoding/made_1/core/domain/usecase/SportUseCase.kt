package com.dicoding.made_1.core.domain.usecase

import com.dicoding.made_1.core.data.Resource
import com.dicoding.made_1.core.domain.model.Sport
import kotlinx.coroutines.flow.Flow

interface SportUseCase {
    fun getAllSport(): Flow<Resource<List<Sport>>>
    fun getFavoriteSport(): Flow<List<Sport>>
    fun setFavoriteSport(sport: Sport, state: Boolean)
}