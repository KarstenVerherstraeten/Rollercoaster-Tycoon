package be.ehb.backend.Models

import jakarta.persistence.*

@Entity
@Table(name = "scare_factors")
data
class ScareFactor (
    @Id
    @GeneratedValue
    val id: Long = -1,
    val name: String,
    val factor: Int
) {
}