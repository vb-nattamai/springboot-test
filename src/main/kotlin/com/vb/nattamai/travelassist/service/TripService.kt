package com.vb.nattamai.travelassist.service

import com.vb.nattamai.travelassist.dto.TripDto
import com.vb.nattamai.travelassist.model.Trip
import com.vb.nattamai.travelassist.repository.TripRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class TripService(private val repo: TripRepository) {

    fun findAll(): List<Trip> = repo.findAll()

    fun findById(id: Long): Optional<Trip> = repo.findById(id)

    @Transactional
    fun create(dto: TripDto): Trip {
        val trip = Trip(
            title = dto.title,
            description = dto.description,
            destination = dto.destination,
            startDate = dto.startDate,
            endDate = dto.endDate
        )
        return repo.save(trip)
    }

    @Transactional
    fun update(id: Long, dto: TripDto): Optional<Trip> {
        val existing = repo.findById(id)
        if (existing.isEmpty) return Optional.empty()
        val t = existing.get()
        t.title = dto.title
        t.description = dto.description
        t.destination = dto.destination
        t.startDate = dto.startDate
        t.endDate = dto.endDate
        return Optional.of(repo.save(t))
    }

    @Transactional
    fun delete(id: Long) = repo.deleteById(id)
}
