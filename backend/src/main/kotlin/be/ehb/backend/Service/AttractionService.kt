package be.ehb.backend.Service


import be.ehb.backend.DTO.CreateAttractionRequest
import be.ehb.backend.Models.Attraction
import be.ehb.backend.Repositories.AttractionRepository
import be.ehb.backend.Repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AttractionService {
    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    @Autowired
    lateinit var attractionRepository: AttractionRepository

    fun index(): List<Attraction>{
        return attractionRepository.findAll()
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

    fun newAttraction(attractionRequest: CreateAttractionRequest): Attraction {

        var newAttraction = Attraction(
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
            maintenancePeriod = attractionRequest.maintenancePeriod,
        )
        var category = categoryRepository.findByName(attractionRequest.categoryName)

        newAttraction.category = category.get()
        return attractionRepository.save(newAttraction)
    }

}