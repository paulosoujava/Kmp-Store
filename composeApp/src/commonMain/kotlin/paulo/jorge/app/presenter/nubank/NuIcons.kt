package paulo.jorge.app.presenter.nubank

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

object NuIcons {

    @Composable
    fun Custom(icon: ImageVector, modifier: Modifier = Modifier,
               color: Color = NuColors.white) {
        Icon(
            imageVector = icon,
            contentDescription = "Default icon",
            modifier = modifier,
            tint = color
        )
    }

    @Composable
    fun Eyes(modifier: Modifier = Modifier,
             color: Color = NuColors.white) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Icon eyes",
            modifier = modifier,
            tint = color
        )
    }
    @Composable
    fun ArrowLeft(modifier: Modifier = Modifier,
                  color: Color = NuColors.white) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Icon info",
            modifier = modifier,
            tint = color
        )
    }
    @Composable
    fun Info(modifier: Modifier = Modifier,
             color: Color = NuColors.white) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Icon info",
            modifier = modifier,
            tint = color
        )
    }

    @Composable
    fun PersonEmail(modifier: Modifier = Modifier,
                    color: Color = NuColors.white) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Icon send invite",
            modifier = modifier,
            tint = color
        )
    }
}