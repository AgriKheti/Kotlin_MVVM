package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.dagger

import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.Engine
import javax.inject.Inject

class PetrolEngine @Inject constructor() :Engine {

    override fun startEngine() {
        println("Petrol Engine Started")
    }
}