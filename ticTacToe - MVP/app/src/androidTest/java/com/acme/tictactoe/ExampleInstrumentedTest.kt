package com.acme.tictactoe

import android.content.Context
import android.support.test.InstrumentationRegistry
import java.lang.Exception

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        // Context of the app under test.
        val appContext: Context = InstrumentationRegistry.getTargetContext()
        assertEquals("com.acme.tictactoe", appContext.packageName)
    }
}