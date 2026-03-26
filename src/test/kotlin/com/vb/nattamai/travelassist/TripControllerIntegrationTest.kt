package com.vb.nattamai.travelassist

import com.vb.nattamai.travelassist.model.Trip
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate

class TripUnitTest {

    @Test
    fun `trip data class basic`() {
        val t = Trip(title = "T1", description = "d", destination = "D1", startDate = LocalDate.now(), endDate = LocalDate.now().plusDays(1))
        assertEquals("T1", t.title)
        assertEquals("D1", t.destination)
        // copy
        val copy = t.copy(title = "T2")
        assertEquals("T2", copy.title)
    }
}
