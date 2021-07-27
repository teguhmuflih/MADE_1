package com.dicoding.made_1.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListSportResponse(
    @field:SerializedName("teams")
    val sports: List<SportResponse>
)