package airwallex.intent

import airwallex.ACCESS_TOKEN
import airwallex.API_URL
import api.airwallex.CreatePaymentLinkResponse
import client
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.Serializable


@Serializable
data class CreatePaymentLinkPayload(
    var amount: Float,
    var currency: String,
    var expire_at: String? = null,
    var reusable: Boolean,
    var title: String,
    var description: String? = null,
    var reference: String? = null
)

suspend fun createPaymentLink(payload: CreatePaymentLinkPayload): CreatePaymentLinkResponse {
    return client.post("$API_URL/api/v1/pa/payment_links/create") {
        contentType(ContentType.Application.Json)
        header(HttpHeaders.Authorization, "Bearer $ACCESS_TOKEN")
        body = payload
    }
}