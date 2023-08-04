package paulo.jorge.app.presenter.nubank

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object NuSpace {

    @Composable
    fun Small() {
        return Spacer(modifier = Modifier.size(10.dp))
    }
    @Composable
    fun Medium() {
        return Spacer(modifier = Modifier.size(20.dp))
    }
    @Composable
    fun Large() {
        return Spacer(modifier = Modifier.size(40.dp))
    }
}