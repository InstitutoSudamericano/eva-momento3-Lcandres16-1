package com.example.evam3.controller

import com.example.evam3.model.Scenes
import com.example.evam3.service.ScenesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


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