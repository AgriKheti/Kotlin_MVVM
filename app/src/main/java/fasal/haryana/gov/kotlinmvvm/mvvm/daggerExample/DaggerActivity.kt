package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fasal.haryana.gov.kotlinmvvm.R
import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.dagger.DaggerCarComponent
import javax.inject.Inject

class DaggerActivity : AppCompatActivity() {

    /*injecting Field in dagger*/
    @Inject
     lateinit var car: Car

     @Inject
     lateinit var car1:Car
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)


        //@B-Implementation injecting
        var carComponent = DaggerCarComponent.create()
        carComponent.injectMainActivityforFieldInject(this)

        car.startCar()
        car1.startCar()


    //@A-Implementation
        // manually injecting this way
//        var wheels=Wheels()
//        var engine=Engine()
//        car= Car(wheels,engine)
//        car.startCar()
    }
}