package com.poema_api.poema_api.apiExterna

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

@RestController
class PoemaDBController {

    private val client = OkHttpClient()

    @GetMapping("/api/poema-random")
    fun getPoemaAleatorio(): String {
        val request = Request.Builder()
            .url("https://poetrydb.org/random")
            .build()

        client.newCall(request).execute().use { response: Response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            val responseBody = response.body!!.string()

            val jsonElement = Json.parseToJsonElement(responseBody)
            val jsonArray = jsonElement.jsonArray
            val poemaObj = jsonArray[0].jsonObject
            val titulo = poemaObj["title"]!!.jsonPrimitive.content
            val autor = poemaObj["author"]!!.jsonPrimitive.content
            val linhas = poemaObj["lines"]!!.jsonArray

            val poema = StringBuilder()
            poema.append("Título: $titulo\n")
            poema.append("Autor: $autor\n\n")
            for (linha in linhas) {
                poema.append(linha.jsonPrimitive.content).append("\n")
            }

            return poema.toString()
        }
    }
}
