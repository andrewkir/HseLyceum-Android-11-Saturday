package ru.andrewkir.testingsaturday

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.andrewkir.testingsaturday.models.GoodsModel
import ru.andrewkir.testingsaturday.ui.components.GoodsCard
import ru.andrewkir.testingsaturday.ui.theme.TestingSaturdayTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    enableEdgeToEdge()
    setContent {
      TestingSaturdayTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Column(modifier = Modifier.padding(innerPadding)) {
            Goods(
              onGoodsButtonClick = {goodsName ->
                val intent = Intent(baseContext, GoodsDetails::class.java)
                intent.putExtra("NAME_KEY", goodsName)
                startActivity(intent)

                //Во второй активити получаете значение
              // val name = intent.extras?.getString("NAME_KEY") ?: "Пусто"
              }
            )
          }
        }
      }
    }
  }
}

@Composable
fun Goods(onGoodsButtonClick: (String) -> Unit) {
  val goodsItems = listOf(
    GoodsModel(
      name = "BMW M5",
      rating = 4,
      price = 1000000,
      comment = "Немецкое качество",
      coverId = R.drawable.bmw
    ),
    GoodsModel(
      name = "MB Maybach",
      rating = 5,
      price = 1000000,
      comment = "качество",
      coverId = R.drawable.gaz
    )
  )

  LazyColumn(modifier = Modifier.padding(horizontal = 6.dp)) {
    goodsItems.forEach { goodsModel ->
      item {
        GoodsCard(
          item = goodsModel,
          onButtonClick = onGoodsButtonClick
        )
        Spacer(modifier = Modifier.padding(6.dp))
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  TestingSaturdayTheme {
    Goods() {}
  }
}