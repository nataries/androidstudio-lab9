package com.zastavnaya.footbal_players.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Player(
    @StringRes val nameResourceId: Int,
    @StringRes val descResourceId: Int,
    @DrawableRes val imageResourceId: Int
) {
}