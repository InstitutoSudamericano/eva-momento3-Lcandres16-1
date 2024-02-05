package com.example.evam3.service

import com.example.evam3.model.Scenes
import com.example.evam3.repository.FilmRepository
import com.example.evam3.repository.ScenesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ScenesService {
    @Autowired
    lateinit var scenesRepository: ScenesRepository
    @Autowired
    lateinit var  filmRepository: FilmRepository

    fun list(): List<Scenes> {
        return scenesRepository.findAll()
    }

    fun save(scenes: Scenes): Scenes {
        try {
            scenes.location?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Location must not be empty")

            val film = filmRepository.findById(scenes.film?.id)?:
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "film not found")
            val remainingTime = film.duration!! - scenes.duration!!
            if(remainingTime < 0){
                throw ResponseStatusException(HttpStatus.BAD_REQUEST, "there is no enough time to create a new scene")
            }
            val createdScene = scenesRepository.save(scenes)
            filmRepository.save(film)

            return createdScene
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    fun update(scenes: Scenes): Scenes {
        try {
            scenesRepository.findById(scenes.id)
                    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "ID does not exist")

            return scenesRepository.save(scenes)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateLocation(scenes: Scenes): Scenes {
        try {
            val response = scenesRepository.findById(scenes.id)
                    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "ID does not exist")

            response.apply {
                location = scenes.location
            }

            return scenesRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long?): Boolean? {
        try {
            scenesRepository.findById(id)
                    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "ID does not exist")

            scenesRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun listById(id: Long?): Scenes? {
        return scenesRepository.findById(id)
    }
}