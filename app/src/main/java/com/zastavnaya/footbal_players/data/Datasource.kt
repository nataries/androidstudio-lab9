package com.zastavnaya.footbal_players.data

import com.zastavnaya.footbal_players.R
import com.zastavnaya.footbal_players.model.Player
class Datasource {
    fun loadPlayersList(): List<Player> {
        return listOf(
            Player(
                nameResourceId = R.string.photo1,
                descResourceId = R.string.photo1_desc,
                imageResourceId = R.drawable.photo1
            ),
            Player(
                nameResourceId = R.string.photo2,
                descResourceId = R.string.photo2_desc,
                imageResourceId = R.drawable.photo2
            ),
            Player(
                nameResourceId = R.string.photo3,
                descResourceId = R.string.photo3_desc,
                imageResourceId = R.drawable.photo3
            ),
            Player(
                nameResourceId = R.string.photo4,
                descResourceId = R.string.photo4_desc,
                imageResourceId = R.drawable.photo4
            ),
            Player(
                nameResourceId = R.string.photo5,
                descResourceId = R.string.photo5_desc,
                imageResourceId = R.drawable.photo5
            ),
            Player(
                nameResourceId = R.string.photo6,
                descResourceId = R.string.photo6_desc,
                imageResourceId = R.drawable.photo6
            ),
            Player(
                nameResourceId = R.string.photo7,
                descResourceId = R.string.photo7_desc,
                imageResourceId = R.drawable.photo7
            )
        )
    }
}