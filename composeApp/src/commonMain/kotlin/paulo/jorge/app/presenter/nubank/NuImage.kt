package paulo.jorge.app.presenter.nubank

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

object NuImage {

    @Composable
    fun ProfileHome(
        onBack: () -> Unit
    ) {
        return KamelImage(
            asyncPainterResource(
                "https://d1ih8jugeo2m5m.cloudfront.net/2020/06/produtos-para-revenda-600x400.jpeg"
            ),
            modifier = Modifier.size(40.dp).clip(RoundedCornerShape(90)).clickable {
                onBack()
            },
            onLoading = {
                CircularProgressIndicator(
                    modifier = Modifier.size(40.dp),
                    color = Color(0xFF442c2E),
                    strokeWidth = 1.dp
                )
            },
            onFailure = {
                Text(text = "No Image. :(")
            },
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}