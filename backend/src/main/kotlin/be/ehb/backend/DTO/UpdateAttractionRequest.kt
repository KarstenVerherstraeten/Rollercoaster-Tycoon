data class UpdateAttractionRequest(
    val name: String?,
    val buildYear: Int?,
    val capacity: Int?,
    val picture: String?,
    val video: String?,
    val minHeight: Int?,
    val maxHeight: Int?,
    val fastPass: Boolean?,
    val disabled: Boolean?,
    val description: String?,
    val maintenancePeriod: Long?,
    val categoryName: String?
)
