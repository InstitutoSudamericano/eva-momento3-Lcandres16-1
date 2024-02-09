package com.example.evam3.repository

import com.example.evam3.model.Scenes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface ScenesRepository:JpaRepository<Scenes, Long> {
    fun findById (id: Long?): Scenes?
    fun findByDescription(tittle: String?): List<Scenes>
    @Query("SELECT * FROM scene WHERE film_id = :filmId", nativeQuery = true)
    fun findAllByFilmId(@Param("filmId") filmId: Long?): List<Scenes>
}