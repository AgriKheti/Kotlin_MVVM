package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.dagger

import dagger.Module
import dagger.Provides
import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.Engine

@Module
class PetrolEngineModule {

    @Provides
    fun providesPetrolEngineDetails(petrolEngine: PetrolEngine):Engine{
        return petrolEngine
    }

}