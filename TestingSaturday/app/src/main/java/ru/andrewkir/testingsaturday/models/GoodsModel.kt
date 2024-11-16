package ru.andrewkir.testingsaturday.models

import androidx.annotation.DrawableRes

data class GoodsModel(
  val name: String,
  val rating: Int,
  val price: Int,
  val comment: String,
  @DrawableRes
  val coverId: Int,
  val imageURL: String = "",
)