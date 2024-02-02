package com.example.evam3.repository

import com.Factura_peticiones.model.Scenes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ScenesRepository:JpaRepository<Scenes, Long> {
    fun findById (id: Long?): Scenes?
    fun findByDescription(tittle: String?): List<Scenes>

}