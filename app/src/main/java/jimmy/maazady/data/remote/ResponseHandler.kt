package jimmy.maazady.data.remote

import jimmy.maazady.data.model.Response
import retrofit2.HttpException
import java.io.IOException
import java.lang.IllegalStateException

class ResponseHandler {

    companion object {

        fun <T> handleSuccess(response: Response<T>): Resource<T> {
            return Resource.Success(response.data)
        }

        fun <T> handleException(ex: Exception): Resource<T> {
            return Resource.Error(getErrorMessage(ex))
        }

        private fun getErrorMessage(ex: Exception) =
                when(ex) {
                    is IOException -> "Please check internet connection"
                    is IllegalStateException -> "Response parsing error"
                    is HttpException -> getErrorForCode(ex.code())
                    else -> ex.message!!
                }

        private fun getErrorForCode(code: Int) =
                when(code) {
                    401 -> "Unauthorised access"
                    404 -> "Data not found"
                    500 -> "Internal server error"
                    else -> "Something went wrong"
                }
    }
}