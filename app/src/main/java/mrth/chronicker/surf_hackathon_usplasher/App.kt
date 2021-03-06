package mrth.chronicker.surf_hackathon_usplasher

import android.app.Application
import mrth.chronicker.surf_hackathon_usplasher.data.networkModule
import mrth.chronicker.surf_hackathon_usplasher.domain.interactorModule
import mrth.chronicker.surf_hackathon_usplasher.ui.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDi()
    }

    private fun initDi() {
        startKoin {
            androidContext(this@App)

            modules(networkModule)
            modules(interactorModule)
            modules(uiModule)
        }
    }
}