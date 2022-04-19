package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fasal.haryana.gov.kotlinmvvm.R
import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.dagger.DaggerCarComponent
import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.dagger.PetrolEngineModule
import javax.inject.Inject

class DaggerActivity : AppCompatActivity() {

    /*injecting Field in Activity so no need to initilize it */
    /*we are directly using car object as it is injecting*/

    @Inject
     lateinit var car: Car

//     @Inject  it will auto create and call funtions of Dagger  as we have created the object like "println() fun "
//     lateinit var car1:Car
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)


//        @C implementation for passing Int value while injecting
           val carComponent= DaggerCarComponent.builder()
               .petrolEngineModule(PetrolEngineModule(100)).build()
                 carComponent.injectMainActivityforFieldInject(this)
              car.startCar()


        //@B-Implementation injecting
//        val carComponent = DaggerCarComponent.create()
//        carComponent.injectMainActivityforFieldInject(this)
//        car.startCar()

    //@A-Implementation
        // manually injecting this way
//        var wheels=Wheels()
//        var engine=Engine()
//        car= Car(wheels,engine)
//        car.startCar()
    }
}