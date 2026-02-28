package com.zastavnaya.footbal_players

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zastavnaya.footbal_players.data.Datasource
import com.zastavnaya.footbal_players.model.Player
import com.zastavnaya.footbal_players.ui.theme.Footbal_PlayersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Footbal_PlayersTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PlayerCatalogApp()
                }
            }
        }
    }
}
@Composable
fun PlayerScreen(player: Player, modifier: Modifier = Modifier) {
    var showDescription by remember(player) { mutableStateOf(false)}
    Column {
        Image(
            painter = painterResource(player.imageResourceId),
            contentDescription = stringResource(player.nameResourceId),
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(player.nameResourceId),
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineSmall
        )
        Button(
            onClick = { showDescription =!showDescription },
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = if (showDescription)
                "Скрыть описание"
                else
                "Показать описание"
            )
        }
        if (showDescription) {
            Text(
                text = stringResource(player.descResourceId),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
}
@Composable
fun NavButtons(currentIndex: Int,
               size: Int,
               onPrevious: () -> Unit,
               onNext: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Button(onClick = onPrevious,
            enabled = currentIndex > 0) {
            Text("Назад")
        }
        Button(onClick = onNext,
            enabled = currentIndex < size - 1) {
            Text("Вперед")
        }
    }

}
@Composable
fun PlayerCatalogApp() {
    val players = Datasource().loadPlayersList()

    var currentIndex by remember { mutableStateOf(0) }
    val currentPlayer = players[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PlayerScreen(player = currentPlayer)
        Spacer(modifier = Modifier.height(16.dp))

        NavButtons(currentIndex = currentIndex,
            size = players.size,
            onPrevious = {
                if (currentIndex > 0) {
                    currentIndex --
                }
            },
            onNext = {
                if (currentIndex < players.size - 1) {
                    currentIndex++
                }
            }
        )
    }
}
