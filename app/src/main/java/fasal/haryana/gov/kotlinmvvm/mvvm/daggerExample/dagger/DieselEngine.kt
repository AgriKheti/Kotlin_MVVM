package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.dagger

import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.Engine
import javax.inject.Inject

class DieselEngine : Engine {

    @Inject
    constructor(){

    }
    override fun startEngine() {
        println("Diesel Engine Started")
    }
}