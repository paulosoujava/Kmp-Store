package paulo.jorge.app.presenter.nubank

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

object NuCircle {

    @Composable
    fun CircleIcon(titleCircle: String, icon: ImageVector, value: String? = null,
                   iconColor: Color = MaterialTheme.colorScheme.primary ) {
        Box {
            Column(
                modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(90))
                        .background(NuColors.gray),
                    contentAlignment = Alignment.Center
                ) {
                    NuIcons.Custom(icon, color = iconColor)
                }
                NuText.SmallTitle(titleCircle, color = NuColors.black)
            }
            if (value != null) {
                Box(
                    modifier = Modifier
                        .height(90.dp)
                        .padding(top = 70.dp, start = 16.dp)
                        .background(NuColors.purple)
                ) {
                   NuText.SmallTitle(
                       value,
                       color = NuColors.white,
                       modifier = Modifier.padding(start = 5.dp, end = 5.dp))
                }
            }
        }
    }
}