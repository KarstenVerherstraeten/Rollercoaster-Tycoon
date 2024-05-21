package be.ehb.backend.Controllers

import be.ehb.backend.DTO.BreakdownRequestDTO
import be.ehb.backend.DTO.BreakdownResponseDTO
import be.ehb.backend.Service.BreakdownService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("breakdowns")
class BreakdownController {

    @Autowired
    private lateinit var breakdownService: BreakdownService

    @PostMapping
    fun registerBreakdown(@RequestBody breakdownRequestDTO: BreakdownRequestDTO): ResponseEntity<BreakdownResponseDTO> {
        val breakdown = breakdownService.registerBreakdown(breakdownRequestDTO)
        return ResponseEntity.ok(breakdown)
    }

    @GetMapping("attraction/{attractionId}")
    fun getBreakdownsForAttraction(@PathVariable attractionId: Long): ResponseEntity<List<BreakdownResponseDTO>> {
        val breakdowns = breakdownService.getBreakdownsForAttraction(attractionId)
        return ResponseEntity.ok(breakdowns)
    }

    @PatchMapping("{breakdownId}/resolve")
    fun resolveBreakdown(@PathVariable breakdownId: Long): ResponseEntity<BreakdownResponseDTO> {
        val breakdown = breakdownService.resolveBreakdown(breakdownId)
        return ResponseEntity.ok(breakdown)
    }
}
