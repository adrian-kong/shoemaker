package airwallex

import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertTrue

class LoginAuthenticationTest {

    @Test
    fun testFetchAccessToken() {
        runBlocking {
            // JSON Web Token constraint
            assertTrue(fetchAccessToken().startsWith("eyJ"), "Access token should be a JWT token")
        }
    }
}