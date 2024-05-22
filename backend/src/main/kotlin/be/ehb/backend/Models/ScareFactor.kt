package be.ehb.backend.Models

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "scare_factors")
data class ScareFactor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,
    val name: String,
    val factor: Int,

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "attraction_id") // Specify the foreign key column
    var attraction: Attraction
)
