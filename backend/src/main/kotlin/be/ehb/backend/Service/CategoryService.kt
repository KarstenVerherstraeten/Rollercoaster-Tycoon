package be.ehb.backend.Service

import be.ehb.backend.Models.Attraction
import be.ehb.backend.Models.Category
import be.ehb.backend.Repositories.CategoryRepository
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
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

    @Transactional
    fun update(id: Long, updatedCategory: Category): Category {
        val category = categoryRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Category not found with id: $id") }

        // Check if the category contains any attractions
        if (category.attractions.isNotEmpty()) {
            throw DataIntegrityViolationException("Cannot update category because it contains attractions")
        }

        // Update the category
        // Assign updatedCategory fields to category or implement your update logic here...
        category.name = updatedCategory.name

        // Save the updated category
        return categoryRepository.save(category)
    }


    @Transactional
    fun destroy(id: Long) {
        val category = categoryRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Category not found with id: $id") }

        // Check if the category contains any attractions
        if (category.attractions.isNotEmpty()) {
            throw DataIntegrityViolationException("Cannot delete category because it contains attractions")
        }

        // Delete the category
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
