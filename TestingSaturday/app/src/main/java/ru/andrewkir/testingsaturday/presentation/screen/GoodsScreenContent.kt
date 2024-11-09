package ru.andrewkir.testingsaturday.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.andrewkir.testingsaturday.R
import ru.andrewkir.testingsaturday.models.GoodsModel
import ru.andrewkir.testingsaturday.presentation.components.GoodsCard
import ru.andrewkir.testingsaturday.presentation.contract.GoodsEvent
import ru.andrewkir.testingsaturday.presentation.contract.GoodsState

@Composable
fun GoodsScreenContent(
  state: GoodsState,
  onEvent: (GoodsEvent) -> Unit,
) {
  Column {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically
    ) {
      TextField(
        value = state.enteredText,
        onValueChange = { changedValue -> onEvent(GoodsEvent.OnTextUpdated(changedValue)) },
        label = { Text("Enter") })

      Button(
        modifier = Modifier.padding(start = 14.dp),
        onClick = {
          onEvent(GoodsEvent.OnAddButtonClicked)
        }) {
        Text(text = "Add")
      }
    }
    LazyColumn(modifier = Modifier.padding(horizontal = 6.dp, vertical = 12.dp)) {
      state.goods.forEach { goodsModel ->
        item {
          GoodsCard(
            item = goodsModel,
            onButtonClick = {  }
          )
          Spacer(modifier = Modifier.padding(6.dp))
        }
      }
    }
  }
}

@Preview
@Composable
private fun GoodsScreenContentPreview() {
  GoodsScreenContent(
    GoodsState(
      goods = listOf(
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
      ),
      enteredText = ""
    )
  ) {}
}