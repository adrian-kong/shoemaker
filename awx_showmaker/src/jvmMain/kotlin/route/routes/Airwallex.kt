package route.routes

import airwallex.intent.IntentPayload
import airwallex.intent.createIntent
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.*


fun Route.awx() {
    route("/v1/awx") {
        get("/createPaymentIntent/{id}") {
            // TODO: products & personal data passed via param
            // call.parameters["id"]
            val intent = IntentPayload(
                request_id = UUID.randomUUID().toString(),
                amount = 100.01f,
                currency = "USD",
                merchant_order_id = UUID.randomUUID().toString(),
            )
            val response = createIntent(intent)
            // also handle the exception...
            call.respondText(Json.encodeToString(response), ContentType.Application.Json)
        }
    }
}