package api.airwallex

import kotlinx.serialization.Serializable

@Serializable
data class PaymentIntentResponse(
    var id: String,
    var request_id: String,
    var amount: Float,
    var currency: String,
    var merchant_order_id: String,

    var order: Order? = null,
    var customer_id: String? = null,
    var payment_consent_id: String? = null,
    var descriptor: String? = null,
    var metadata: Map<String, String>? = null,

    var status: String,
    var captured_amount: Float,
    var created_at: String,
    var updated_at: String,
    var available_payment_method_types: List<String>,
    var client_secret: String,
)