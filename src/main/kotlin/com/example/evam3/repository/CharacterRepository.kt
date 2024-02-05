package com.example.evam3.repository

import com.example.evam3.model.Character
import org.springframework.data.jpa.repository.JpaRepository

interface CharacterRepository: JpaRepository<Character, Long> {
    fun findById(id: Long?): Character?
}