package com.example.evam3.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "film")
class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var title: String? = null
    var director: String? = null
    var duration: Float? = null

    @JsonIgnore
    @OneToMany(mappedBy = "film", cascade = [CascadeType.ALL], orphanRemoval = true)
    var scenes: List<Scenes>? = null

    @JsonIgnore
    @OneToMany(mappedBy = "film", cascade = [CascadeType.ALL], orphanRemoval = true)
    var characters: List<Character>? = null
}