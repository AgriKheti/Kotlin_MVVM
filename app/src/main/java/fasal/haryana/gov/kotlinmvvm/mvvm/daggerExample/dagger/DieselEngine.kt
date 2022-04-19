package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.dagger

import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.Engine
import javax.inject.Inject

class DieselEngine @Inject constructor() : Engine {

    override fun startEngine() {
        println("Diesel Engine Started")
    }
}