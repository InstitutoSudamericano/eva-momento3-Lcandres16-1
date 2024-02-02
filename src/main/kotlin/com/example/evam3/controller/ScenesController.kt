package com.example.evam3.controller

import com.Factura_peticiones.model.Scenes
import com.example.evam3.service.ScenesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/scenes")
class ScenesController {
    @Autowired
    lateinit var scenesService: ScenesService

    @GetMapping
    fun list(): List<Scenes> {
        return scenesService.list()
    }

    @PostMapping
    fun save(@RequestBody scenes: Scenes): ResponseEntity<Scenes> {
        return ResponseEntity(scenesService.save(scenes), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody scenes: Scenes): ResponseEntity<Scenes> {
        return ResponseEntity(scenesService.update(scenes), HttpStatus.OK)
    }

    @PatchMapping
    fun updateTitle(@RequestBody scenes: Scenes): ResponseEntity<Scenes> {
        return ResponseEntity(scenesService.updateLocation(scenes), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): Boolean? {
        return scenesService.delete(id)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long): ResponseEntity<Scenes> {
        return ResponseEntity(scenesService.listById(id), HttpStatus.OK)
    }
}