package com.example.practicasuperpoderes.utils

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.io.File
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

//class MarvelApiMockDispatcher : Dispatcher() {
//    override fun dispatch(request: RecordedRequest): MockResponse {
//        var path_o = request.path+"hola"
//        return when (request.path) {
//            "/v1/public/characters" -> {
//                MockResponse()
//                    .setResponseCode(HttpURLConnection.HTTP_OK)
//                    .setBody(getJson("json/heroes.json"))
//            }
//            else -> MockResponse().throttleBody(1024, 5, TimeUnit.SECONDS)
//        }
//    }
//}
//
//internal fun getJson(path: String): String {
//
//    val file = File("/Users/martamaquedano/Projects/10. Android Avanzado/BasicApp/app/src/main/resources/" +path)
//    return String(file.readBytes())
//}