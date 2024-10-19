package ru.andrewkir.testingsaturday.ui.components

import android.inputmethodservice.Keyboard.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.andrewkir.testingsaturday.R

@Composable
fun NewsCard(
  article: Article,
) {
  ElevatedCard(
    modifier = Modifier
      .fillMaxWidth()
  ) {
    Column(
      modifier = Modifier.padding(16.dp)
    ) {
      Image(
        modifier = Modifier
          .height(150.dp)
          .fillMaxWidth(),
        painter = painterResource(R.drawable.image),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
      )

      Row(
        modifier = Modifier
          .padding(vertical = 12.dp),
        verticalAlignment = Alignment.Bottom
      )  {
        Text(
          text = article.title,
          fontWeight = FontWeight.Bold,
          fontSize = 24.sp,
        )

        Text(
          text = article.subtitle,
        )
      }
    }
  }
}

@Composable
@Preview
private fun NewsCardPreview() {
  NewsCard(
    article = Article("lorem ipsum", "asd;kjnaeldnalksdnalksndalksdbn")
  )
}

data class Article(
  val title: String,
  val subtitle: String
)