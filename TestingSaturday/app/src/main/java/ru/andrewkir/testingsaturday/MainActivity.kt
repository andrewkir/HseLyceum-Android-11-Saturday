package ru.andrewkir.testingsaturday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.andrewkir.testingsaturday.ui.components.Article
import ru.andrewkir.testingsaturday.ui.components.NewsCard
import ru.andrewkir.testingsaturday.ui.theme.TestingSaturdayTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      TestingSaturdayTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Column(modifier = Modifier.padding(innerPadding)) {
            News()
          }
        }
      }
    }
  }
}

@Composable
fun News() {
  val news = listOf(
    Article("asd1", "asdasdasodjas;dlkjn"),
    Article("asd2", "asdasdasodjas;dlkjn"),
    Article("asd3", "asdasdasodjas;dlkjn"),
    Article("asd4", "asdasdasodjas;dlkjn"),
    Article("asd5", "asdasdasodjas;dlkjn"),
    Article("asd6", "asdasdasodjas;dlkjn"),
  )

  LazyColumn {
    news.forEach { article ->
      item {
        NewsCard(article)
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  TestingSaturdayTheme {
    News()
  }
}