package be.ehb.backend.Repositories

import be.ehb.backend.Models.Category
import org.springframework.data.jpa.repository.JpaRepository



interface CategoryRepository: JpaRepository<Category,Long>{
}