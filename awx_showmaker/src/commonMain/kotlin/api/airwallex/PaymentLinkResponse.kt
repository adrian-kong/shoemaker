package api.airwallex

import kotlinx.serialization.Serializable

@Serializable
data class CreatePaymentLinkResponse(
    var active: Boolean,
    var amount: Float,
    var currency: String,
    var code: String,
    var url: String,
    var description: String,
    var expire_at: String,
    var id: String,
    var title: String,
    var reference: String? = null,
    var reusable: Boolean,
    var created_at: String,
    var updated_at: String
)