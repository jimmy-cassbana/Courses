package jimmy.maazady.data.repository

import jimmy.maazady.base.BaseRepository
import jimmy.maazady.data.remote.MazadiAPI

class SearchRepository(private val api: MazadiAPI): BaseRepository() {

    suspend fun getCategories() = handleResponse { api.getCategories() }
    suspend fun getProperties(catId: Int) = handleResponse { api.getProperties(catId) }
    suspend fun getOptions(propertyId: Int) = handleResponse { api.getOptionsChild(propertyId) }
}