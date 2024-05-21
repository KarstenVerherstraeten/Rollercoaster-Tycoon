package be.ehb.backend.DTO

import be.ehb.backend.Models.Breakdown
import java.util.*

data class BreakdownResponseDTO(
    val id: Long,
    val attractionId: Long,
    val date: Date,
    val resolved: Boolean
) {
    companion object {
        fun fromBreakdown(breakdown: Breakdown): BreakdownResponseDTO {
            return BreakdownResponseDTO(
                id = breakdown.id,
                attractionId = breakdown.attraction.id,
                date = breakdown.date,
                resolved = breakdown.resolved
            )
        }
    }
}
