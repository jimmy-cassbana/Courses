package jimmy.maazady.data.remote

import jimmy.maazady.data.model.CategoriesResponse
import jimmy.maazady.data.model.Property
import jimmy.maazady.data.model.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MazadiAPI {

    @GET("get_all_cats")
    suspend fun getCategories(): Response<CategoriesResponse>

    @GET("properties")
    suspend fun getProperties(@Query("cat") catId: Int): Response<List<Property>>

    @GET("get-options-child/{id}")
    suspend fun getOptionsChild(@Path("id") id: Int): Response<List<Property>>
}