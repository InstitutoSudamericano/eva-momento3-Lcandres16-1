package com.example.evam3.repository

import com.example.evam3.model.Character
import com.example.evam3.model.Scenes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CharacterRepository: JpaRepository<Character, Long> {
    fun findById(id: Long?): Character?

    @Query("SELECT * FROM character WHERE scene_id = :sceneId", nativeQuery = true)
    fun findAllBySceneId(@Param("sceneId") sceneId: Long?): List<Character>
}