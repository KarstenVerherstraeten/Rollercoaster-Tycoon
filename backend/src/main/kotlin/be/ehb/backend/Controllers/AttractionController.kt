package be.ehb.backend.Controllers

import UpdateAttractionRequest
import be.ehb.backend.DTO.AttractionResponseDTO
import be.ehb.backend.DTO.CreateAttractionRequest
import be.ehb.backend.Models.Attraction
import be.ehb.backend.Repositories.AttractionRepository
import be.ehb.backend.Service.AttractionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("attractions")
class AttractionController {
    @Autowired
    lateinit var attractionService: AttractionService

    @GetMapping
    fun index(): List<AttractionResponseDTO> {
        return attractionService.index()
    }

    @PostMapping
    fun store(@RequestBody createAttractionRequest: CreateAttractionRequest): ResponseEntity<Attraction> {
        val newAttraction = attractionService.newAttraction(createAttractionRequest)
        return ResponseEntity(newAttraction, HttpStatus.CREATED)
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody updateRequest: UpdateAttractionRequest): ResponseEntity<AttractionResponseDTO> {
        val updatedAttraction = attractionService.updateAttraction(id, updateRequest)
        return ResponseEntity(updatedAttraction, HttpStatus.OK)
    }

    @DeleteMapping("{id}")
    fun destroy(@PathVariable id: Long) {
        attractionService.destroy(id)
        //return "Attraction deleted"


    }


    // extra
    @GetMapping("search/{name}")
    fun findByName(@PathVariable name: String): Attraction {
        return attractionService.findByName(name)
    }
}