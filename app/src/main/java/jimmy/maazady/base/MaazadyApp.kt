package jimmy.maazady.base

import android.app.Application
import jimmy.maazady.di.networkModule
import jimmy.maazady.di.repositoryModule
import jimmy.maazady.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MaazadyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MaazadyApp)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }
}