package ru.andrewkir.testingsaturday.presentation.contract

sealed class GoodsEvent {
  data class OnTextUpdated(val text: String): GoodsEvent()
  data class OnUrlUpdated(val url: String): GoodsEvent()

  data object OnAddButtonClicked: GoodsEvent()
}