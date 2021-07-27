package com.dicoding.made_1.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SportResponse(
    @field:SerializedName("idTeam")
    val idTeam: String,

    @field:SerializedName("strTeam")
    val strTeam: String,

    @field:SerializedName("strKeywords")
    val strKeywords: String,

    @field:SerializedName("strTeamBadge")
    val strTeamBadge: String,

    @field:SerializedName("strTeamLogo")
    val strTeamLogo: String,

    @field:SerializedName("strDescriptionEN")
    val strDescriptionEN: String,
)