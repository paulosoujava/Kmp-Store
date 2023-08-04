package paulo.jorge.app.presenter.nubank

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


object NuText {

    @Composable
    fun Title(
        text: String, modifier: Modifier = Modifier,
        color: Color,
        fontWeight: FontWeight = FontWeight.Normal
    ) {
        return Text(
            text = text,
            modifier = modifier,
            style = MaterialTheme.typography.headlineLarge,
            color = color,
            fontSize = 24.sp,
            fontWeight = fontWeight
        )
    }

    @Composable
    fun SubTitle(
        text: String, modifier: Modifier = Modifier,
        color: Color,
        fontWeight: FontWeight = FontWeight.Normal
    ) {
        return Text(
            text = text,
            modifier = modifier,
            style = MaterialTheme.typography.bodyMedium,
            color = color,
            fontSize = 18.sp,
            fontWeight = fontWeight
        )
    }

    @Composable
    fun SmallTitle(
        text: String, modifier: Modifier = Modifier,
        color: Color,
        fontWeight: FontWeight = FontWeight.Normal
    ) {
        return Text(
            text = text,
            modifier = modifier,
            style = MaterialTheme.typography.bodySmall,
            color = color,
            fontSize = 14.sp,
            fontWeight = fontWeight
        )
    }
}