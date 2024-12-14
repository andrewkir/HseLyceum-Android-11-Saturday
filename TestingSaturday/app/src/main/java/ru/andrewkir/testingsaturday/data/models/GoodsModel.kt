package ru.andrewkir.testingsaturday.data.models

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class GoodsModel(
  val name: String,
  val rating: Int,
  val price: Int,
  val comment: String,
  @DrawableRes
  val coverId: Int,
  val imageURL: String = "",
)