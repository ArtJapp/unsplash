package mrth.chronicker.surf_hackathon_usplasher.domain

import org.koin.dsl.module

@JvmField
val interactorModule = module {

    single {
        UsplashInteractor(get())
    }
}