package airwallex.intent

import airwallex.ACCESS_TOKEN
import airwallex.API_URL
import api.airwallex.Order
import api.airwallex.PaymentIntentResponse
import client
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.Serializable

// schema for api
@Serializable
data class IntentPayload(
    var request_id: String,
    var amount: Float,
    var currency: String,
    var merchant_order_id: String,
    var order: Order? = null,
    var customer_id: String? = null,
    var descriptor: String? = null,
    var metadata: Map<String, String>? = null,
    var return_url: String? = null,
    var payment_method_options: PaymentOptionsCard? = null,
    var connected_account_id: String? = null,
)

@Serializable
data class PaymentOptionsCard(var card: PaymentOptionsRisk)

@Serializable
data class PaymentOptionsRisk(var risk_control: RiskControl)

@Serializable
data class RiskControl(var skip_risk_processing: Boolean, var three_domain_secure_action: String)

data class LatestPaymentAttempt(var amount: Float, var authorization_code: String)

suspend fun createIntent(paymentIntent: IntentPayload): PaymentIntentResponse {
    return client.post("$API_URL/api/v1/pa/payment_intents/create") {
        contentType(ContentType.Application.Json)
        header(HttpHeaders.Authorization, "Bearer $ACCESS_TOKEN")
        body = paymentIntent
    }
}