package be.ehb.backend.Repositories

import be.ehb.backend.Models.Attraction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AttractionRepository: JpaRepository<Attraction,Long> {
    fun findOneByName(name: String): Attraction
}