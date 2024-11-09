package ru.andrewkir.testingsaturday.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import ru.andrewkir.testingsaturday.R
import ru.andrewkir.testingsaturday.models.GoodsModel
import ru.andrewkir.testingsaturday.presentation.contract.GoodsState

class GoodsViewModel : ViewModel() {

  val state = MutableStateFlow(GoodsState())

  init {
    state.value = state.value.copy(
      goods = listOf(
        GoodsModel(
          name = "BMW M52",
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
    )
  }
}