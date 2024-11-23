package ru.andrewkir.testingsaturday.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.andrewkir.testingsaturday.R
import ru.andrewkir.testingsaturday.data.api.GithubApi
import ru.andrewkir.testingsaturday.data.models.GoodsModel
import ru.andrewkir.testingsaturday.presentation.contract.GoodsEvent
import ru.andrewkir.testingsaturday.presentation.contract.GoodsEvent.OnAddButtonClicked
import ru.andrewkir.testingsaturday.presentation.contract.GoodsEvent.OnTextUpdated
import ru.andrewkir.testingsaturday.presentation.contract.GoodsEvent.OnUrlUpdated
import ru.andrewkir.testingsaturday.presentation.contract.GoodsState

class GoodsViewModel : ViewModel() {

  val state = MutableStateFlow(GoodsState())

  private fun getApi(): GithubApi {
    val okHttpClient = Builder()
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    okHttpClient.addInterceptor(logging)

    val retrofit = Retrofit.Builder()
      .baseUrl("https://api.github.com/")
      .addConverterFactory(GsonConverterFactory.create())
      .client(okHttpClient.build())
      .build()

    return retrofit.create(GithubApi::class.java)
  }

  fun handleEvent(event: GoodsEvent) {
    when (event) {
      is OnTextUpdated -> {
        state.value = state.value.copy(enteredText = event.text)
      }

      OnAddButtonClicked -> {
        val api = getApi()
        viewModelScope.launch {
          try {
            val users = api.getUsers()
            users.forEach {
              state.value = state.value.copy(
                goods = state.value.goods + listOf(
                  GoodsModel(
                    name = it.login,
                    rating = 4,
                    price = 1000000,
                    comment = it.login,
                    coverId = R.drawable.bmw,
                    imageURL = state.value.enteredUrl,
                  ),
                ),
              )
            }
          } catch (e: Exception) {
            e.printStackTrace()
          }
        }
//        state.value = state.value.copy(
//          goods = state.value.goods + listOf(
//            GoodsModel(
//              name = state.value.enteredText,
//              rating = 4,
//              price = 1000000,
//              comment = "Немецкое качество",
//              coverId = R.drawable.bmw,
//              imageURL = state.value.enteredUrl,
//            ),
//          ),
//          enteredText = "",
//          enteredUrl = "",
//        )
      }

      is OnUrlUpdated -> {
        state.value = state.value.copy(enteredUrl = event.url)
      }
    }
  }
}