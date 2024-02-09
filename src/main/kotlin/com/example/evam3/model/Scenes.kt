package com.example.evam3.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*


@Entity
@Table(name = "scene")
class Scenes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var description: String? = null
    var minutes: Int? = null
    var location: String? = null
    var budget: Float? = null

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "film_id")
    var film: Film? = null

    @JsonManagedReference
    @OneToMany(mappedBy = "scene")
    var characters: List<Character>? = null
}