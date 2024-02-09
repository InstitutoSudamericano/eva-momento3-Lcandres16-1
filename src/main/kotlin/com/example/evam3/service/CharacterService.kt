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
    @Autowired
    lateinit var scenesService: ScenesService

    fun findAll() = characterRepository.findAll()

    fun save(character: Character): Character{
        val scene = scenesService.listById(character.scene?.id)
        val allCharacter = characterRepository.findAllBySceneId(character.scene?.id)
        var totalDuration = character.cost!!
        allCharacter.forEach { totalDuration += it.cost!! }
        if(totalDuration > scene?.budget!!){
            throw  Exception("budget exceeded")
        }
        return characterRepository.save(character)
    }

    fun patch(character: Character): Character{
        val characterToPatch = characterRepository.findById(character.id)?:
        throw ResponseStatusException(HttpStatus.NOT_FOUND, "user not found")
        characterToPatch.apply {
            name = character.name
            cost = character.cost
            role = character.role
        }
        return  characterRepository.save(characterToPatch)
    }

    fun delete(id: Long?): Boolean{
        val character = characterRepository.findById(id)?: throw Exception("character not found")
        characterRepository.deleteById(id!!)
        return true

    }
}