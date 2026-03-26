package com.vb.nattamai.travelassist.repository

import com.vb.nattamai.travelassist.model.Trip
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TripRepository : JpaRepository<Trip, Long>

