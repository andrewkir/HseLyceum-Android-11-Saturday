package ru.andrewkir.testingsaturday.data.models

import com.google.gson.annotations.SerializedName

data class UserModel(
  @SerializedName("login")
  val login: String,
)
