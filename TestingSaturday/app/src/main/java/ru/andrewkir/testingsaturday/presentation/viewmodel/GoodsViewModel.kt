package ru.andrewkir.testingsaturday.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import ru.andrewkir.testingsaturday.R
import ru.andrewkir.testingsaturday.models.GoodsModel
import ru.andrewkir.testingsaturday.presentation.contract.GoodsEvent
import ru.andrewkir.testingsaturday.presentation.contract.GoodsEvent.OnAddButtonClicked
import ru.andrewkir.testingsaturday.presentation.contract.GoodsEvent.OnTextUpdated
import ru.andrewkir.testingsaturday.presentation.contract.GoodsEvent.OnUrlUpdated
import ru.andrewkir.testingsaturday.presentation.contract.GoodsState

class GoodsViewModel : ViewModel() {

  val state = MutableStateFlow(GoodsState())

  fun handleEvent(event: GoodsEvent) {
    when (event) {
      is OnTextUpdated -> {
        state.value = state.value.copy(enteredText = event.text)
      }

      OnAddButtonClicked -> {
        state.value = state.value.copy(
          goods = state.value.goods + listOf(
            GoodsModel(
              name = state.value.enteredText,
              rating = 4,
              price = 1000000,
              comment = "Немецкое качество",
              coverId = R.drawable.bmw,
              imageURL = state.value.enteredUrl,
            ),
          ),
          enteredText = "",
          enteredUrl = "",
        )
      }

      is OnUrlUpdated -> {
        state.value = state.value.copy(enteredUrl = event.url)
      }
    }
  }
}