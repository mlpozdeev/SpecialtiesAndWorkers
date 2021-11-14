package com.example.specialtiesandworkers.application.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class])
interface ApplicationComponent {

}