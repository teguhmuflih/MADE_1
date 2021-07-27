package com.dicoding.made_1.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sportTable")
data class SportEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTeam")
    var idTeam: String,

    @ColumnInfo(name = "strTeam")
    var strTeam: String,

    @ColumnInfo(name = "strKeywords")
    var strKeywords: String,

    @ColumnInfo(name = "strTeamBadge")
    var strTeamBadge: String,

    @ColumnInfo(name = "strTeamLogo")
    var strTeamLogo: String,

    @ColumnInfo(name = "strDescriptionEN")
    var strDescriptionEN: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
