package paulo.jorge.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import paulo.jorge.app.presenter.drag.DragViewModel
import paulo.jorge.app.presenter.drag.DragableScreen

import paulo.jorge.app.presenter.drag.MainScreen
import paulo.jorge.app.presenter.game.snack.ScreenGame
import paulo.jorge.app.presenter.game.tictactoe.GameScreen
import paulo.jorge.app.presenter.game.tictactoe.GameViewModel
import paulo.jorge.app.presenter.nubank.Nubank
import paulo.jorge.app.presenter.store.MyBottomNavigation
import paulo.jorge.app.theme.AppTheme


@Composable
internal fun App() = AppTheme {

    val toggle = remember {
        mutableStateOf(0)
    }

    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = toggle.value == 0
        ) {
            Column {
                Button(
                    onClick = {
                        toggle.value = 1
                    }
                ) {
                    Text(text = "Nu Bank")
                }
                Button(
                    onClick = {
                        toggle.value = 2
                    }
                ) {
                    Text(text = "Store")
                }
                Button(
                    onClick = {
                        toggle.value = 3
                    }
                ) {
                    Text(text = "Drag")
                }
                Button(
                    onClick = {
                        toggle.value = 4
                    }
                ) {
                    Text(text = "Snack Game")
                }
                Button(
                    onClick = {
                        toggle.value = 5
                    }
                ) {
                    Text(text = "Tic Tac Toe Game")
                }
            }
        }
        AnimatedVisibility(
            visible = toggle.value == 5
        ) {
            val mainViewModel = getViewModel(
                key = "tictactoe-view-model",
                factory = viewModelFactory {
                    GameViewModel()
                }
            )
            GameScreen(
                viewModel = mainViewModel
            ){
                toggle.value = 0
            }
        }
        AnimatedVisibility(
            visible = toggle.value == 3
        ) {
            val mainViewModel = getViewModel(
                key = "drag-view-model",
                factory = viewModelFactory {
                    DragViewModel()
                }
            )
            DragableScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(0.8f))
            ) {
                MainScreen(mainViewModel)
            }
        }
        AnimatedVisibility(
            visible = toggle.value == 1,
        ) {
            Nubank {
                toggle.value = 0
            }
        }
        AnimatedVisibility(
            visible = toggle.value == 4,
        ) {
            ScreenGame(
                scope
            ) {
                toggle.value = 0
            }
        }
        AnimatedVisibility(
            visible = toggle.value == 2,
        ) {
            MyBottomNavigation {
                toggle.value = 0
            }
        }
    }


}


