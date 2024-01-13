package jimmy.maazady.data.model

data class Response<T>(
       val status: Int,
       val msg: String,
       val data: T
)