package jimmy.maazady.base

import jimmy.maazady.data.remote.Resource
import jimmy.maazady.data.model.Response
import jimmy.maazady.data.remote.ResponseHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

open class BaseRepository {

    suspend fun <T> handleResponse(apiMethod: suspend () -> Response<T>): Resource<T> =
            withContext(Dispatchers.IO) {
                try {
                    ResponseHandler.handleSuccess(apiMethod())
                } catch (ex: Exception) {
                    ex.printStackTrace()
                    ResponseHandler.handleException(ex)
                }
            }
}