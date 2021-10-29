package airwallex

import api.airwallex.CreatePaymentLinkResponse
import api.airwallex.PaymentIntentResponse
import kotlinx.browser.window
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.js.Promise

val API_URL = "/v1/awx"

fun createPaymentIntent(): Promise<PaymentIntentResponse> {
    return window.fetch("$API_URL/createPaymentIntent/id=1")
        .then { response -> response.text() }
        .then { json -> Json.decodeFromString(json) }
}

fun redirectPaymentLink(id: Int) {
    // Think this should be cached rather than generated constantly, not extremely familiar with the API exactly.
    window.fetch("$API_URL/createPaymentLink/$id")
        .then { response -> response.text() }
        .then { json -> Json.decodeFromString<CreatePaymentLinkResponse>(json) }
        .then { paymentLink -> window.location.href = paymentLink.url }
}

//fun confirmPaymentIntent(paymentIntent: PaymentIntent) {
//    window.fetch("/v1/awx/confirmPaymentIntent/${paymentIntent.id}")
//}