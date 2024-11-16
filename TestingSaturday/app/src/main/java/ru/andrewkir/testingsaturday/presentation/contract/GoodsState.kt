package ru.andrewkir.testingsaturday.presentation.contract

import ru.andrewkir.testingsaturday.models.GoodsModel

data class GoodsState(
  val enteredText: String = "",
  val enteredUrl: String = "",
  val goods: List<GoodsModel> = emptyList()
)
