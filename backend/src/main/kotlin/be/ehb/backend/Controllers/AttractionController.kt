package be.ehb.backend.Controllers

import be.ehb.backend.Models.Attraction
import be.ehb.backend.Service.AttractionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("attractions")
class AttractionController {
    @Autowired
    lateinit var attractionService: AttractionService

    @GetMapping
    fun index(): List<Attraction> {
        return attractionService.index()
    }

    @PostMapping
    fun store(@RequestBody attraction: Attraction): Attraction {
        return attractionService.store(attraction)

    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody attraction: Attraction): Attraction {
        attraction.id = id
        return attractionService.update(attraction)
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