package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.dagger

import dagger.Module
import dagger.Provides
import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.Engine

@Module
class DieselEngineModule {

    @Provides
    fun providesPetrolEngineDetails(dieselEngine: DieselEngine):Engine{
        return dieselEngine
    }

}