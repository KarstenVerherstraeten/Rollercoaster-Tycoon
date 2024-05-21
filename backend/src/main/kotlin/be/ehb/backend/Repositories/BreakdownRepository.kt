package be.ehb.backend.Repositories

import be.ehb.backend.Models.Breakdown
import org.springframework.data.jpa.repository.JpaRepository

interface BreakdownRepository : JpaRepository<Breakdown, Long> {
    fun findByAttractionIdAndResolvedFalse(attractionId: Long): List<Breakdown>
    fun findByAttractionId(attractionId: Long): List<Breakdown>
}
