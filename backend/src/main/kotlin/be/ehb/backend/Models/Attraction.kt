package be.ehb.backend.Models

import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "attractions")

data class Attraction (

    // vergeet niet date etc terug niet nullable te maken

    @Id
    @GeneratedValue
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
    val maintenancePeriod: Date?


) {


}