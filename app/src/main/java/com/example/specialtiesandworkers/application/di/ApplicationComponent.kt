package com.example.specialtiesandworkers.application.di

import com.example.specialtiesandworkers.data.database.di.DatabaseModule
import com.example.specialtiesandworkers.data.network.di.NetworkModule
import com.example.specialtiesandworkers.domain.usecase.LoadSpecialtyUseCase
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, NetworkModule::class, DatabaseModule::class])
interface ApplicationComponent {

    fun getLoadSpecialtyUseCase(): LoadSpecialtyUseCase

}