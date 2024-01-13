package jimmy.maazady.data.model

data class Property(
    val id: Int,
    val name: String,
    val parent: Int,
    val child: Boolean,
    val options: List<Property>
)
