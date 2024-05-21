package be.ehb.backend.Service

import be.ehb.backend.DTO.BreakdownRequestDTO
import be.ehb.backend.DTO.BreakdownResponseDTO
import be.ehb.backend.Models.Breakdown
import be.ehb.backend.Repositories.AttractionRepository
import be.ehb.backend.Repositories.BreakdownRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class BreakdownService {

    @Autowired
    private lateinit var breakdownRepository: BreakdownRepository

    @Autowired
    private lateinit var attractionRepository: AttractionRepository

    @Transactional

    fun index(): List<BreakdownResponseDTO> {
        val breakdowns = breakdownRepository.findAll()
        return breakdowns.map { BreakdownResponseDTO.fromBreakdown(it) }
    }

    fun registerBreakdown(breakdownRequestDTO: BreakdownRequestDTO): BreakdownResponseDTO {
        val attraction = attractionRepository.findById(breakdownRequestDTO.attractionId)
            .orElseThrow { EntityNotFoundException("Attraction not found with id: ${breakdownRequestDTO.attractionId}") }

        val breakdown = Breakdown(
            attraction = attraction,
            date = breakdownRequestDTO.date,
            resolved = false
        )

        val savedBreakdown = breakdownRepository.save(breakdown)
        return BreakdownResponseDTO(
            id = savedBreakdown.id,
            attractionId = savedBreakdown.attraction.id,
            date = savedBreakdown.date,
            resolved = savedBreakdown.resolved
        )
    }

    fun getBreakdownsForAttraction(attractionId: Long): List<BreakdownResponseDTO> {
        val breakdowns = breakdownRepository.findByAttractionId(attractionId)
        return breakdowns.map { breakdown ->
            BreakdownResponseDTO(
                id = breakdown.id,
                attractionId = breakdown.attraction.id,
                date = breakdown.date,
                resolved = breakdown.resolved
            )
        }
    }

    @Transactional
    fun resolveBreakdown(breakdownId: Long): BreakdownResponseDTO {
        val breakdown = breakdownRepository.findById(breakdownId)
            .orElseThrow { EntityNotFoundException("Breakdown not found with id: $breakdownId") }

        breakdown.resolved = true
        val updatedBreakdown = breakdownRepository.save(breakdown)
        return BreakdownResponseDTO(
            id = updatedBreakdown.id,
            attractionId = updatedBreakdown.attraction.id,
            date = updatedBreakdown.date,
            resolved = updatedBreakdown.resolved
        )
    }
}
