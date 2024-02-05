package com.example.evam3.controller

import com.example.evam3.model.Film
import com.example.evam3.service.FilmService
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
@RequestMapping("/films")
class FilmController {
    @Autowired
    lateinit var filmService: FilmService

    @GetMapping
    fun list(): List<Film> {
        return filmService.list()
    }

    @PostMapping
    fun save(@RequestBody film: Film): ResponseEntity<Film> {
        return ResponseEntity(filmService.save(film), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody film: Film): ResponseEntity<Film> {
        return ResponseEntity(filmService.update(film), HttpStatus.OK)
    }

    @PatchMapping
    fun updateTitle(@RequestBody film: Film): ResponseEntity<Film> {
        return ResponseEntity(filmService.updateTitle(film), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): Boolean? {
        return filmService.delete(id)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long): ResponseEntity<Film> {
        return ResponseEntity(filmService.listById(id), HttpStatus.OK)
        }

    }
