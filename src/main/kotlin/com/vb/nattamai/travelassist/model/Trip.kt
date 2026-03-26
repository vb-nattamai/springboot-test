package com.vb.nattamai.travelassist.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "trips")
data class Trip(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var title: String,

    var description: String? = null,

    var destination: String? = null,

    var startDate: LocalDate? = null,

    var endDate: LocalDate? = null
)

