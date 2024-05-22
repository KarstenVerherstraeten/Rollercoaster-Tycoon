package be.ehb.backend.DTO

import be.ehb.backend.Models.ScareFactor

data class ScareFactorDTO(
    val id: Long,
    val name: String,
    val factor: Int,
    val attractionId: Long
) {
    companion object {
        fun fromScareFactor(scareFactor: ScareFactor): ScareFactorDTO {
            return ScareFactorDTO(
                id = scareFactor.id,
                name = scareFactor.name,
                factor = scareFactor.factor,
                attractionId = scareFactor.attraction.id
            )
        }
    }
}
