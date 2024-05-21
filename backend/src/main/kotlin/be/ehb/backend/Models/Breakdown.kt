package be.ehb.backend.Models

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "breakdowns")
data class Breakdown(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,

    @JsonBackReference // Prevents circular reference during serialization
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attraction_id")
    val attraction: Attraction,

    val date: Date,

    var resolved: Boolean = false
)

