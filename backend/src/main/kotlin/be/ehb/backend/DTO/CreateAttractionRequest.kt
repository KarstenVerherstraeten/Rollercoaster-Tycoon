package be.ehb.backend.DTO

import java.sql.Date

data class CreateAttractionRequest(
    val name: String,
    val buildYear: Int,
    val capacity: Int,
    val picture: String?,
    val video: String?,
    val minHeight: Int,
    val maxHeight: Int,
    val fastPass: Boolean,
    val disabled: Boolean,
    val description: String,
    val maintenancePeriod: Date?,
    val categoryName: String?
)