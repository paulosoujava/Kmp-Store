package paulo.jorge.app.presenter.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(Color(0xFFFEDBD0))
            .fillMaxWidth(),

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {},
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null
            )
        }
        Text(
            "Compose App",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        IconButton(
            onClick = {},
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null
            )
        }
        IconButton(
            onClick = {},
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = null
            )
        }
    }
}