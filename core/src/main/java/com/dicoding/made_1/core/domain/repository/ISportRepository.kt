package com.dicoding.made_1.core.domain.repository

import com.dicoding.made_1.core.data.Resource
import com.dicoding.made_1.core.domain.model.Sport
import kotlinx.coroutines.flow.Flow

interface ISportRepository {

    fun getAllSport(): Flow<Resource<List<Sport>>>

    fun getFavoriteSport(): Flow<List<Sport>>

    fun setFavoriteSport(sport: Sport, state: Boolean)

}