package com.example.evam3.controller


import com.Factura_peticiones.model.film.Film
import com.example.evam3.service.FilmService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/film")
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
