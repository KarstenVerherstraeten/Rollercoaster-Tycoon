package be.ehb.backend.Controllers

import be.ehb.backend.Models.Category
import be.ehb.backend.Service.CategoryService
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("categories")
class CategoryController {

    @Autowired
    lateinit var categoryService: CategoryService

    @GetMapping
    fun index(): List<Category> {
        return categoryService.index()
    }

    @PostMapping
    fun store(@RequestBody category: Category): Category {
        return categoryService.store(category)
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody category: Category): ResponseEntity<Any> {
        try {
            val updatedCategory = categoryService.update(id, category)
            return ResponseEntity.ok(updatedCategory)
        } catch (ex: DataIntegrityViolationException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot update category because it contains attractions")
        } catch (ex: EntityNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found with id: $id")
        }
    }

    @DeleteMapping("{id}")
    fun destroy(@PathVariable id: Long): ResponseEntity<Any> {
        try {
            categoryService.destroy(id)
            return ResponseEntity.ok("Category with id $id successfully deleted")
        } catch (ex: DataIntegrityViolationException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Cannot delete category because it contains attractions")
        } catch (ex: EntityNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Category not found with id: $id")
        }
    }

}
