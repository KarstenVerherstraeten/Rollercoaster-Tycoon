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

    var name: String,
    var buildYear: Int,
    var capacity: Int,
    var picture: String?,
    var video: String?,
    var minHeight: Int,
    var maxHeight: Int,
    var fastPass: Boolean,
    var disabled: Boolean,
    var description: String,
    var maintenancePeriod: Date?,

    @JsonBackReference // This annotation helps break the circular reference
    @ManyToOne
    @JoinColumn(name = "category_id")
    var category: Category? = null,


    @OneToMany(mappedBy = "attraction")
    var breakdowns: List<Breakdown> = mutableListOf()
)

