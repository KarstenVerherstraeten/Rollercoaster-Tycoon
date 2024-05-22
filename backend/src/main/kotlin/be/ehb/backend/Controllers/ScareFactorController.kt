package be.ehb.backend.Controllers

import be.ehb.backend.DTO.ScareFactorDTO
import be.ehb.backend.Models.ScareFactor
import be.ehb.backend.Service.AttractionService
import be.ehb.backend.Services.ScareFactorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/scarefactors")
class ScareFactorController {

    @Autowired
    lateinit var scareFactorService: ScareFactorService

    @Autowired
    lateinit var attractionService: AttractionService

    @PostMapping
    fun addScareFactor(@RequestBody scareFactorDTO: ScareFactorDTO): ResponseEntity<ScareFactorDTO> {
        val attraction = attractionService.getAttractionById(scareFactorDTO.attractionId)
            ?: return ResponseEntity.notFound().build()

        val scareFactor = ScareFactor(
            name = scareFactorDTO.name,
            factor = scareFactorDTO.factor,
            attraction = attraction
        )

        val savedScareFactor = scareFactorService.addScareFactor(scareFactor)
        return ResponseEntity.ok(ScareFactorDTO.fromScareFactor(savedScareFactor))
    }

    @GetMapping("/attraction/{attractionId}")
    fun getScareFactorsForAttraction(@PathVariable attractionId: Long): ResponseEntity<List<ScareFactorDTO>> {
        val scareFactors = scareFactorService.getScareFactorsForAttraction(attractionId)
        return ResponseEntity.ok(scareFactors.map { ScareFactorDTO.fromScareFactor(it) })
    }
}
