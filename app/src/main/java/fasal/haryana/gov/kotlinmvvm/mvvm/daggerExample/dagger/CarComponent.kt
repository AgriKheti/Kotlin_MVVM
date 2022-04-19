package fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.dagger

import dagger.Component
import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.Car
import fasal.haryana.gov.kotlinmvvm.mvvm.daggerExample.DaggerActivity
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.main.MainActivity

@Component(modules = [PetrolEngineModule::class])
interface CarComponent {

    fun getcar() :Car
    fun injectMainActivityforFieldInject(daggerActivity: DaggerActivity)
}