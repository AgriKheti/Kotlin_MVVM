package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.dagger

import dagger.Module
import dagger.Provides
import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.Rims
import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.Tyres
import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.Wheels

/*we need to provide this module to the component so that the dagger will now this */
/*this is to use to create or to Inject*/
@Module
class WheelsModule {



     /*this implementation to create Rims*/
    @Provides
    fun provideRims():Rims{
         println("Rims Module returning")
        return Rims()
    }

    /*this implementation to create Tyres*/
    @Provides
    fun provideTyres():Tyres{
        println("Tyres Module returning")
        return Tyres()
    }


    /*this implementation to create Wheels*/
    @Provides
    fun provideswheels(rims: Rims,tyres: Tyres):Wheels{
        println("Wheels Module returning")
        return Wheels(rims,tyres)
    }
}