package be.ehb.backend.Services

import be.ehb.backend.Models.ScareFactor
import be.ehb.backend.Repositories.ScareFactorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ScareFactorService {

    @Autowired
    lateinit var scareFactorRepository: ScareFactorRepository

    fun addScareFactor(scareFactor: ScareFactor): ScareFactor {
        return scareFactorRepository.save(scareFactor)
    }

    fun getScareFactorsForAttraction(attractionId: Long): List<ScareFactor> {
        return scareFactorRepository.findByAttractionId(attractionId)
    }
}
