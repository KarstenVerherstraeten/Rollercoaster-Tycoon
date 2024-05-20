package be.ehb.backend.Service

import be.ehb.backend.DTO.AttractionResponseDTO
import be.ehb.backend.DTO.CreateAttractionRequest
import be.ehb.backend.Models.Attraction
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

    fun update(attraction: Attraction): Attraction {
        return attractionRepository.save(attraction)
    }

    fun destroy(id: Long) {
        attractionRepository.deleteById(id)
    }

    fun findByName(name: String): Attraction {
        return attractionRepository.findOneByName(name)
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
}
