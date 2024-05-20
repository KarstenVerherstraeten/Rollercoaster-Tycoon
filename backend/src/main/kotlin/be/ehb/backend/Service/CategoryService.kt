package be.ehb.backend.Service

import be.ehb.backend.Models.Attraction
import be.ehb.backend.Models.Category
import be.ehb.backend.Repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryService {

    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    fun index(): List<Category> {
        return categoryRepository.findAll()
    }

    fun store(category: Category): Category {
        return categoryRepository.save(category)
    }

    fun update(category: Category): Category {
        return categoryRepository.save(category)
    }

    fun destroy(id: Long) {
        categoryRepository.deleteById(id)
    }

    fun findByName(name: String): Optional<Category> {
        return categoryRepository.findByName(name)
    }

    fun addAttractionToCategory(category: Category, attraction: Attraction) {
        category.attractions.add(attraction)
        attraction.category = category
        categoryRepository.save(category)
    }
}
