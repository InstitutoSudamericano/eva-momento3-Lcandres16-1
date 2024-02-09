package com.example.evam3.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table


@Entity
@Table(name = "character")
class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String? = null
    var role: String? = null
    var cost: Float? = null

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "scene_id")
    var scene: Scenes? = null
}