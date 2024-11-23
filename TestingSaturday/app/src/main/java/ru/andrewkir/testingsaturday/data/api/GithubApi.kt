package ru.andrewkir.testingsaturday.data.api

import retrofit2.http.GET
import ru.andrewkir.testingsaturday.data.models.UserModel

interface GithubApi {

  @GET("/users?since=<string>&per_page=30")
  suspend fun getUsers(): List<UserModel>
}