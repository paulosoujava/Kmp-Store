package paulo.jorge.app.presenter.game.snack

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope

@Composable
fun ScreenGame(  lifecycleScope: CoroutineScope, onBack: () -> Unit) {

    val game = Game(lifecycleScope)

    Column(

    ) {
        IconButton(
            onClick = {
                onBack()
            }
        ){
            Icon(Icons.Default.Close, contentDescription = null)
        }
        Snake(game)
    }
}