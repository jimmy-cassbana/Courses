package jimmy.maazady.data.model

data class Response<T>(
       val code: Int,
       val msg: String,
       val data: T
)