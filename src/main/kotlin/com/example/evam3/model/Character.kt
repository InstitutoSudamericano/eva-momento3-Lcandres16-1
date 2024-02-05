package com.example.evam3.model

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

    @ManyToOne
    @JoinColumn(name = "film_id")
    var film: Film? = null
}