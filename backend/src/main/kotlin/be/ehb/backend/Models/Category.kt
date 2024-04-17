package be.ehb.backend.Models


import jakarta.persistence.*

@Entity
@Table(name = "categories")
data
class Category (
    @Id
    @GeneratedValue
    val id: Long = -1,
    val name: String,

) {
}