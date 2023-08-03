package paulo.jorge.app.presenter.coupons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Divider
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
fun Coupons(
    title: String,
    description: String,
    color: Color
) {
    Column(
        modifier = Modifier
            .size(350.dp, 180.dp)
            .clip(
                TicketShape(24.dp, CornerSize(12.dp))
            ).background(color),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(10.dp)
        )
        Divider(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            color = Color.White,
            thickness = 1.dp
        )
        Text(
            description,
            color = Color.White,
            fontWeight = FontWeight.Light,
            fontSize = 17.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}