package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.dagger

import dagger.Module
import dagger.Provides
import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.Engine
import javax.inject.Inject

@Module
class DieselEngineModule {


    @Provides
    fun providesDieselEngineDetails(dieselEngine: DieselEngine):Engine{
        return dieselEngine
    }

}