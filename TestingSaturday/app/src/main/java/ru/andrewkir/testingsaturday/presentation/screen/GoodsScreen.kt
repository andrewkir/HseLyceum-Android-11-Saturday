package ru.andrewkir.testingsaturday.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.andrewkir.testingsaturday.presentation.viewmodel.GoodsViewModel

@Composable
fun GoodsScreen() {
  val viewModel = viewModel<GoodsViewModel>()
  val state by viewModel.state.collectAsState()

  GoodsScreenContent(
    state = state,
    onEvent = {
      viewModel.handleEvent(it)
    },
  )

}