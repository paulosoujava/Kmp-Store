package paulo.jorge.app.presenter.nubank

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object NuDivider {

    @Composable
    fun Line() {
        NuSpace.Medium()
        Divider(
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
            color = NuColors.black.copy(alpha = 0.2f),
            thickness = 1.dp
        )
        NuSpace.Medium()
    }
}