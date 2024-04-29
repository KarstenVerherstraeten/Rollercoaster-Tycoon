package be.ehb.backend.Repositories

import be.ehb.backend.Models.Attraction
import be.ehb.backend.Models.Category
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface CategoryRepository: JpaRepository<Category,Long>{
    fun findByName(name: String?): Optional<Category>
}