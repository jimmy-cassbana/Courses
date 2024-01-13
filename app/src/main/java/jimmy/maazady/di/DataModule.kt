package jimmy.maazady.di

import jimmy.maazady.data.remote.MazadiAPI
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://staging.mazaady.com/api/"

val networkModule = module {
    single { provideOkHttpClient() }
    single { provideBoxesApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder().build()

fun provideBoxesApi(retrofit: Retrofit): MazadiAPI = retrofit.create(MazadiAPI::class.java)