package airwallex

import api.airwallex.PaymentIntentResponse
import kotlinx.browser.window
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.js.Promise

fun createPaymentIntent(): Promise<PaymentIntentResponse> {
    return window.fetch("/v1/awx/createPaymentIntent/id=1")
        .then { response -> response.text() }
        .then { json -> Json.decodeFromString(json) }
}

//fun confirmPaymentIntent(paymentIntent: PaymentIntent) {
//    window.fetch("/v1/awx/confirmPaymentIntent/${paymentIntent.id}")
//}