package paulo.jorge.app.presenter.store.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun ContentHome() {
    val items = (1..20).toList()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
    ) {
        items(items) { item ->
            Card(
                elevation = CardDefaults.cardElevation( defaultElevation = 12.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFEDBD0)
                ),
                modifier = Modifier.size(180.dp, 220.dp).padding(10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    KamelImage(
                        asyncPainterResource(
                            "https://d1ih8jugeo2m5m.cloudfront.net/2020/06/produtos-para-revenda-600x400.jpeg"
                        ),
                        modifier = Modifier.size(180.dp, 120.dp),
                        onLoading = {
                            CircularProgressIndicator(
                                modifier = Modifier.size(40.dp),
                                color = Color(0xFF442c2E),
                                strokeWidth = 1.dp
                            )
                        },
                        onFailure = {
                            Text(text = "No Image. :(",)
                        },
                        contentScale = ContentScale.Crop,
                        contentDescription = null
                    )
                    Text(
                        text = "Item:: $item",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth().padding(10.dp),
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {},
                        ) {
                            Icon(
                                imageVector = Icons.Default.FavoriteBorder,
                                contentDescription = null
                            )
                        }
                        Text(
                            text = "R$:: ${item * 5}, 99",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(end = 10.dp)
                        )
                    }
                }
            }
        }
    }
}