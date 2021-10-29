package route.routes

import airwallex.intent.CreatePaymentLinkPayload
import airwallex.intent.IntentPayload
import airwallex.intent.createIntent
import airwallex.intent.createPaymentLink
import api.Shoe
import api.shoes
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

        get("/createPaymentLink/{id}") {
            val item = call.parameters["id"]
            if (item == null || item.toIntOrNull() == null || !shoes.containsKey(item.toInt())) {
                // TODO: temporary exception handling
                call.respondText("Error $item", ContentType.Any)
            }
            val shoe: Shoe = shoes.getValue(item!!.toInt())
            val paymentPayload = CreatePaymentLinkPayload(
                currency = "USD",
                title = shoe.name,
                amount = shoe.price,
                // TODO: what does reusable even do...? maybe cache the url instead...
                reusable = false,

                // TODO: put description in shoe data object
                description = "Size 8.5 US"
            )

            val response = createPaymentLink(paymentPayload)

            // maybe open new tab instead, simpler way of processing transaction
            // some reason respondRedirect doesn't work with absolute URL ?

//            call.respondRedirect(response.url)

            call.respondText(Json.encodeToString(response), ContentType.Application.Json)
        }

        get("/confirmPaymentIntent/{id}") {
            // TODO: confirm intent
        }
    }
}