package airwallex

import api.airwallex.Address

data class AlphaMart(var shopper_email: String, var shopper_name: String)

data class Alipay(var flow: String, var os_type: String)

data class AXSKiosk(var shopper_email: String, var shopper_name: String, var shopper_phone: String)

data class Card(
    var billing: Billing,
    var cvc: String,
    var expiry_month: String,
    var expiry_year: String,
    var name: String,
    var number: String,
)

data class Billing(
    var address: Address? = null,
    var date_of_birth: String? = null,
    var email: String? = null,
    var first_name: String,
    var last_name: String,
    var phone_number: String? = null
)

data class PaymentConsentReference(var cvc: String? = null, var id: String)

data class PaymentMethodOptions(var card: PaymentMethodCard)

data class PaymentMethodCard(var auto_capture: Boolean, var three_ds: ThreeDomainSecure)

data class ThreeDomainSecure(
    var attempt_id: String,
    var device_data_collection_res: String,
    var ds_transaction_id: String,
    var option: Boolean,
    var pa_res: String,
    var return_url: String
)

data class DeviceData(
    var accept_header: String,
    var browser: Browser,
    var device_id: String,
    var ip_address: String,
    var language: String,
    var location: Location,
    var mobile: Mobile,
    var screen_color_depth: Int,
    var screen_height: Int,
    var screen_width: Int,
    var timezone: String
)

data class Mobile(var device_model: String, var os_type: String, var os_version: String)

data class Location(var lat: String, var lon: String)

data class Browser(var java_enabled: Boolean, var javascript_enabled: Boolean, var user_agent: String)

data class PaymentMethod(
    var alfamart: AlphaMart? = null,
    var alipayhk: Alipay? = null,
    var alipaycn: Alipay? = null,
    var axs_kiosk: AXSKiosk? = null,
    var card: Card? = null
    // TODO: finish payload
)

data class ConfirmIntentPayload(
    var request_id: String,
    var customer_id: String?,
    var payment_method: PaymentMethod,
    var payment_consent_reference: PaymentConsentReference,
    var payment_method_options: PaymentMethodOptions?,
    var device_data: DeviceData,
    var return_url: String,
)

//suspend fun confirmIntent(paymentIntent: PaymentIntent) {
//    client.post("$API_URL/api/v1/pa//payment_intents/${paymentIntent.id}/confirm") {
//        contentType(ContentType.Application.Json)
//        header(HttpHeaders.Authorization, "Bearer $ACCESS_TOKEN")
//        body = ConfirmIntentPayload()
//    }
//}