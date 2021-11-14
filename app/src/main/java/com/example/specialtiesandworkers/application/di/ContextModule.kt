package com.example.specialtiesandworkers.application.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(private val applicationContext: Context) {

    @Provides
    fun provideApplicationContext(): Context {
        return applicationContext
    }

}