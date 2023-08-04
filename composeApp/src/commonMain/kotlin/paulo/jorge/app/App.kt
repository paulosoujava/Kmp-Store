package paulo.jorge.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import paulo.jorge.app.presenter.nubank.Nubank
import paulo.jorge.app.presenter.store.MyBottomNavigation
import paulo.jorge.app.theme.AppTheme


@Composable
internal fun App() = AppTheme {

    val toggle = remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
    }
    AnimatedVisibility(
        visible = toggle.value == 1,
    ) {
        Nubank{
            toggle.value =0
        }
    }
    AnimatedVisibility(
        visible = toggle.value == 2,
    ) {
        MyBottomNavigation{
            toggle.value =0
        }
    }

}


