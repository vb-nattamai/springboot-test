package com.vb.nattamai.travelassist.dto

import java.time.LocalDate
import jakarta.validation.constraints.NotBlank

data class TripDto(
    val id: Long? = null,

    @field:NotBlank
    val title: String,

    val description: String? = null,

    val destination: String? = null,

    val startDate: LocalDate? = null,

    val endDate: LocalDate? = null
)

