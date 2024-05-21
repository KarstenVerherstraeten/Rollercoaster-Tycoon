package be.ehb.backend.DTO

import be.ehb.backend.Models.Attraction
import java.util.*

data class AttractionResponseDTO(
    val id: Long,
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
    val categoryName: String?,
    val maintenancePeriod: Date?,
    val breakdowns: List<BreakdownResponseDTO>
) {
    companion object {
        fun fromAttraction(attraction: Attraction): AttractionResponseDTO {
            return AttractionResponseDTO(
                id = attraction.id,
                name = attraction.name,
                buildYear = attraction.buildYear,
                capacity = attraction.capacity,
                picture = attraction.picture,
                video = attraction.video,
                minHeight = attraction.minHeight,
                maxHeight = attraction.maxHeight,
                fastPass = attraction.fastPass,
                disabled = attraction.disabled,
                description = attraction.description,
                maintenancePeriod = attraction.maintenancePeriod,
                categoryName = attraction.category?.name, // Get category name or null if category is null
                breakdowns = attraction.breakdowns.map { BreakdownResponseDTO.fromBreakdown(it) }
            )
        }
    }
}
