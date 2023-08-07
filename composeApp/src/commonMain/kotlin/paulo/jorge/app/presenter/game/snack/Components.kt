package paulo.jorge.app.presenter.game.snack

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import paulo.jorge.app.presenter.nubank.NuColors

@Composable
fun Snake(game: Game) {
    val state = game.state.collectAsState(initial = null)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        state.value?.let {
            Board(it)
        }
        Buttons {
            game.move = it
        }
    }

}

@Composable
fun Buttons(onDirectionChange: (Pair<Int, Int>) -> Unit) {
    val buttonSize = Modifier.size(64.dp)
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(24.dp)) {
        Button(onClick = { onDirectionChange(Pair(0, -1)) }, modifier = buttonSize) {
            Icon(Icons.Default.KeyboardArrowUp, null)
        }
        Row {
            Button(onClick = { onDirectionChange(Pair(-1, 0)) }, modifier = buttonSize) {
                Icon(Icons.Default.KeyboardArrowLeft, null)
            }
            Spacer(modifier = buttonSize)
            Button(onClick = { onDirectionChange(Pair(1, 0)) }, modifier = buttonSize) {
                Icon(Icons.Default.KeyboardArrowRight, null)
            }
        }
        Button(onClick = { onDirectionChange(Pair(0, 1)) }, modifier = buttonSize) {
            Icon(Icons.Default.KeyboardArrowDown, null)
        }
    }
}

@Composable
fun Board(state: State) {
    BoxWithConstraints(Modifier.padding(16.dp)) {
        val tileSize = maxWidth / Game.BOARD_SIZE

        Box(
            Modifier
                .size(maxWidth)
                .border(2.dp, NuColors.purpleDark)
        )

        Box(
            Modifier
                .offset(x = tileSize * state.food.first, y = tileSize * state.food.second)
                .size(tileSize)
                .background(
                    NuColors.purpleDark, CircleShape
                )
        )

        state.snake.forEach {
            Box(
                modifier = Modifier
                    .offset(x = tileSize * it.first, y = tileSize * it.second)
                    .size(tileSize)
                    .background(
                        NuColors.purpleDark, CircleShape
                    )
            )
        }
    }
}