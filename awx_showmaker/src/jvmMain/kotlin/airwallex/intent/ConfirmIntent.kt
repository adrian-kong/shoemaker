package airwallex.intent

import airwallex.ACCESS_TOKEN
import airwallex.API_URL
import api.airwallex.Address
import api.airwallex.PaymentIntentResponse
import client
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

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

//suspend fun confirmIntent(intent: PaymentIntentResponse) {
//    val paymentMethod = PaymentMethod()
//    var response: HttpResponse = client.post("$API_URL/api/v1/pa/payment_intents/${intent.id}/confirm") {
//        contentType(ContentType.Application.Json)
//        header(HttpHeaders.Authorization, "Bearer $ACCESS_TOKEN")
//        body = "{\n" +
//                "  \"device_data\": {\n" +
//                "    \"accept_header\": \"*/*\",\n" +
//                "    \"browser\": {\n" +
//                "      \"java_enabled\": false,\n" +
//                "      \"javascript_enabled\": true,\n" +
//                "      \"user_agent\": \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36\"\n" +
//                "    },\n" +
//                "    \"device_id\": \"00000000-000000000000000\",\n" +
//                "    \"ip_address\": \"212.121.222.123\",\n" +
//                "    \"language\": \"EN or en-US\",\n" +
//                "    \"location\": {\n" +
//                "      \"lat\": \"-37.81892\",\n" +
//                "      \"lon\": \"144.95913\"\n" +
//                "    },\n" +
//                "    \"mobile\": {\n" +
//                "      \"device_model\": \"Apple IPHONE 7\",\n" +
//                "      \"os_type\": \"IOS or ANDROID\",\n" +
//                "      \"os_version\": \"IOS 14.5\"\n" +
//                "    },\n" +
//                "    \"screen_color_depth\": 24,\n" +
//                "    \"screen_height\": 1080,\n" +
//                "    \"screen_width\": 1920,\n" +
//                "    \"timezone\": \"-2 or 3:30\"\n" +
//                "  },\n" +
//                "  \"request_id\": \"${intent.request_id}\",\n" +
//                "  \"return_url\": \"string\",\n" +
//                "  \"verification_options\": {\n" +
//                "    \"card\": {\n" +
//                "      \"amount\": 0,\n" +
//                "      \"currency\": \"CNY\",\n" +
//                "      \"cvc\": \"string\"\n" +
//                "    }\n" +
//                "  }\n" +
//                "}"
//    }
//    println(response.readText())
//}