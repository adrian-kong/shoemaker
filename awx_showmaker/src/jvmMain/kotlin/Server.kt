import airwallex.scheduleUpdateAccessToken
import api.server.setupRoutes
import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

var client: HttpClient = HttpClient(CIO) {
    install(JsonFeature)
}

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        install(CORS)
        install(DefaultHeaders)
        install(CallLogging)
        install(Routing) {
            setupRoutes()
        }
        scheduleUpdateAccessToken()
    }.start(true)
}
