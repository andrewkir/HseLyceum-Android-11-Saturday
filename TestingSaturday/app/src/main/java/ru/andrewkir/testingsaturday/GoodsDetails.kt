package ru.andrewkir.testingsaturday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ru.andrewkir.testingsaturday.ui.theme.TestingSaturdayTheme

class GoodsDetails : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      TestingSaturdayTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Column(Modifier.padding(innerPadding)) {
            val name = intent.extras?.getString("NAME_KEY") ?: "Пусто"
            Text(
              text = name,
              fontSize = 32.sp
            )
          }
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
  TestingSaturdayTheme {
    Greeting("Android")
  }
}