package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample

import javax.inject.Inject

class Car @Inject constructor(
    private var engine: Engine
)

{
    /*injecting field directly as , Car class object is created by dagger so no need to tell dagger*/
    /*just put the inject notation it will inject*/
    @Inject
    lateinit var wheels: Wheels

    /*this is called method injection*/
    /*remote will not throw null as we are injecting it, it will auto create the remote object
     else it will throw null as we have not intilized it */
    @Inject
    fun provideCarToRemote(remote: Remote){
        return remote.provideCar(this)
    }

    fun startCar(){

        println("Wheels obj is : $wheels")
        this.engine.startEngine()
        println("driving..")
    }
}