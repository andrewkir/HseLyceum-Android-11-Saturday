package ru.andrewkir.testingsaturday.presentation.contract

import ru.andrewkir.testingsaturday.models.GoodsModel

data class GoodsState(
  val goods: List<GoodsModel> = emptyList()
)
