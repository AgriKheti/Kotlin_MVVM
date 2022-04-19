package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.dagger

import dagger.Module
import dagger.Provides
import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.Engine

@Module
class PetrolEngineModule (var powerCapacity:Int){

    @Provides
    fun providesPetrolEngineDetails():Engine{
        return PetrolEngine(powerCapacity)
    }

}