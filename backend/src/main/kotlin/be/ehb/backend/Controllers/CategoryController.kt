package be.ehb.backend.Controllers

import be.ehb.backend.Models.Category
import be.ehb.backend.Service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
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
    fun update(@PathVariable id: Long, @RequestBody category: Category): Category {
        category.id = id
        return categoryService.update(category)
    }

    @DeleteMapping("{id}")
    fun destroy(@PathVariable id: Long) {
        categoryService.destroy(id)
    }
}
