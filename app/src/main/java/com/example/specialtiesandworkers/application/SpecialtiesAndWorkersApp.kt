package com.example.specialtiesandworkers.application

import android.app.Application
import com.example.specialtiesandworkers.application.di.ApplicationComponent
import com.example.specialtiesandworkers.application.di.ContextModule
import com.example.specialtiesandworkers.application.di.DaggerApplicationComponent

class SpecialtiesAndWorkersApp : Application() {

    lateinit var applicationComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(applicationContext))
            .build()
    }

}