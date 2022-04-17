package fasal.haryana.gov.kotlinmvvm.mvvm

import android.app.Application
import fasal.haryana.gov.kotlinmvvm.mvvm.preferences.Preferences
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth.AuthViewModelFactory
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.db.entities.AppDatabase
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.MyApis
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.NetworkConnectionInterceptor
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.repositories.UserRepository
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.home.profile.ProfileViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication :Application(),KodeinAware {
    override val kodein= Kodein.lazy {

        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind()from singleton { MyApis(instance()) }
        bind()from singleton { AppDatabase(instance()) }
        bind() from singleton { Preferences(instance()) }
        bind() from singleton{ UserRepository(instance(),instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }

    }

}