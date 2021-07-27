package com.dicoding.made_1.core.utils

import com.dicoding.made_1.core.data.source.local.entity.SportEntity
import com.dicoding.made_1.core.data.source.remote.response.SportResponse
import com.dicoding.made_1.core.domain.model.Sport

object DataMapper {
    fun mapResponsesToEntities(input: List<SportResponse>): List<SportEntity> {
        val sportList = ArrayList<SportEntity>()
        input.map {
            run {
                val sport = SportEntity(
                    idTeam  = it.idTeam,
                    strTeam = it.strTeam,
                    strKeywords = it.strKeywords,
                    strTeamBadge = it.strTeamBadge,
                    strTeamLogo = it.strTeamLogo,
                    strDescriptionEN = it.strDescriptionEN,
                    isFavorite = false
                )

                sportList.add(sport)
            }
        }
        return sportList
    }

    fun mapEntitiesToDomain(input: List<SportEntity>): List<Sport> =
        input.map {
            Sport(
                idTeam  = it.idTeam,
                strTeam = it.strTeam,
                strKeywords = it.strKeywords,
                strTeamBadge = it.strTeamBadge,
                strTeamLogo = it.strTeamLogo,
                strDescriptionEN = it.strDescriptionEN,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Sport) = SportEntity(
        idTeam = input.idTeam,
        strTeam = input.strTeam,
        strKeywords = input.strKeywords,
        strTeamBadge = input.strTeamBadge,
        strTeamLogo = input.strTeamLogo,
        strDescriptionEN= input.strDescriptionEN,
        isFavorite = input.isFavorite
    )
}