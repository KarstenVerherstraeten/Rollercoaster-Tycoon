package be.ehb.backend.Service


import be.ehb.backend.Models.Attraction
import be.ehb.backend.Repositories.AttractionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AttractionService {
    @Autowired
    lateinit var attractionRepository: AttractionRepository

    fun index(): List<Attraction>{
        return attractionRepository.findAll()
    }

    fun store(attraction: Attraction): Attraction {

        return attractionRepository.save(attraction)
    }

    fun show(id: Long): Attraction {
        return attractionRepository.getOne(id)
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
    
}