package com.dicoding.made_1.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sport(
    val idTeam: String,
    val strTeam: String,
    val strKeywords: String,
    val strTeamBadge: String,
    val strTeamLogo: String,
    val strDescriptionEN: String,
    val isFavorite: Boolean = false
) : Parcelable
