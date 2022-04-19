package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample

import javax.inject.Inject

/*this is e.g of method injecting*/
class Remote @Inject constructor() {
    fun provideCar(car: Car){
        println("Car received in Remote from Car class")
    }
}