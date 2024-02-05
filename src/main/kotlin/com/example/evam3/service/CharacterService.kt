package com.example.evam3.service

import com.example.evam3.model.Character
import com.example.evam3.repository.CharacterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CharacterService {
    @Autowired
    lateinit var characterRepository: CharacterRepository

    fun findAll() = characterRepository.findAll()

    fun save(character: Character) = characterRepository.save(character)

    fun patch(character: Character): Character{
        characterRepository.findById(character.id)?:
        throw ResponseStatusException(HttpStatus.NOT_FOUND, "user not found")
        return  characterRepository.save(character)
    }
}