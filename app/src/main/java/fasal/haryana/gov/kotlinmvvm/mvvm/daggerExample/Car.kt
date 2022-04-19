package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample

import javax.inject.Inject

class Car {

    private lateinit var wheels: Wheels
    private lateinit var engine: Engine

    @Inject
    constructor(wheels: Wheels,engine: Engine){
        this.wheels=wheels
        this.engine=engine
    }

    fun startCar(){
        println("driving..")
    }
}