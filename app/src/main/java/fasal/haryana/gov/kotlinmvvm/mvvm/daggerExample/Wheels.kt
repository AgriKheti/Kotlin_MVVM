package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample

import javax.inject.Inject


/*assuming wheel is not our class it is a third party class*/
/*so we can not notate @inject in directly in third party class*/
/*so in that case dagger will use wheelModule class to create object of third party class
* or interface */

class Wheels @Inject constructor(private var rims: Rims
      , private var tyres: Tyres) {
    /*now suppose wheel is dependent on two more objects*/


}