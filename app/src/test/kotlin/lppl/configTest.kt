package lppl

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertEquals
import kotlin.test.fail
import com.github.stefanbirkner.systemlambda.SystemLambda.withEnvironmentVariable

class ConfigTest {
    @Test fun `fail if api key is not set`() {
        try {
            lppl.Config().apiKey
        } catch (exception: NullPointerException) {
            return
        }
        
        fail("NullPointerException not raised")
    }

    @Test fun `apiKey read from environment`() {
        withEnvironmentVariable("API_KEY", "myApiKey").execute(
            {
                assertEquals(lppl.Config().apiKey, "myApiKey")
            }
        )
    }
}