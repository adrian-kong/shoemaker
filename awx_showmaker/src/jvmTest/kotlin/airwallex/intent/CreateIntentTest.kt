package airwallex.intent

import airwallex.ACCESS_TOKEN
import airwallex.fetchAccessToken
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class CreateIntentTest {

    @Test
    fun testCreateIntentPayload() {
        val intent = IntentPayload(
            request_id = "cd7ccaf3-39e6-49e9-a3bd-ceb135187d13",
            amount = 100.0f,
            currency = "USD",
            merchant_order_id = "8ed0d5d6-342a-4342-925d-fbb0c156446c",
        )
        val actualOutput = Json.encodeToString(intent)
        val expectedOutput =
            "{\"request_id\":\"cd7ccaf3-39e6-49e9-a3bd-ceb135187d13\",\"amount\":100.0,\"currency\":\"USD\",\"merchant_order_id\":\"8ed0d5d6-342a-4342-925d-fbb0c156446c\"}"
        assertEquals(actualOutput, expectedOutput, "Incorrect Intent object serializing")
    }

    @Test
    fun testCreateIntentRequest() {
        runBlocking {
            // Assumes LoginAuthenticationTest passes
            ACCESS_TOKEN = fetchAccessToken()
            val intent = IntentPayload(
                request_id = UUID.randomUUID().toString(),
                amount = 100.0f,
                currency = "USD",
                merchant_order_id = UUID.randomUUID().toString(),
            )
            val response = createIntent(intent)
            assertNotNull(response, "Create Payment Intent should not return null")
        }
    }

}