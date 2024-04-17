package be.ehb.backend.Service


import be.ehb.backend.Models.Category
import org.springframework.stereotype.Service
import be.ehb.backend.Repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired

@Service
class CategoryService {
    @Autowired
  lateinit var categoryRepository: CategoryRepository

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

    fun findOneById(id: Long): Category {
        return categoryRepository.findById(id).get()
    }
}