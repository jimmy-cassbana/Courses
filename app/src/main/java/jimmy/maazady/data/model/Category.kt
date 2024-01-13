package jimmy.maazady.data.model

data class Category(val id: Int, val name: String, val children: List<Children>)
data class Children(val id: Int, val name: String)