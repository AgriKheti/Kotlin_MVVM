package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample

import javax.inject.Inject

class Car @Inject constructor(
    private var wheels: Wheels,
    private var engine: Engine
) {

    fun startCar(){
        this.engine.startEngine()
        println("driving..")
    }
}