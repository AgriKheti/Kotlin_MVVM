package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.dagger

import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.Engine
import javax.inject.Inject
/*initilizing funtionality of Int, float while Injecting*/
class PetrolEngine @Inject constructor(var powerCapacity:Int) :Engine {

    override fun startEngine() {
        println("Petrol Engine Started $powerCapacity")
    }
}