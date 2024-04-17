package be.ehb.backend.Models

import jakarta.persistence.*
@Entity
@Table(name = "breakdowns")
data
class Breakdown(
    @Id
    @GeneratedValue
    val id: Long = -1,
    val attractionId: Long,
    val date: String
) {
}