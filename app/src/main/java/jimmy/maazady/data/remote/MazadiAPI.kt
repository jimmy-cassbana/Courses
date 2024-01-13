package jimmy.maazady.data.remote

import jimmy.maazady.data.model.CategoriesResponse
import jimmy.maazady.data.model.Property
import jimmy.maazady.data.model.Response
import retrofit2.http.*

interface MazadiAPI {

    @Headers("Accept-Language:en")
    @GET("get_all_cats")
    suspend fun getCategories(): Response<CategoriesResponse>

    @Headers("Accept-Language:en")
    @GET("properties")
    suspend fun getProperties(@Query("cat") catId: Int): Response<ArrayList<Property>>

    @Headers("Accept-Language:en")
    @GET("get-options-child/{id}")
    suspend fun getOptionsChild(@Path("id") id: Int): Response<ArrayList<Property>>
}