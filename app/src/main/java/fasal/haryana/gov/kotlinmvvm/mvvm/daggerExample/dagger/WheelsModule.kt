package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.dagger

import dagger.Module
import dagger.Provides
import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.Wheels

/*we need to provide this module to the component so that the dagger will now this */
/*this is to use to create or to Inject*/
@Module
class WheelsModule {

    @Provides
    fun provideswheels():Wheels{
        println("Wheels Module returning")
        return Wheels()
    }
}