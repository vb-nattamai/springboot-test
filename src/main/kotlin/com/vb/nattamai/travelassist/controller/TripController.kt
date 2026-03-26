package com.vb.nattamai.travelassist.controller

import com.vb.nattamai.travelassist.dto.TripDto
import com.vb.nattamai.travelassist.model.Trip
import com.vb.nattamai.travelassist.service.TripService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/trips")
class TripController(private val service: TripService) {

    @GetMapping
    fun list(): List<Trip> = service.findAll()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<Trip> =
        service.findById(id).map { ResponseEntity.ok(it) }.orElse(ResponseEntity.notFound().build())

    @PostMapping
    fun create(@Valid @RequestBody dto: TripDto): ResponseEntity<Trip> =
        ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody dto: TripDto): ResponseEntity<Trip> =
        service.update(id, dto).map { ResponseEntity.ok(it) }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) = service.delete(id)
}

