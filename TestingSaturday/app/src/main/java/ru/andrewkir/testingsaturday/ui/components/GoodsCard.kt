package ru.andrewkir.testingsaturday.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.andrewkir.testingsaturday.R
import ru.andrewkir.testingsaturday.models.GoodsModel

@Composable
fun GoodsCard(
  item: GoodsModel,
) {
  ElevatedCard(
    modifier = Modifier
      .fillMaxWidth()
  ) {
    Column {
      Image(
        modifier = Modifier
          .height(150.dp)
          .fillMaxWidth(),
        painter = painterResource(item.coverId),
        contentDescription = null,
        contentScale = ContentScale.Crop
      )

      Row(
        modifier = Modifier
          .padding(vertical = 12.dp, horizontal = 14.dp)
          .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Text(
          text = item.name,
          fontWeight = FontWeight.Bold,
          fontSize = 24.sp,
        )

        Spacer(modifier = Modifier.weight(1f))

        for (i in 1..5) {
          Icon(
            imageVector = if (i <= item.rating) {
              Icons.Default.Favorite
            } else {
              Icons.Default.FavoriteBorder
            },
            contentDescription = null,
            tint = if (i <= item.rating) {
              Color(0xFFEE6C6C)
            } else {
              Color.Black
            }
          )
        }
      }

      Text(
        modifier = Modifier.padding(start = 12.dp, bottom = 12.dp),
        text = "Всего за ${item.price}"
      )

      Text(
        modifier = Modifier.padding(start = 12.dp, bottom = 12.dp),
        text = item.comment,
      )
    }
  }
}

@Preview
@Composable
private fun GoodsCardPreview() {
  GoodsCard(
    GoodsModel(
      name = "BMW M5",
      rating = 4,
      price = 1000000,
      comment = "Немецкое качество",
      coverId = R.drawable.bmw
    )
  )
}