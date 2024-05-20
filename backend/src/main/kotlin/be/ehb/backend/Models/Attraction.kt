package be.ehb.backend.Models

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "attractions")
data class Attraction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1,

    val name: String,
    val buildYear: Int,
    val capacity: Int,
    val picture: String?,
    val video: String?,
    val minHeight: Int,
    val maxHeight: Int,
    val fastPass: Boolean,
    val disabled: Boolean,
    val description: String,
    val maintenancePeriod: Date?,

    @JsonBackReference // This annotation helps break the circular reference
    @ManyToOne
    @JoinColumn(name = "category_id")
    var category: Category? = null
)
