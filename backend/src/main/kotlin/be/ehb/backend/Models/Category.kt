package be.ehb.backend.Models

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "categories")
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1,

    val name: String,

    @JsonManagedReference // This annotation helps break the circular reference
    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL], orphanRemoval = true)
    val attractions: MutableList<Attraction> = mutableListOf()
)
