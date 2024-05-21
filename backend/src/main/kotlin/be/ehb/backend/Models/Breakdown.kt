package be.ehb.backend.Models

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "breakdowns")
data class Breakdown(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,

    @ManyToOne
    @JoinColumn(name = "attraction_id")
    val attraction: Attraction,

    val date: Date,

    var resolved: Boolean = false
)
