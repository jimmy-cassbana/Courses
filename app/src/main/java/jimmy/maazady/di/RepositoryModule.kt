package jimmy.maazady.di

import jimmy.maazady.data.repository.SearchRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { SearchRepository(get()) }
}