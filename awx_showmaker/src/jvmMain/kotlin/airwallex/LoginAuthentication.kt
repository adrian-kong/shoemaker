package airwallex

import client
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.schedule


private const val CLIENT_ID = "MUeqL2QHRv-rB-ykJt-oHg"
private const val API_KEY =
    "0ab4c2c6a73e69697b7b4818d1aeb04079fb3c3f8b557ed4d1a6663c8df71014155ff7e829e180b302db5de846edfe77"

// cache access token updated every 20 minutes
var ACCESS_TOKEN: String? = null

data class LoginWrapper(val token: String)

// unsafe
suspend fun fetchAccessToken(): String = coroutineScope {
    val response: HttpResponse = client.post("$API_URL/api/v1/authentication/login") {
        headers {
            append("x-api-key", API_KEY)
            append("x-client-id", CLIENT_ID)
        }
    }
    return@coroutineScope response.receive<LoginWrapper>().token
}

fun scheduleUpdateAccessToken() {
    Timer().schedule(0, TimeUnit.MINUTES.toMillis(20)) {
        runBlocking {
            ACCESS_TOKEN = fetchAccessToken()
        }
    }
}