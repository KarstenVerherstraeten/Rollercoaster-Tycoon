package be.ehb.backend.Service

import UpdateAttractionRequest
import be.ehb.backend.DTO.AttractionResponseDTO
import be.ehb.backend.DTO.BreakdownResponseDTO
import be.ehb.backend.DTO.ScareFactorDTO
import be.ehb.backend.DTO.CreateAttractionRequest
import be.ehb.backend.Models.Attraction
import be.ehb.backend.Models.Breakdown
import be.ehb.backend.Models.Category
import be.ehb.backend.Repositories.AttractionRepository
import be.ehb.backend.Repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import java.util.*

@Service
class AttractionService {

    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    @Autowired
    private lateinit var attractionRepository: AttractionRepository

    @Autowired
    private lateinit var categoryService: CategoryService

    fun index(): List<AttractionResponseDTO> {
        val attractions = attractionRepository.findAll()
        return attractions.map { AttractionResponseDTO.fromAttraction(it) }
    }

    fun store(attraction: Attraction): Attraction {
        return attractionRepository.save(attraction)
    }

    fun updateAttraction(id: Long, updateRequest: UpdateAttractionRequest): AttractionResponseDTO {
        val attraction = attractionRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Attraction not found with id: $id") }

        updateRequest.name?.let { attraction.name = it }
        updateRequest.buildYear?.let { attraction.buildYear = it }
        updateRequest.capacity?.let { attraction.capacity = it }
        updateRequest.picture?.let { attraction.picture = it }
        updateRequest.video?.let { attraction.video = it }
        updateRequest.minHeight?.let { attraction.minHeight = it }
        updateRequest.maxHeight?.let { attraction.maxHeight = it }
        updateRequest.fastPass?.let { attraction.fastPass = it }
        updateRequest.disabled?.let { attraction.disabled = it }
        updateRequest.description?.let { attraction.description = it }

        // Parse maintenancePeriod if not null
        updateRequest.maintenancePeriod?.let {
            val maintenanceDate = Date(it)
            attraction.maintenancePeriod = maintenanceDate
        }

        updateRequest.categoryName?.let {
            val category = categoryRepository.findByName(it)
                .orElseThrow { EntityNotFoundException("Category not found with name: $it") }
            categoryService.addAttractionToCategory(category, attraction)
        }

        // Save the updated attraction
        val updatedAttraction = attractionRepository.save(attraction)
        return AttractionResponseDTO.fromAttraction(updatedAttraction)
    }


    fun destroy(id: Long) {
        attractionRepository.deleteById(id)
    }

    fun findByName(name: String): Attraction {
        return attractionRepository.findOneByName(name)
    }

    fun getAttractionById(id: Long): Attraction? {
        return attractionRepository.findById(id).orElse(null)
    }

    @Transactional
    fun newAttraction(attractionRequest: CreateAttractionRequest): Attraction {
        val optionalCategory: Optional<Category> = categoryRepository.findByName(attractionRequest.categoryName)

        val category = optionalCategory.orElseThrow {
            EntityNotFoundException("Category not found")
        }

        val newAttraction = Attraction(
            name = attractionRequest.name,
            buildYear = attractionRequest.buildYear,
            capacity = attractionRequest.capacity,
            picture = attractionRequest.picture,
            video = attractionRequest.video,
            minHeight = attractionRequest.minHeight,
            maxHeight = attractionRequest.maxHeight,
            fastPass = attractionRequest.fastPass,
            disabled = attractionRequest.disabled,
            description = attractionRequest.description,
            maintenancePeriod = attractionRequest.maintenancePeriod
        )

        // Save the new attraction first to generate its ID
        val savedAttraction = attractionRepository.save(newAttraction)

        // Use the CategoryService to add the attraction to the category
        categoryService.addAttractionToCategory(category, savedAttraction)

        return savedAttraction
    }

    fun mapToAttractionResponseDTO(attraction: Attraction): AttractionResponseDTO {
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
            categoryName = attraction.category?.name,
            breakdowns = attraction.breakdowns.map { BreakdownResponseDTO.fromBreakdown(it) },
            scareFactors = attraction.scareFactors.map { ScareFactorDTO.fromScareFactor(it) }
        )
    }
}

