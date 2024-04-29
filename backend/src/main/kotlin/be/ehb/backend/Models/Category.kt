package be.ehb.backend.Models


import jakarta.persistence.*

@Entity
@Table(name = "categories")
data
class Category (
    @Id
    @GeneratedValue
    var id: Long = -1,
    val name: String,

) {

    @OneToMany
    var attractions: List<Attraction> = mutableListOf()
}