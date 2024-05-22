package be.ehb.backend.Repositories

import be.ehb.backend.Models.ScareFactor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ScareFactorRepository : JpaRepository<ScareFactor, Long> {
    fun findByAttractionId(attractionId: Long): List<ScareFactor>
}
