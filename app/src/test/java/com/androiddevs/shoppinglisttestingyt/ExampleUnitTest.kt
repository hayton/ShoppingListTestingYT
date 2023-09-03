package com.androiddevs.shoppinglisttestingyt

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `test decode`() {
        val input = "lint:;code:;love:;you"

        val decode = Solution().decode(input)

        assertEquals(listOf("lint", "code", "love", "you"), decode)
    }

    @Test
    fun `test encode`() {
        val input = listOf("lint", "code", "love", "you")

        val encode = Solution().encode(input)

        assertEquals("lint:;code:;love:;you", encode)
    }
}

